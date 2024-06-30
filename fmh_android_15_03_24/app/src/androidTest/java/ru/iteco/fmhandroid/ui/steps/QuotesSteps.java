package ru.iteco.fmhandroid.ui.steps;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.QuotesPageElement;
import ru.iteco.fmhandroid.ui.pageElement.MainPageElement;
public class QuotesSteps {
    QuotesPageElement quotesPage = new QuotesPageElement();
    MainPageElement mainPage = new MainPageElement();

    public void quotesLoad() {
        Allure.step("Загрузка страницы");
        waitingElement(withId(R.id.our_mission_title_text_view), 10000);
    }

    public void checkQuotesHasAllElement() {
        Allure.step("Наличие на странице цитат всех предполагаемых элементов");
        quotesPage.logo.check(matches(isDisplayed()));
        quotesPage.title.check(matches(isDisplayed()));
        quotesPage.ourMissionList.check(matches(isDisplayed()));
    }

    public void checkQuote(int number) {
        Allure.step("Развернуть/свернуть цитату");
        quotesPage.missionConstraintLayout.check(matches(isDisplayed()));
        quotesPage.missionConstraintLayout.perform(actionOnItemAtPosition(number, click()));
    }

    public void displayFullQuotes(int number) {
        Allure.step("Отображение цитаты полностью");
        onView(allOf(
                withIndex(withId(R.id.our_mission_item_description_text_view), number)))
                .check(matches(isDisplayed()));
    }

    public void goToAboutPageFromQuotes() {
        Allure.step("Переход на страницу About из цитат");
        mainPage.menuButton.perform(click());
        mainPage.aboutInMenu.perform(click());
    }
}
