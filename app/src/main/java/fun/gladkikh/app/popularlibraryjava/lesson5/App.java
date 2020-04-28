package fun.gladkikh.app.popularlibraryjava.lesson5;

import android.app.Application;

import androidx.room.Room;

import fun.gladkikh.app.popularlibraryjava.lesson5.room.AppDatabase;


public class App extends Application {

    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_database").build();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
