package fun.gladkikh.app.popularlibraryjava.lesson5.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fun.gladkikh.app.popularlibraryjava.lesson5.room.intite.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
