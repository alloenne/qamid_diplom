package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
public class QuotesPageElement {
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public ViewInteraction title = onView(withId(R.id.our_mission_title_text_view));
    public ViewInteraction ourMissionList = onView(withId(R.id.our_mission_item_list_recycler_view));
    public ViewInteraction missionConstraintLayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
}
