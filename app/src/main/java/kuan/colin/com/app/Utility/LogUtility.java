package kuan.colin.com.app.Utility;

import android.util.Log;

/**
 * Created by 11 on 2016/7/12.
 */
public class LogUtility {

    public enum User {
        COLIN("colin");

        private String username;

        User(String name) {
            username = name;
        }
    }

    private final static Integer VERBOSE = 1;
    private final static Integer DEBUG = 2;
    private final static Integer INFO = 3;
    private final static Integer WARN = 4;
    private final static Integer ERROR = 5;
    private final static Integer NOTHING = 6;

    private final static Integer _level = VERBOSE;
    private final static User _user = User.COLIN;

    public static void v(String tag, String msg) {
        if (_level <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void v(String msg) {
        if (_level <= VERBOSE) {
            Log.v(_user.username, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (_level <= DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void d(String msg) {
        if (_level <= DEBUG) {
            Log.d(_user.username, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (_level <= INFO) {
            Log.i(tag, msg);
        }
    }

    public static void i(String msg) {
        if (_level <= INFO) {
            Log.i(_user.username, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (_level <= WARN) {
            Log.w(tag, msg);
        }
    }

    public static void w(String msg) {
        if (_level <= WARN) {
            Log.w(_user.username, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (_level <= ERROR) {
            Log.e(tag, msg);
        }
    }

    public static void e(String msg) {
        if (_level <= ERROR) {
            Log.e(_user.username, msg);
        }
    }
}
