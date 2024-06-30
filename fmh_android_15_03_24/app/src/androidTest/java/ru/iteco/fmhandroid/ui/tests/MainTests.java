package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@RunWith(AllureAndroidJUnit4.class)

public class MainTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainSteps = new MainPageSteps();
    NewsSteps newsSteps = new NewsSteps();


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
    @Description(value = "Тестирование видимости всех элементов главной страницы")
    public void shouldMainElementsIsVisible() {
        mainSteps.checkMainPageHasAllElements();
    }

    @Test
    @Description(value = "Тестирование разворачивания блока всех новостей")
    public void shouldCollapseAllNews() {
        mainSteps.collapseAllNews();
        mainSteps.checkAllNewsBlockIsExpand();
    }

    @Test
    @Description(value = "Тестирование перехода на страницу Новостей через кнопку AllNews")
    public void shouldOpenNewsWithClickAllNews() {
        mainSteps.openAllNews();
        newsSteps.newsListLoad();
        newsSteps.checkNewsHasAllElements();
    }


}