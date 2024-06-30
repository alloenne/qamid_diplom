package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.FilterNewsPageElement;
public class FilterNewsSteps {

    FilterNewsPageElement filterNewsPage = new FilterNewsPageElement();

    public void filterLoad() {
        Allure.step("Открытие страницы фильтра");
        waitingElement(withId(R.id.filter_news_title_text_view), 5000);
    }

    public void checkFilterNewsHasAllElements() {
        Allure.step("Наличие на странице фильтра всех предполагаемых элементов");
        filterNewsPage.titlePage.check(matches(isDisplayed()));
        filterNewsPage.categoryText.check(matches(isDisplayed()));
        filterNewsPage.dateFirstText.check(matches(isDisplayed()));
        filterNewsPage.dateLatestText.check(matches(isDisplayed()));
        filterNewsPage.filterButton.check(matches(isDisplayed()));
        filterNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public void checkFilterControlNewsHasAllElements() {
        Allure.step("Наличие на странице фильтра управления новостями всех предполагаемых элементов");
        filterNewsPage.titlePage.check(matches(isDisplayed()));
        filterNewsPage.categoryText.check(matches(isDisplayed()));
        filterNewsPage.dateFirstText.check(matches(isDisplayed()));
        filterNewsPage.dateLatestText.check(matches(isDisplayed()));
        filterNewsPage.filterActive.check(matches(isDisplayed()));
        filterNewsPage.filterNotActive.check(matches(isDisplayed()));
        filterNewsPage.filterButton.check(matches(isDisplayed()));
        filterNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public void clickFilterButton() {
        Allure.step("Нажать кнопку Фильтровать");
        filterNewsPage.filterButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажату кнопку Отмена");
        filterNewsPage.cancelButton.perform(click());
    }

    public void clickOKButton() {
        Allure.step("Нажать кнопку ОК в сообщении");
        filterNewsPage.okButtonMessage.perform(click());
    }

    public void writeInFirstDate(String startDate) {
        Allure.step("Заполнить начальную дату фильтрации");
        filterNewsPage.dateFirstText.perform(replaceText(startDate));
    }

    public void writeInLastDate(String endDate) {
        Allure.step("Заполнить конечную дату фильтрации");
        filterNewsPage.dateLatestText.perform(replaceText(endDate));
    }

    public void clickActiveCheckBox() {
        Allure.step("Выбрать фильтрацию по активным новостям");
        filterNewsPage.filterActive.perform(click());
    }

    public void clickNotActiveCheckBox() {
        Allure.step("Выбрать фильтрацию по неактивным новостям");
        filterNewsPage.filterNotActive.perform(click());
    }

    public void checkBoxStatusActive(boolean checked) {
        Allure.step("Стоит ли галочка в поле Активная новостьт");

        if (checked) {
            filterNewsPage.filterActive.check(matches(isChecked()));
        } else {
            filterNewsPage.filterActive.check(matches(isNotChecked()));
        }
    }

    public void checkBoxStatusNotActive(boolean checked) {
        Allure.step("Стоит ли галочка в поле неактивная новость");

        if (checked) {
            filterNewsPage.filterNotActive.check(matches(isChecked()));
        } else {
            filterNewsPage.filterNotActive.check(matches(isNotChecked()));
        }
    }

}
