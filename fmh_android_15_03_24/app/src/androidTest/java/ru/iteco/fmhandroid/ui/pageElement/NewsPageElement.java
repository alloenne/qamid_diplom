package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
public class NewsPageElement {
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public ViewInteraction title = onView(withText("News"));
    public ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction controlPanelButton = onView(withId(R.id.edit_news_material_button));
    public ViewInteraction allNewsBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public ViewInteraction expandOneNewsButton = onView(allOf(withId(R.id.news_list_recycler_view),
            childAtPosition(withClassName(is("android.widget.LinearLayout")),
                    withId(R.id.all_news_cards_block_constraint_layout), 0)));


}
