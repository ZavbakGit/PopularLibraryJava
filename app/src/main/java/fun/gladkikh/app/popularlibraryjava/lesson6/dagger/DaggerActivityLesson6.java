package fun.gladkikh.app.popularlibraryjava.lesson6.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson6.di.Red;
import fun.gladkikh.app.popularlibraryjava.lesson6.di.White;

import static fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants.TAG;

public class DaggerActivityLesson6 extends AppCompatActivity {
    @Inject
    Red red;
    @Inject
    White white;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_lesson6);

        App.getAppComponent().inject(this);

        Log.d(TAG, "dagger " +red.toString());
        Log.d(TAG, "dagger " + white.toString());
    }
}
