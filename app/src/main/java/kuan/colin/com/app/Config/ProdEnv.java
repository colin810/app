package kuan.colin.com.app.Config;

/**
 * Created by 11 on 2016/7/11.
 */
public class ProdEnv implements Env {

    private final static String apikey = "90a700f9e163f262224609067a5fad0e";
    private final static String host = "apis.baidu.com";

    @Override
    public String getApikey() {
        return apikey;
    }

    @Override
    public String getHost() {
        return host;
    }
}