package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
public class FilterNewsPageElement {
    public ViewInteraction titlePage = onView(withId(R.id.filter_news_title_text_view));
    public ViewInteraction categoryText =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction dateFirstText =
            onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction dateLatestText =
            onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction filterActive =
            onView(withId(R.id.filter_news_active_material_check_box));
    public ViewInteraction filterNotActive =
            onView(withId(R.id.filter_news_inactive_material_check_box));
    public ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public ViewInteraction okButtonMessage = onView(withText("OK"));
    public ViewInteraction cancelButtonMessage = onView(withText("CANCEL"));
}
