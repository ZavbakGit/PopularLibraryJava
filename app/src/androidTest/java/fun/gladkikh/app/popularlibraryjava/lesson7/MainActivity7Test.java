package fun.gladkikh.app.popularlibraryjava.lesson7;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

import fun.gladkikh.app.popularlibraryjava.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivity7Test extends TestCase {
    @Rule
    public ActivityTestRule<MainActivity7> activityRule = new ActivityTestRule<>(MainActivity7.class);

    @Test
    public void testOnClick() {
        activityRule.launchActivity(new Intent());

        onView(withId(R.id.btStart)).perform(click());
        onView(withId(R.id.tvMessage)).check(matches(withText("espresso-тест")));
    }

}