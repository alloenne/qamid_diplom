package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.MainPageElement;

public class MainPageSteps {
    MainPageElement mainPage = new MainPageElement();

    public void mainPageLoad() {
        Allure.step("Загрузка страницы");
        waitingElement(withId(R.id.all_news_text_view), 10000);
    }

    public void checkMainPageHasAllElements() {
        Allure.step("Наличие на главной странице всех предполагаемых элементов");
        mainPage.profileButton.check(matches(isDisplayed()));
        mainPage.menuButton.check(matches(isDisplayed()));
        mainPage.quotesButton.check(matches(isDisplayed()));
        mainPage.titleNews.check(matches(isDisplayed()));
        mainPage.allNewsButton.check(matches(isDisplayed()));
    }

    public void openNewsPage() {
        Allure.step("Открыть раздел новости из меню");
        mainPage.menuButton.perform(click());
        mainPage.newsInMenu.perform(click());
    }

    public void openAboutPage() {
        Allure.step("Открыть раздел About из меню");
        mainPage.menuButton.perform(click());
        mainPage.aboutInMenu.perform(click());
    }

    public void openQuotesPage() {
        Allure.step("Открыть раздела \"Цитаты\"");
        mainPage.quotesButton.perform(click());
    }

    public void logOut() {
        Allure.step("Выход из профиля");
        mainPage.profileButton.perform(click());
        mainPage.logOut.perform(click());
    }

    public void openAllNews() {
        Allure.step("Открыть раздел новости через кнопку All News");
        mainPage.allNewsButton.perform(click());
    }
}
