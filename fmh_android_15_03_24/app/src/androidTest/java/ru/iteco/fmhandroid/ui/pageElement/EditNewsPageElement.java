package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
public class EditNewsPageElement {
    public ViewInteraction titlePage = onView(withId(R.id.custom_app_bar_title_text_view));
    public ViewInteraction category =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction title = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction description =
            onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction publicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction time = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction switcher = onView(withId(R.id.switcher));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public ViewInteraction okButtonMessage = onView(withText("OK"));
    public ViewInteraction cancelButtonMessage = onView(withText("CANCEL"));
}
