package kuan.colin.com.app.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 11 on 2016/6/27.
 */
public abstract class BaseActivity extends Activity {

    protected ArrayList<Activity> list = new ArrayList<Activity>();
    protected long last_time = 0;

    protected boolean NO_TITLE = false;
    protected boolean FULLSCREEN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //屏蔽标题栏
        if (NO_TITLE) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        // 全屏显示
        if (FULLSCREEN) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        super.onCreate(savedInstanceState);
        list.add(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        list.remove(this);
    }

    @Override
    public void onBackPressed() {
        if (list.size() == 1) {
            long curr_time = System.currentTimeMillis();
            if (curr_time - last_time < 2000) {
                System.exit(0);
            } else {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            }
            last_time = curr_time;
        } else {
            super.onBackPressed();
        }
    }
}
