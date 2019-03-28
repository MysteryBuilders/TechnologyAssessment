package com.mysterybuilders.technologyassessment;

import android.content.Intent;
import android.test.InstrumentationTestCase;

import com.mysterybuilders.technologyassessment.activity.MainActivity;
import com.mysterybuilders.technologyassessment.applicationHelper.Constants;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;



@RunWith(AndroidJUnit4.class)
public class RetrofitCallTest extends InstrumentationTestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class, true, false);
    private MockWebServer server;


    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        Constants.Extra.BASE_URL= server.url("/").toString();
    }

    @Test
    public void testQuoteIsShown() throws Exception {
        String fileName = "quote_200_ok_response.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
      
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);


        Espresso.onView(ViewMatchers.withText("A couple at a “cowboy church” service at the Nebraska State Fair in Grand Island")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


    @Test
    public void testRetryButtonShowsWhenError() throws Exception {
        String fileName = "quote_404_not_found.json";

        server.enqueue(new MockResponse()
                .setResponseCode(404)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);


        Espresso. onView(ViewMatchers.withText("Not found")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }
}
