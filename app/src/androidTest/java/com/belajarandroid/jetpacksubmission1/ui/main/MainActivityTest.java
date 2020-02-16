package com.belajarandroid.jetpacksubmission1.ui.main;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.belajarandroid.jetpacksubmission1.R;
import com.belajarandroid.jetpacksubmission1.data.FilmEntity;
import com.belajarandroid.jetpacksubmission1.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    private List<FilmEntity> dummyMovie = DataDummy.generateDummyMovie();
    private List<FilmEntity> dummyShow = DataDummy.generateDummyShow();

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadShow() {
        onView(withText("Tv Shows")).perform(click());
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition(dummyShow.size()));
    }

    @Test
    public void loadDetail() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_backdrop)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_title)).check(matches(withText(dummyMovie.get(0).getFilmTitle())));
        onView(withId(R.id.detail_date)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_date)).check(matches(withText(dummyMovie.get(0).getFilmDate())));
        onView(withId(R.id.detail_runtime)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_runtime)).check(matches(withText(dummyMovie.get(0).getFilmRuntime())));
        onView(withId(R.id.detail_status)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_status)).check(matches(withText(dummyMovie.get(0).getFilmStatus())));
        onView(withId(R.id.detail_extra)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_extra)).check(matches(withText(dummyMovie.get(0).getFilmAdult())));
        onView(withId(R.id.detail_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_rating)).check(matches(withText(dummyMovie.get(0).getFilmRate())));
        onView(withId(R.id.detail_popularity)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_popularity)).check(matches(withText(dummyMovie.get(0).getFilmPopularity())));
        onView(withId(R.id.detail_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_overview)).check(matches(withText(dummyMovie.get(0).getFilmOverview())));
        onView(withId(R.id.detail_seasons_budget)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_seasons_budget)).check(matches(withText(dummyMovie.get(0).getFilmBudget())));
        onView(withId(R.id.detail_episode_revenue)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_episode_revenue)).check(matches(withText(dummyMovie.get(0).getFilmRevenue())));
        onView(withId(R.id.detail_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_genre)).check(matches(withText(dummyMovie.get(0).getFilmGenre())));

    }

}