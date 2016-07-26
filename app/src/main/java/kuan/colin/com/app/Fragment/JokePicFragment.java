package kuan.colin.com.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kuan.colin.com.app.R;

/**
 * Created by 11 on 2016/7/25.
 */
public class JokePicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.joke_pic_list, null);
        return view;
    }

}
