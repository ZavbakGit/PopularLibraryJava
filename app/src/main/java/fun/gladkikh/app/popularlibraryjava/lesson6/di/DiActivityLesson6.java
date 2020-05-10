package fun.gladkikh.app.popularlibraryjava.lesson6.di;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import fun.gladkikh.app.popularlibraryjava.R;

import static fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants.TAG;

public class DiActivityLesson6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di_lesson6);

        Green green = new Green();
        Red red = new Red(green);
        White white = new White(green);

        Log.d(TAG, red.toString());
        Log.d(TAG, white.toString());

    }
}
