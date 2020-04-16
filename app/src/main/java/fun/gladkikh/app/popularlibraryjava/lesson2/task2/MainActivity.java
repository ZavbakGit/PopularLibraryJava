package fun.gladkikh.app.popularlibraryjava.lesson2.task2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants;

public class MainActivity extends AppCompatActivity implements Observer {

    private final SoursSpam soursSpam = new SoursSpam();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void onClickSubscribe(View view) {
        soursSpam.addObserver(this);
    }

    public void onClickUnsubscribe(View view) {
        soursSpam.deleteObservers();
    }

    public void onClickSpam(View view) {
        soursSpam.send();
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof SoursSpam) {
            Log.d(Constants.TAG,((SoursSpam) observable).getSpam().getMessage());
        }
    }
}
