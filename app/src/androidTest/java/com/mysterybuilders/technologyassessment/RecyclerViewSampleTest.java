package com.mysterybuilders.technologyassessment;

import com.mysterybuilders.technologyassessment.activity.MainActivity;
import com.mysterybuilders.technologyassessment.adaptor.NewsAdaptor;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

public class RecyclerViewSampleTest {
    private static final int ITEM_BELOW_THE_FOLD = 5;

    /**
     * Use {@link androidx.test.core.app.ActivityScenario} to create and launch the activity under test. This is a
     * replacement for {@link androidx.test.rule.ActivityTestRule}.
     */
    @Before
    public void launchActivity() {
        ActivityScenario.launch(MainActivity.class);
    }
    @Test
    public void testOnClickButtonRecyclerView() throws InterruptedException {
        Thread.sleep(5000);
        Espresso. onView(ViewMatchers.withId(R.id.recycler_view_employee_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, ViewActions.click()));
    }
    @Test
    public void scrollToItemBelowFold_checkItsText()  throws InterruptedException{
        Thread.sleep(5000);
        // First scroll to the position that needs to be matched and click on it.
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_employee_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, ViewActions.click()));


           }

    @Test
    public void itemInMiddleOfList_hasSpecialText()  throws InterruptedException{
        Thread.sleep(5000);
        // First, scroll to the view holder using the isInTheMiddle matcher.
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_employee_list))
                .perform(RecyclerViewActions.scrollToHolder(isInTheMiddle()));

        // Check that the item has the special text.
    }

    /**
     * Matches the {@link NewsAdaptor.EmployeeViewHolder}s in the middle of the list.
     */
    private static Matcher<NewsAdaptor.EmployeeViewHolder> isInTheMiddle() {
        return new TypeSafeMatcher<NewsAdaptor.EmployeeViewHolder>() {
            @Override
            protected boolean matchesSafely(NewsAdaptor.EmployeeViewHolder customHolder) {
                return customHolder.getIsInTheMiddle();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("item in the middle");
            }
        };


    }

}
