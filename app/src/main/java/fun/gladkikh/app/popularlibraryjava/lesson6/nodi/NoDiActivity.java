package fun.gladkikh.app.popularlibraryjava.lesson6.nodi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import fun.gladkikh.app.popularlibraryjava.R;

import static fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants.TAG;

public class NoDiActivity extends AppCompatActivity {

    Red red;
    White white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_6_activity_no_di);


        red = new Red();
        white = new White();

        Log.d(TAG, red.toString());
        Log.d(TAG, white.toString());
    }
}
