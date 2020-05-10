package fun.gladkikh.app.popularlibraryjava.lesson6.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fun.gladkikh.app.popularlibraryjava.lesson6.di.Green;
import fun.gladkikh.app.popularlibraryjava.lesson6.di.Red;
import fun.gladkikh.app.popularlibraryjava.lesson6.di.ShowColor;
import fun.gladkikh.app.popularlibraryjava.lesson6.di.White;

@Module
public class ColorModule {
    @Singleton
    @Provides
    ShowColor provideShowColor() {
        return new Green();
    }

    @Singleton
    @Provides
    Red provideRed(ShowColor ShowColor) {
        return new Red(ShowColor);
    }

    @Singleton
    @Provides
    White provideWhite(ShowColor ShowColor) {
        return new White(ShowColor);
    }
}
