package fun.gladkikh.app.popularlibraryjava.lesson4.task2.remote;

import fun.gladkikh.app.popularlibraryjava.lesson4.task2.domain.data.User;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/users/{username}")
    Single<User> getUser(
            @Path("username") String userName
    );
}
