package fun.gladkikh.app.popularlibraryjava.lesson2.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants;

public class MainActivity extends AppCompatActivity {

    private MyAsyncTask myTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClickButton(View view) {
        myTask = new MyAsyncTask();
        myTask.execute();
        Log.d(Constants.TAG, "onClickButton: " + Thread.currentThread().getName());
    }


    private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(Constants.TAG, "onPreExecute: " + Thread.currentThread().getName());
        }

        @Override
        protected Void doInBackground(Void... voids) {


            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(Constants.TAG, "doInBackground: " + Thread.currentThread().getName() + ": " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(Constants.TAG, "onPostExecute: " + Thread.currentThread().getName());

        }
    }
}
