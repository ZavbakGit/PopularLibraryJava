package fun.gladkikh.app.popularlibraryjava.lesson4.task2.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fun.gladkikh.app.popularlibraryjava.lesson4.task2.domain.data.User;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitApi {

   private Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

   private GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

    private RetrofitService api = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(RetrofitService.class);


    public Single<User> getUser(String nickname) {
        return api.getUser(nickname).subscribeOn(Schedulers.io());
    }
}
