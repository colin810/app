package kuan.colin.com.app.Utility;

import java.io.IOException;

import kuan.colin.com.app.Config.Config;
import kuan.colin.com.app.Interface.IBaiduApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 11 on 2016/7/13.
 */
public class BaiduApiService {

    private BaiduApiService() {
    }

    private static IBaiduApi baiduService = null;

    public static IBaiduApi getInstance() {
        if (baiduService == null) {
            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder().addHeader("apikey", Config.getApikey()).build();
                    return chain.proceed(request);
                }
            };
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Config.getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
            baiduService = retrofit.create(IBaiduApi.class);
        }
        return baiduService;
    }
}
