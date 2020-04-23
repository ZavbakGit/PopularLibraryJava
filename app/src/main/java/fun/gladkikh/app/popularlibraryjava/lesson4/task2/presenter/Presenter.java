package fun.gladkikh.app.popularlibraryjava.lesson4.task2.presenter;

import fun.gladkikh.app.popularlibraryjava.lesson4.task2.domain.data.User;
import fun.gladkikh.app.popularlibraryjava.lesson4.task2.remote.RetrofitApi;
import io.reactivex.Single;

public class Presenter {

    private RetrofitApi retrofitApi;

    public Presenter() {
        retrofitApi = new RetrofitApi();
    }

    public Single<User> getUser(String nickname){
        return retrofitApi.getUser(nickname);
    }

}
