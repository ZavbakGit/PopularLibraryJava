package fun.gladkikh.app.popularlibraryjava.lesson5.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fun.gladkikh.app.popularlibraryjava.lesson5.App;
import fun.gladkikh.app.popularlibraryjava.lesson5.room.UserDao;
import fun.gladkikh.app.popularlibraryjava.lesson5.room.intite.User;
import fun.gladkikh.app.popularlibraryjava.lesson5.view.MyView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants.TAG;

public class Presenter {
    private UserDao userDao;
    private MyView view;

    public Presenter(MyView view) {
        userDao = App.getAppDatabase().userDao();
        this.view = view;
    }


    @SuppressLint("CheckResult")
    public void insert() {
        userDao.insert(getNewUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "insert: " + id);
                }, throwable -> {
                    Log.d(TAG, "insert: " + throwable);
                });
    }

    @SuppressLint("CheckResult")
    public void showUsers() {
        listFlowableUser()
                .firstOrError()
                .map(users -> {
                    StringBuilder message = new StringBuilder();
                    for (User user : users) {
                        message.append(user.toString()).append("\n");
                    }
                    return message.toString();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(message -> {
                            view.showMessage(message);
                        },
                        throwable -> {
                            Log.d(TAG, throwable.toString());
                        });
    }

    @SuppressLint("CheckResult")
    public void insertSeveral() {
        List<User> list = new ArrayList<>();
        list.add(getNewUser());
        list.add(getNewUser());
        list.add(getNewUser());

        userDao.insertList(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "insert list: " + id);
                }, throwable -> {
                    Log.d(TAG, "insert list: " + throwable);
                });
    }


    @SuppressLint("CheckResult")
    public void getAllUser() {
        listFlowableUser()
                .flatMap(users -> Flowable.fromIterable(users))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> Log.d(TAG, user.toString()),
                        throwable -> {
                            Log.d(TAG, throwable.toString());
                        });
    }


    @SuppressLint("CheckResult")
    public void delete() {
        listFlowableUser()
                .flatMap(users -> Flowable.fromIterable(users))
                .firstOrError()
                .flatMap(user -> userDao.delete(user)
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "delete: " + id);
                }, throwable -> {
                    Log.d(TAG, throwable.toString());
                });
    }

    @SuppressLint("CheckResult")
    public void update() {
        listFlowableUser()
                .flatMap(users -> Flowable.fromIterable(users))
                .firstOrError()
                .map(user -> {
                    user.name = "update name " + new Random().nextInt();
                    return user;
                })
                .flatMap(user -> userDao.update(user)
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "delete: " + id);
                }, throwable -> {
                    Log.d(TAG, throwable.toString());
                });
    }


    private Flowable<List<User>> listFlowableUser() {
        return userDao.getAll().toFlowable();
    }


    private User getNewUser() {
        User user = new User();
        user.age = new Random().nextInt();
        user.name = "Name " + new Random().nextInt();
        user.surname = "Surname  " + +new Random().nextInt();

        return user;
    }
}
