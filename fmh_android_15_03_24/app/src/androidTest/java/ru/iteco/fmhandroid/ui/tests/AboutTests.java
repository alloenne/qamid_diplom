package ru.iteco.fmhandroid.ui.tests;


import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
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
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)

public class AboutTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainSteps = new MainPageSteps();
    AboutSteps aboutSteps = new AboutSteps();




    @Before
    public void setUp() {
        try {
            mainSteps.mainPageLoad();
            mainSteps.openAboutPage();
            aboutSteps.loadAbout();
        } catch (
                Exception e) {
            authSteps.loadAuthPage();
            authSteps.loginWithValidUser();
            mainSteps.mainPageLoad();
            mainSteps.openAboutPage();
            aboutSteps.loadAbout();
        }
    }


    @Test
    @Description(value = "Тестирование видимости всех элементов страницы About")
    public void shouldAboutElementsIsVisible() {
        aboutSteps.checkAboutHasAllElements();
    }

    @Test
    @Description(value = "Тестирование перехода на страницу политики конфиденциальности")
    public void shouldGoToPrivacyPolicy() {
        Intents.init();
        aboutSteps.linkPrivacyPolicy();
        Intents.intended(IntentMatchers.hasAction(Intent.ACTION_VIEW));
        Intents.intended(IntentMatchers.hasData("https://vhospice.org/#/privacy-policy/"));
        Intents.release();
    }

    @Test
    @Description(value = "Тестирование перехода на страницу пользовательского соглашения")
    public void shouldGoToTermsOfUse() {
        Intents.init();
        aboutSteps.linkTermsOfUse();
        Intents.intended(IntentMatchers.hasAction(Intent.ACTION_VIEW));
        Intents.intended(IntentMatchers.hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
    }


}