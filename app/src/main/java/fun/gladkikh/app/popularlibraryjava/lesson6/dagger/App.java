package fun.gladkikh.app.popularlibraryjava.lesson6.dagger;

import android.app.Application;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponent generateAppComponent() {
        //чтобы подтянулся DaggerAppComponent, необходимо сбилдить проект
        return DaggerAppComponent
                .builder()
                .build();
    }
}
