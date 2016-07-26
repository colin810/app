package kuan.colin.com.app.Interface;

import kuan.colin.com.app.Entity.JokePic;
import kuan.colin.com.app.Entity.JokeText;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 11 on 2016/7/12.
 */

public interface IBaiduApi {

    @GET("showapi_open_bus/showapi_joke/joke_pic")
    Call<JokePic> getJokePic(@Query("page") int page);

    @GET("showapi_open_bus/showapi_joke/joke_text")
    Call<JokeText> getJokeText(@Query("page") int page);

    @GET("showapi_open_bus/showapi_joke/joke_pic")
    Observable<JokePic> getJokePicRxjava(@Query("page") int page);

    @GET("showapi_open_bus/showapi_joke/joke_text")
    Observable<JokeText> getJokeTextRxjava(@Query("page") int page);

}
