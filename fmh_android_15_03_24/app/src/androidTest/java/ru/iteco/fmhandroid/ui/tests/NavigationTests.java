package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)

public class NavigationTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainSteps = new MainPageSteps();
    NewsSteps newsSteps = new NewsSteps();
    AboutSteps aboutSteps = new AboutSteps();
    QuotesSteps quotesSteps = new QuotesSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();



    @Before
    public void setUp() {
        try {
            mainSteps.mainPageLoad();
        } catch (
                Exception e) {
            authSteps.loadAuthPage();
            authSteps.loginWithValidUser();
            mainSteps.mainPageLoad();
        }
    }


    @Test
    @Description(value = "Тестирование перехода в раздел Цитаты при нажатии на бабочку")
    public void shouldOpenQuotes() {
        mainSteps.openQuotesPage();
        quotesSteps.checkQuotesHasAllElement();
    }

    @Test
    @Description(value = "Тестирование выхода из аккаунта при нажатии на профиль пользователя")
    public void shouldLogout() {
        mainSteps.logOut();
        authSteps.loadAuthPage();
        authSteps.checkAuthIsOpen();
    }

    @Test
    @Description(value = "Тестирование перехода в раздел About из меню на главной странице")
    public void shouldOpenAboutFromMainPage() {
        mainSteps.openAboutPage();
        aboutSteps.checkAboutHasAllElements();
    }

    @Test
    @Description(value = "Тестирование перехода в раздел Новости из меню")
    public void shouldOpenNewsFromMenu() {
        mainSteps.openNewsPage();
        newsSteps.checkNewsHasAllElements();
    }

    @Test
    @Description(value = "Тестирование перехода в раздел редактирования новостей со страницы Новости")
    public void shouldOpenControlPanelFromNews() {
        mainSteps.openNewsPage();
        newsSteps.newsListLoad();
        controlPanelSteps.openControlPanelPage();
    }

    @Test
    @Description(value = "Тестирование перехода в раздел About из меню на странице новостей")
    public void shouldOpenAboutFromNewsPage() {
        mainSteps.openAllNews();
        newsSteps.goToAboutPageFromNews();
        aboutSteps.checkAboutHasAllElements();
    }

    @Test
    @Description(value = "Тестирование возврата из раздела About на страницу цитат")
    public void shouldReturnFromAbout() {
        mainSteps.openQuotesPage();
        quotesSteps.goToAboutPageFromQuotes();
        aboutSteps.loadAbout();
        aboutSteps.returnBack();
        quotesSteps.checkQuotesHasAllElement();
    }




}