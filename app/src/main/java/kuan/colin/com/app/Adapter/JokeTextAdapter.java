package kuan.colin.com.app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kuan.colin.com.app.Entity.JokeText;
import kuan.colin.com.app.R;

/**
 * Created by 11 on 2016/7/21.
 */
public class JokeTextAdapter extends RecyclerView.Adapter<JokeTextAdapter.MyViewHolder> {

    protected List<JokeText.ShowapiResBodyBean.ContentlistBean> contentlistBeen;

    public JokeTextAdapter(List<JokeText.ShowapiResBodyBean.ContentlistBean> contentlistBeen) {
        this.contentlistBeen = contentlistBeen;
    }


    @Override
    public JokeTextAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_text_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JokeTextAdapter.MyViewHolder holder, int position) {
        holder.tv_joke.setText(Html.fromHtml(contentlistBeen.get(position).getText()));
    }

    @Override
    public int getItemCount() {
        return contentlistBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_joke;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_joke = (TextView) itemView.findViewById(R.id.tv_joke);
        }
    }

    public boolean addItem(int position, JokeText.ShowapiResBodyBean.ContentlistBean contentlistBean) {
        this.contentlistBeen.add(position, contentlistBean);
        notifyItemInserted(position);
        return true;
    }

    public boolean addList(List<JokeText.ShowapiResBodyBean.ContentlistBean> contentlistBeanList) {
        contentlistBeen.addAll(contentlistBeanList);
        notifyDataSetChanged();
        return true;
    }

}