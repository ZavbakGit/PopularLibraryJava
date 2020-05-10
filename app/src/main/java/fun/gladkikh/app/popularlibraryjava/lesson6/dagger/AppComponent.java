package fun.gladkikh.app.popularlibraryjava.lesson6.dagger;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ColorModule.class})
public interface AppComponent {

    void inject(DaggerActivityLesson6 daggerActivityLesson6);
}
