package ru.iteco.fmhandroid.ui.pageElement;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
public class MainPageElement {
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public ViewInteraction profileButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logOut = onView(withText("Log out"));
    public ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction mainInMenu = onView(withText("Main"));
    public ViewInteraction newsInMenu = onView(withText("News"));
    public ViewInteraction aboutInMenu = onView(withText("About"));
    public ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction titleNews = onView(withText("News"));
    public ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));
    public ViewInteraction collapseAllNewsButton = onView(withId(R.id.expand_material_button));
    public ViewInteraction allNewsBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));



}
