package ru.iteco.fmhandroid.ui.steps;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;

import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageElement.AuthPageElement;
public class AuthSteps {

    AuthPageElement authPage = new AuthPageElement();

    public void loadAuthPage() {
        Allure.step("Загрузка страницы авторизации");
        waitingElement(withId(R.id.enter_button), 10000);
    }

    public void checkAuthHasAllElements() {
        Allure.step("Проверка видимости всех элементов страницы авторизации");
        waitingElement(withText("Authorization"), 10000);
        authPage.title.check(matches(isDisplayed()));
        authPage.login.check(matches(isDisplayed()));
        authPage.password.check(matches(isDisplayed()));
        authPage.loginButton.check(matches(isDisplayed()));
    }

    public void loginWithValidUser() {
        Allure.step("Вход с верными данными");
        DataHelper data = new DataHelper();
        authPage.login.perform(typeText(data.getValidLogin()), closeSoftKeyboard());
        authPage.password.perform(typeText(data.getValidPass()), closeSoftKeyboard());
        authPage.loginButton.perform(click());
    }

    public void loginWithInValidUser() {
        Allure.step("Вход с неверными данными");
        DataHelper data = new DataHelper();
        authPage.login.perform(typeText(data.getInValidLogin()), closeSoftKeyboard());
        authPage.password.perform(typeText(data.getInValidPass()), closeSoftKeyboard());
        authPage.loginButton.perform(click());
    }

    public void loginWithEmptyFields() {
        Allure.step("Вход с неверными данными");
        DataHelper data = new DataHelper();
        authPage.login.perform(typeText(data.getEmptyFields()), closeSoftKeyboard());
        authPage.password.perform(typeText(data.getEmptyFields()), closeSoftKeyboard());
        authPage.loginButton.perform(click());
    }

//    public void checkToastMessage(String text, View decorView) {
//        Allure.step("Проверка всплывающего сообщения с ошибкой");
//        onView(withText(text))
//                .inRoot(withDecorView(not(decorView)))
//                .check(matches(isDisplayed()));
//    }

    public void checkAuthIsOpen() {
        Allure.step("Проверка, что страница авторизации открыта");
        authPage.title.check(matches(isDisplayed()));

    }





}
