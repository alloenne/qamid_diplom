package ru.iteco.fmhandroid.ui.tests;


import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;

@RunWith(AllureAndroidJUnit4.class)

public class AuthTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainSteps = new MainPageSteps();


    @Before
    public void setUp() {
        try {
            authSteps.loadAuthPage();
        } catch (
                Exception e) {
            mainSteps.mainPageLoad();
            mainSteps.logOut();
            authSteps.loadAuthPage();
        }


    }

    @After
    public void resetCondition() {
        try {
            mainSteps.mainPageLoad();
            mainSteps.logOut();
        } catch (Exception ignored) {
        }
    }


    @Test
    @Description(value = "Тестирование видимости всех элементов страницы авторизации")
    public void shouldAuthElementsIsVisible() {
        authSteps.checkAuthHasAllElements();
    }

    @Test
    @Description(value = "Тестирование авторизации с верными данными")
    public void shouldLoginWithValidUser() {
        authSteps.loginWithValidUser();
        mainSteps.mainPageLoad();
        mainSteps.checkMainPageHasAllElements();
    }

    @Test
    @Description(value = "Тестирование авторизации с неверными данными")
    public void shouldLoginWithInvalidUser() {
        authSteps.loginWithInValidUser();
        authSteps.checkToastMessage("Something went wrong. Try again later.");
        authSteps.checkAuthIsOpen();

    }

    @Test
    @Description(value = "Тестирование авторизации с пустыми данными")
    public void shouldLoginWithEmptyFields() {
        authSteps.loginWithEmptyFields();
        authSteps.checkToastMessage("Login and password cannot be empty");
        authSteps.checkAuthIsOpen();
    }


}