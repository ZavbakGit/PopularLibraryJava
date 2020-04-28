package fun.gladkikh.app.popularlibraryjava.lesson5.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fun.gladkikh.app.popularlibraryjava.lesson5.room.intite.User;
import io.reactivex.Single;

@Dao
public interface UserDao {
    @Insert
    Single<Long> insert(User fruit);

    @Insert
    Single<List<Long>> insertList(List<User> users);

    @Query("SELECT * FROM table_user")
    Single<List<User>> getAll();

    @Update
    Single<Integer> update(User user);

    @Delete
    Single<Integer> delete(User user);
}
