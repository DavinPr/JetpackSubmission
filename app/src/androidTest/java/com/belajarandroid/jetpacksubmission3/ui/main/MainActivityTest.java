package com.belajarandroid.jetpacksubmission3.ui.main;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.belajarandroid.jetpacksubmission3.R;
import com.belajarandroid.jetpacksubmission3.data.FilmEntity;
import com.belajarandroid.jetpacksubmission3.utils.DataDummy;
import com.belajarandroid.jetpacksubmission3.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

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
        onView(withId(R.id.detail_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_rating)).check(matches(withText(dummyMovie.get(0).getFilmRate())));
        onView(withId(R.id.detail_popularity)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_popularity)).check(matches(withText(dummyMovie.get(0).getFilmPopularity())));
        onView(withId(R.id.detail_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_overview)).check(matches(withText(dummyMovie.get(0).getFilmOverview())));
        onView(withId(R.id.detail_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_genre)).check(matches(withText(dummyMovie.get(0).getFilmGenre())));
        onView(withId(R.id.detail_lang)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_lang)).check(matches(withText(dummyMovie.get(0).getFilmLang())));
    }

}