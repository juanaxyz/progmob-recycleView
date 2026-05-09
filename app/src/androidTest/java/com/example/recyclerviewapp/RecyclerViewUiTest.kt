package com.example.recyclerviewapp

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RecyclerViewUiTest {
    @Test
    fun listDisplaysItemsAndNavigatesToDetail() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Verify RecyclerView is displayed
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

        // Click on the first item (position 0). Use RecyclerView action.
        onView(withId(R.id.recyclerView))
            .perform(
                androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition<androidx.recyclerview.widget.RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        // After click, DetailActivity should be displayed – check that title view has expected text prefix
        // Since title is "Item #1", we check that a view with that text is displayed.
        onView(allOf(withId(R.id.detailTitle), withText("Item #1")))
            .check(matches(isDisplayed()))

        // Press back to return to MainActivity and verify RecyclerView still displayed
        pressBack()
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }
}
