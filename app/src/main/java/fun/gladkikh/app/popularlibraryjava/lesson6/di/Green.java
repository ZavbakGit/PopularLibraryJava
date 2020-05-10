package fun.gladkikh.app.popularlibraryjava.lesson6.di;

import android.util.Log;

import static fun.gladkikh.app.popularlibraryjava.lesson2.common.Constants.TAG;

public class Green implements ShowColor {
    @Override
    public void show() {
        Log.d(TAG, "Green");
    }
}
