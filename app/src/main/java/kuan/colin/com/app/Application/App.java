package kuan.colin.com.app.Application;

import android.app.Application;
import android.content.Context;

/**
 * Created by 11 on 2016/7/11.
 */
public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        this.context = getApplicationContext();
        super.onCreate();
    }

    public static Context getContext() {
        return context;
    }
}
