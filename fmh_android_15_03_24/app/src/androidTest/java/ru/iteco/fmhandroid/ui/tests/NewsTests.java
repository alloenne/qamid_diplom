package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)

public class NewsTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainSteps = new MainPageSteps();
    NewsSteps newsSteps = new NewsSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();



    @Before
    public void setUp() {
        try {
            mainSteps.mainPageLoad();
            mainSteps.openAllNews();
            newsSteps.newsListLoad();
        } catch (
                Exception e) {
            authSteps.loadAuthPage();
            authSteps.loginWithValidUser();
            mainSteps.mainPageLoad();
            mainSteps.openAllNews();
            newsSteps.newsListLoad();
        }
    }


    @Test
    @Description(value = "Тестирование видимости всех элементов страницы Новости")
    public void shouldNewsElementsIsVisible() {
        newsSteps.checkNewsHasAllElements();
    }

    @Test
    @Description(value = "Тестирование разворачивания отдельной новости")
    public void shouldCollapseOneNews() {
        newsSteps.clickToExpandOneNews(0);
        newsSteps.checkDescriptionNewsIsVisible(0);
    }

    @Test
    @Description(value = "Тестирование открытия фильтра со страницы Новости и проверка видимости его элементов")
    public void shouldOpenExtendedFilter() {
        newsSteps.openNewsFilter();
        filterNewsSteps.checkFilterNewsHasAllElements();
    }

    @Test
    @Description(value = "Тестирование отмены фильтрации новостей")
    public void shouldCancelFilter() {
        newsSteps.openNewsFilter();
        filterNewsSteps.filterLoad();
        filterNewsSteps.writeInFirstDate(DataHelper.getCurrentDate());
        filterNewsSteps.writeInLastDate(DataHelper.getCurrentDate());
        filterNewsSteps.clickCancelButton();
        newsSteps.checkNewsHasAllElements();
    }







}