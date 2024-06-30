package ru.iteco.fmhandroid.ui.steps;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.EditNewsPageElement;
public class EditNewsSteps {
    EditNewsPageElement editNewsPage = new EditNewsPageElement();

    public void editNewsLoad() {
        Allure.step("Загрузка страницы редактирования новости");
        waitingElement(withId(R.id.switcher), 5000);
    }

    public void checkEditNewsHasAllElements() {
        Allure.step("Наличие на странице редатирования новостей всех предполагаемых элементов");
        editNewsPage.titlePage.check(matches(isDisplayed()));
        editNewsPage.category.check(matches(isDisplayed()));
        editNewsPage.title.check(matches(isDisplayed()));
        editNewsPage.description.check(matches(isDisplayed()));
        editNewsPage.publicationDate.check(matches(isDisplayed()));
        editNewsPage.time.check(matches(isDisplayed()));
        editNewsPage.switcher.check(matches(isDisplayed()));
        editNewsPage.saveButton.check(matches(isDisplayed()));
        editNewsPage.cancelButton.check(matches(isDisplayed()));
    }


    public void editNews(String title, String description) {
        Allure.step("Перезаполнение/редактирование данных новости");

        editNewsPage.title.perform(replaceText(title));
        editNewsPage.description.perform(replaceText(description));

    }

    public void changeStatus() {
        Allure.step("Поменять статус новости");
        editNewsPage.switcher.perform(click());
    }

    public void clickSaveButton() {
        Allure.step("Нажать кнопку Сохранить");
        editNewsPage.saveButton.perform(scrollTo(), click());
    }

    public void clickCancelButton() {
        Allure.step("Нажать кнопку Отмена");

        editNewsPage.cancelButton.perform(scrollTo(), click());
    }

    public void clickOKButtonMessage() {
        Allure.step("Нажать кнопку ОК в сообщении");
        waitingElement(withText("OK"), 5000);
        editNewsPage.okButtonMessage.perform(click());
    }

    public void clickCancelButtonMessage() {
        Allure.step("Нажать кнопку Отмена в сообщении");
        waitingElement(withText("CANCEL"), 5000);
        editNewsPage.cancelButtonMessage.perform(click());
    }
}
