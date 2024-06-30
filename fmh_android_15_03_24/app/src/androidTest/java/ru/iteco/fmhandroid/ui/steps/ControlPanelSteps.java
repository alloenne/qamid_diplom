package ru.iteco.fmhandroid.ui.steps;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.ControlPanelPageElement;
import ru.iteco.fmhandroid.ui.pageElement.NewsPageElement;
public class ControlPanelSteps {

    ControlPanelPageElement controlPanelPage = new ControlPanelPageElement();
    NewsPageElement newsPage = new NewsPageElement();


    public void openControlPanelPage() {
        Allure.step("Открыть страницу управления новостями");
        newsPage.controlPanelButton.perform(click());
        waitingElement(withId(R.id.add_news_image_view), 5000);
    }

    public void loadControlPanelPage() {
        Allure.step("Загрузка страницы управления новостями");
        waitingElement(withId(R.id.add_news_image_view), 5000);
    }

    public void checkControlPanelHasAllElements() {
        Allure.step("Наличие на странице управления новостями всех предполагаемых элементов");
        waitingElement(withId(R.id.add_news_image_view), 5000);
        controlPanelPage.logo.check(matches(isDisplayed()));
        controlPanelPage.titlePage.check(matches(isDisplayed()));
        controlPanelPage.newsList.check(matches(isDisplayed()));
        controlPanelPage.sortButton.check(matches(isDisplayed()));
        controlPanelPage.filterButton.check(matches(isDisplayed()));
        controlPanelPage.addNewsButton.check(matches(isDisplayed()));
    }



    public void openExtendedNewsFilter() {
        Allure.step("Открыть фильтр в редактировании новостей");
        controlPanelPage.filterButton.perform(click());
    }

    public void openCreateNewsButton() {
        Allure.step("Нажать кнопку создание новости");
        controlPanelPage.addNewsButton.perform(click());
    }

    public void clickDeleteNews(String newsTitle) {
        Allure.step("Удалить новость с указанным заголовком");
        controlPanelPage.deleteNewsButton(newsTitle).perform(click());
    }

    public void clickEditNews(String newsTitle) {
        Allure.step("Отредактировать новость с указанным заголовком");
        controlPanelPage.editNewsButton(newsTitle).perform(click());
    }



    public void clickOKButtonMessage() {
        Allure.step("Нажать кнопку ОК в сообщении");
//        waitingElement(withText("OK"), 5000);
        controlPanelPage.okButtonMessage.perform(click());
    }

    public void clickCancelButtonMessage() {
        Allure.step("Нажать кнопку Отмена в сообщении");
//        waitingElement(withText("CANCEL"), 5000);
        controlPanelPage.cancelButtonMessage.perform(click());
    }

    public void checkNewsWithTitleExist(String titleText) {
        Allure.step("Проверка, что новость с указанным заголовком создана");
        onView(allOf(withText(titleText), isDisplayed())).check(matches(isDisplayed()));
    }

    public void checkNewsDataIsCorrect(String titleText, String publicationData) {
        Allure.step("Проверка, что новость создалась с корректно заполненными датами");
        controlPanelPage.newsPublicationData(titleText).check(matches(withText(publicationData)));
        controlPanelPage.newsCreatingData(titleText).check(matches(withText(publicationData)));

    }

    public void checkNewsWithTitleDontExist(String titleText) {
        Allure.step("Проверка, что новости с указанным заголовком нет");
        onView(allOf(withText(titleText), isDisplayed())).check(doesNotExist());
    }
}


