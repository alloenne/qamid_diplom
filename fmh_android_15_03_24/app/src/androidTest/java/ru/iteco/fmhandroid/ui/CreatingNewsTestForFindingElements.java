package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CreatingNewsTestForFindingElements {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void creatingNewsTestForFindingElements() {
        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.all_news_text_view), withText("All news"),
                        childAtPosition(
                                allOf(withId(R.id.container_list_news_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.edit_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                3),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction materialAutoCompleteTextView = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_category_text_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        materialAutoCompleteTextView.perform(click());

        DataInteraction materialTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(3);
        materialTextView2.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("��������"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText.perform(replaceText("test test test"));

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("test test test"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText2.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_create_date_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton3.perform(scrollTo(), click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_publish_time_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton4.perform(scrollTo(), click());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_description_text_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("testtesttest"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                6)));
        materialButton5.perform(scrollTo(), click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_material_card_view),
                                        0),
                                14),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton6.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
