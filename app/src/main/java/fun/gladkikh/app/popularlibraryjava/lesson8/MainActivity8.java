package fun.gladkikh.app.popularlibraryjava.lesson8;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        Button btStart =  findViewById(R.id.btStart);

        btStart.setOnClickListener(v -> {
            new Thread(() -> {
                for (int i = 0; i < 20; i++) {
                    Log.d(Constants.TAG, Thread.currentThread().getName() + "Tik Tak");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}
