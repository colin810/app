package kuan.colin.com.app.Config;

/**
 * Created by 11 on 2016/7/11.
 */
public class Config {

    public enum EnvConfig {
        PROD(true),
        DEMO(false);

        protected Boolean ENV;

        EnvConfig(Boolean envConfig) {
            ENV = envConfig;
        }
    }

    private final static EnvConfig envConfig = EnvConfig.PROD;
    private static Env env = null;

    static {
        if (envConfig.ENV) {
            env = new ProdEnv();
        } else {
            env = new DemoEnv();
        }
    }

    public static String getApikey() {
        return env.getApikey();
    }

    public static String getHost() {
        return env.getHost();
    }

    public static String getBaseUrl() {
        return String.format("http://%s/", getHost());
    }
}