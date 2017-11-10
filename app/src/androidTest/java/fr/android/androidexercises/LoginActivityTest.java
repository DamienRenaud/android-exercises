package fr.android.androidexercises;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void shouldTryLoginAndSuccess() throws Exception {
        // TODO test login
        onView(withId(R.id.usernameEdit)).perform(typeText("b@xebia.fr"));
        onView(withId(R.id.passwordEdit)).perform(typeText("password"), closeSoftKeyboard());

        onView(withId(R.id.loginButton)).perform(click());

        onView(withId(R.id.loggedText)).check(matches(isDisplayed()));


    }
}