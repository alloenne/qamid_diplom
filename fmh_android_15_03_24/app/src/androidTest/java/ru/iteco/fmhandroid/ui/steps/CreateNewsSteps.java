package ru.iteco.fmhandroid.ui.steps;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageElement.CreateNewsPageElement;

public class CreateNewsSteps {
    CreateNewsPageElement createNewsPage = new CreateNewsPageElement();

    public void createNewsLoad() {
        Allure.step("Загрузка страницы создания новости");
        waitingElement(withId(R.id.custom_app_bar_title_text_view), 5000);
    }

    public void checkCreateHasAllFields() {
        Allure.step("Наличие на странице  \"Creating News\" всех предполагаемых элементов");
        createNewsPage.titlePage.check(matches(isDisplayed()));
        createNewsPage.categoryText.check(matches(isDisplayed()));
        createNewsPage.titleText.check(matches(isDisplayed()));
        createNewsPage.descriptionText.check(matches(isDisplayed()));
        createNewsPage.publicationDate.check(matches(isDisplayed()));
        createNewsPage.time.check(matches(isDisplayed()));
        createNewsPage.switcher.check(matches(isDisplayed()));
        createNewsPage.saveButton.check(matches(isDisplayed()));
        createNewsPage.cancelButton.check(matches(isDisplayed()));
    }


    public void createNews(String category, String title, String publicationDate,
                           String publicationTime, String description) {
        Allure.step("Ввод данных для создания новости");
        createNewsPage.categoryText.perform(replaceText(category));
        createNewsPage.titleText.perform(replaceText(title));
        createNewsPage.publicationDate.perform(replaceText(publicationDate));
        createNewsPage.time.perform(replaceText(publicationTime));
        createNewsPage.descriptionText.perform(replaceText(description));
    }

    public void clickSaveButton() {
        Allure.step("Нажать кнопку Сохранить");
        createNewsPage.saveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажать кнопку Отмена");
        waitingElement(withText("CANCEL"), 5000);
        createNewsPage.cancelButton.perform(click());
    }

    public void clickOKButtonMessage() {
        Allure.step("Нажать кнопку ОК в сообщении");
        waitingElement(withText("OK"), 5000);
        createNewsPage.okButtonMessage.perform(click());
    }

    public void clickCancelButtonMessage() {
        Allure.step("Нажать кнопку Отмена в сообщении");
        waitingElement(withText("CANCEL"), 5000);
        createNewsPage.cancelButtonMessage.perform(click());
    }

    public void checkToastMessage(String text) {
        Allure.step("Проверка всплывающего сообщения с ошибкой");
        onView(withText(text))
                .inRoot(new DataHelper.ToastMatcher())
                .check(matches(isDisplayed()));
    }

}


