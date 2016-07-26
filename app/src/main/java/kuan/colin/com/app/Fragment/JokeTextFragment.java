package kuan.colin.com.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import kuan.colin.com.app.Adapter.JokeTextAdapter;
import kuan.colin.com.app.Application.App;
import kuan.colin.com.app.Entity.JokeText;
import kuan.colin.com.app.R;
import kuan.colin.com.app.Utility.BaiduApiService;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by 11 on 2016/7/25.
 */
public class JokeTextFragment extends Fragment {

    protected Subscription subscription = null;
    protected JokeTextAdapter adapter = null;
    protected XRecyclerView xRecyclerView;
    protected int curr_page = 0;
    protected boolean loadding = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.joke_text_list, null);

        xRecyclerView = (XRecyclerView) view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(linearLayoutManager);
        xRecyclerView.setItemAnimator(new DefaultItemAnimator());

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                curr_page = 0;
                adapter = null;
                loadData();
            }

            @Override
            public void onLoadMore() {
                loadData();
            }
        });
        loadData();
        return view;
    }

    protected boolean loadData() {
        if (loadding) {
            return false;
        }
        loadding = true;
        subscription = BaiduApiService.getInstance().getJokeTextRxjava(curr_page).cache()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<JokeText>() {
                    @Override
                    public void call(JokeText jokeText) {
                        if (adapter == null) {
                            adapter = new JokeTextAdapter(jokeText.getShowapi_res_body().getContentlist());
                            xRecyclerView.setAdapter(adapter);
                            xRecyclerView.refreshComplete();
                        } else {
                            adapter.addList(jokeText.getShowapi_res_body().getContentlist());
                            xRecyclerView.loadMoreComplete();
                        }
                        curr_page++;
                        loadding = false;
                    }
                });
        return true;
    }

    @Override
    public void onDestroyView() {
        // 取消订阅，以免activity销毁之后，callback调用activity
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.onDestroyView();
    }
}
