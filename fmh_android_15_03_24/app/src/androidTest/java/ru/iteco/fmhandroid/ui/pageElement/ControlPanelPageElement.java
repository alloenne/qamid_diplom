package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
public class ControlPanelPageElement {
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public ViewInteraction titlePage = onView(withText("Control panel"));
    public ViewInteraction newsList = onView(withId(R.id.news_list_recycler_view));
    public ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public ViewInteraction newsTitleText =
            onView(withIndex(withId(R.id.news_item_title_text_view), 0));;
    public ViewInteraction newsDescriptionText = onView(withIndex(withId(R.id.news_item_description_text_view), 0));

    public ViewInteraction okButtonMessage = onView(withText("OK"));
    public ViewInteraction cancelButtonMessage = onView(withText("CANCEL"));




    public ViewInteraction deleteNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.delete_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(newsTitle))))))));
    }

    public ViewInteraction editNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.edit_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(newsTitle))))))));
    }

    public ViewInteraction newsCreatingData(String newsTitle) {
        return onView(allOf(withId(R.id.news_item_create_date_text_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(newsTitle))))))));
    }

    public ViewInteraction newsPublicationData(String newsTitle) {
        return onView(allOf(withId(R.id.news_item_publication_date_text_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(newsTitle))))))));
    }

}

