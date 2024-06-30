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

import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)

public class QuotesTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainSteps = new MainPageSteps();
    QuotesSteps quotesSteps = new QuotesSteps();


    @Before
    public void setUp() {
        try {
            mainSteps.mainPageLoad();
            mainSteps.openQuotesPage();
            quotesSteps.quotesLoad();
        } catch (
                Exception e) {
            authSteps.loadAuthPage();
            authSteps.loginWithValidUser();
            mainSteps.mainPageLoad();
            mainSteps.openQuotesPage();
            quotesSteps.quotesLoad();
        }
    }


    @Test
    @Description(value = "Тестирование видимости всех элементов страницы Цитаты")
    public void shouldQuotesElementsIsVisible() {
        quotesSteps.checkQuotesHasAllElement();
    }

    @Test
    @Description(value = "Тестирование разворачивания отдельной цитаты")
    public void shouldOneQuoteExpand() {
        quotesSteps.checkQuote(0);
        quotesSteps.displayFullQuotes(0);
    }




}