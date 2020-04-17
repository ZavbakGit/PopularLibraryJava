package fun.gladkikh.app.popularlibraryjava.lesson2.task3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    private Disposable disposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void onClickSubscribe(View view) {

        if (disposable != null && !disposable.isDisposed()){
            return;
        }

        disposable = Observable.interval(1, TimeUnit.SECONDS)
                .doOnNext(aLong ->
                        Log.d(Constants.TAG, "Mess - " + aLong + " " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong ->
                        Log.d(Constants.TAG, "Mess - " + aLong + " " + Thread.currentThread().getName()));

    }

    public void onClickUnsubscribe(View view) {
        if (disposable != null){
            disposable.dispose();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (disposable != null){
            disposable.dispose();
        }
    }
}
