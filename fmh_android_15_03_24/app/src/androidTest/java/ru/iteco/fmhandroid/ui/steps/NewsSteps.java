package ru.iteco.fmhandroid.ui.steps;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageElement.MainPageElement;
import ru.iteco.fmhandroid.ui.pageElement.NewsPageElement;
public class NewsSteps {
    NewsPageElement newsMainPage = new NewsPageElement();
    MainPageElement mainPage = new MainPageElement();

    public void newsListLoad() {
        Allure.step("Загрузка страницы новостей");
        waitingElement(withId(R.id.news_list_recycler_view), 5000);
    }

    public void checkNewsHasAllElements() {
        Allure.step("Наличие на странице новостей всех предполагаемых элементов");
        newsMainPage.logo.check(matches(isDisplayed()));
        newsMainPage.title.check(matches(isDisplayed()));
        newsMainPage.sort.check(matches(isDisplayed()));
        newsMainPage.filter.check(matches(isDisplayed()));
        newsMainPage.controlPanelButton.check(matches(isDisplayed()));
        newsMainPage.allNewsBlock.check(matches(isDisplayed()));
    }

    public void goToAboutPageFromNews() {
        Allure.step("Переход на страницу About из новостей");
        mainPage.menuButton.perform(click());
        mainPage.aboutInMenu.perform(click());
    }

    public void openNewsFilter() {
        Allure.step("Открыть фильтр из списка новостей");
        newsMainPage.filter.perform(click());
    }

    public void clickToExpandOneNews(int index) {
        Allure.step("Развернуть/свернуть новость");
        newsMainPage.expandOneNewsButton.perform(actionOnItemAtPosition(index, click()));
    }

    public void checkDescriptionNewsIsVisible(int index) {
        Allure.step("Проверка видимости описания новости");
        String desc = getTheNewsDescription(index);
        onView(
                allOf(withId(R.id.news_item_description_text_view), withText(desc),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()))
                .check(matches(isDisplayed()));
    }



    public String getTheNewsTitle(int index) {
        Allure.step("Заголовок определенной новости");
        return DataHelper.Text.getText(onView(withIndex(withId(R.id.news_item_title_text_view), index)));
    }

    public String getTheNewsDescription(int index) {
        Allure.step("Описание определенной новости");
        return DataHelper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), index)));
    }
}
