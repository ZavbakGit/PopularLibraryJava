package fun.gladkikh.app.popularlibraryjava.lesson4.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lesson4_1);

        String json ="{\"time_of_year\": \"summer\", \"year\": 2019}";

        Gson gson = new GsonBuilder().create();
        InformationByTime informationByTime = gson.fromJson(json, InformationByTime.class);

        Log.d(Constants.TAG,informationByTime.toString());
    }


}
