package fun.gladkikh.app.popularlibraryjava;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("s");


        Single.just(list)
                .toFlowable()
                .flatMap(strings -> {
                   return   Flowable.fromIterable(strings);
                })
                .doOnNext(o -> {
                    System.out.println(o);
                });


        assertEquals(4, 2 + 2);
    }
}