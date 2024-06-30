package ru.iteco.fmhandroid.ui.tests;


import android.view.View;

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
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.EditNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)

public class ControlPanelTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainSteps = new MainPageSteps();
    NewsSteps newsSteps = new NewsSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    EditNewsSteps editNewsSteps = new EditNewsSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();



    @Before
    public void setUp() {
        try {
            mainSteps.mainPageLoad();
            mainSteps.openAllNews();
            newsSteps.newsListLoad();
            controlPanelSteps.openControlPanelPage();
        } catch (
                Exception e) {
            authSteps.loadAuthPage();
            authSteps.loginWithValidUser();
            mainSteps.mainPageLoad();
            mainSteps.openAllNews();
            newsSteps.newsListLoad();
            controlPanelSteps.openControlPanelPage();
        }
    }


    @Test
    @Description(value = "Тестирование видимости всех элементов страницы управления новостями")
    public void shouldControlPanelElementsIsVisible() {
        controlPanelSteps.checkControlPanelHasAllElements();
    }

    @Test
    @Description(value = "Тестирование открытия расширенного фильтра со страницы управления новостями и проверка видимости его элементов")
    public void shouldOpenExtendedFilter() {
        controlPanelSteps.openExtendedNewsFilter();
        filterNewsSteps.filterLoad();
        filterNewsSteps.checkFilterControlNewsHasAllElements();
    }

    @Test
    @Description(value = "Тестирование открытия окна создания новости и проверка видимости всех элементов")
    public void shouldOpenCreateNews() {
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.checkCreateHasAllFields();
    }

    @Test
    @Description(value = "Тестирование создания новости с заполнением всех полей")
    public void shouldCreateNews() {
        String category = "Зарплата";
        String title = "Test creating news";
        String publicationDate = DataHelper.getCurrentDate();
        String publicationTime = DataHelper.getCurrentTime();
        String description = "Test creating news";
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.createNews(category, title, publicationDate, publicationTime, description);
        createNewsSteps.clickSaveButton();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.checkNewsWithTitleExist(title);
        controlPanelSteps.checkNewsDataIsCorrect(title, publicationDate);
    }

    @Test
    @Description(value = "Тестирование отмены создания новости")
    public void shouldCancelCreateNews() {
        String category = "Зарплата";
        String title = "Test cancel creating news";
        String publicationDate = DataHelper.getCurrentDate();
        String publicationTime = DataHelper.getCurrentTime();
        String description = "Test cancel creating news";
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.createNews(category, title, publicationDate, publicationTime, description);
        createNewsSteps.clickCancelButton();
        createNewsSteps.clickOKButtonMessage();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.checkNewsWithTitleDontExist(title);
    }

    @Test
    @Description(value = "Тестирование создания новости с незаполненными полями")
    public void shouldCreateEmptyNews() {
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.clickSaveButton();
        createNewsSteps.checkToastMessage("Fill empty fields");
    }

    @Test
    @Description(value = "Тестирование удаления созданной новости")
    public void shouldDeleteNews() {
        String category = "Зарплата";
        String title = "Test deleting news";
        String publicationDate = DataHelper.getCurrentDate();
        String publicationTime = DataHelper.getCurrentTime();
        String description = "Test deleting news";
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.createNews(category, title, publicationDate, publicationTime, description);
        createNewsSteps.clickSaveButton();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.clickDeleteNews(title);
        controlPanelSteps.clickOKButtonMessage();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.checkNewsWithTitleDontExist(title);

    }

    @Test
    @Description(value = "Тестирование отмены удаления созданной новости")
    public void shouldCancelDeleteNews() {
        String category = "Зарплата";
        String title = "Test cancel deleting news";
        String publicationDate = DataHelper.getCurrentDate();
        String publicationTime = DataHelper.getCurrentTime();
        String description = "Test cancel deleting news";
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.createNews(category, title, publicationDate, publicationTime, description);
        createNewsSteps.clickSaveButton();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.clickDeleteNews(title);
        controlPanelSteps.clickCancelButtonMessage();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.checkNewsWithTitleExist(title);
    }

    @Test
    @Description(value = "Тестирование редактирования созданной новости")
    public void shouldEditNews() {
        String category = "Зарплата";
        String title = "Test editing news";
        String publicationDate = DataHelper.getCurrentDate();
        String publicationTime = DataHelper.getCurrentTime();
        String description = "Test editing news";

        String editTitle = "Already editing news";
        String editDescription = "Already editing news";

        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.createNews(category, title, publicationDate, publicationTime, description);
        createNewsSteps.clickSaveButton();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.clickEditNews(title);
        editNewsSteps.editNewsLoad();
        editNewsSteps.checkEditNewsHasAllElements();
        editNewsSteps.editNews(editTitle, editDescription);
        editNewsSteps.clickSaveButton();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.checkNewsWithTitleExist(editTitle);
    }

    @Test
    @Description(value = "Тестирование отмены редактирования созданной новости")
    public void shouldCancelEditNews() {
        String category = "Зарплата";
        String title = "Test cancel editing news";
        String publicationDate = DataHelper.getCurrentDate();
        String publicationTime = DataHelper.getCurrentTime();
        String description = "Test cancel editing news";

        String editTitle = "Already editing news";
        String editDescription = "Already editing news";

        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNewsLoad();
        createNewsSteps.createNews(category, title, publicationDate, publicationTime, description);
        createNewsSteps.clickSaveButton();
        controlPanelSteps.loadControlPanelPage();
        controlPanelSteps.clickEditNews(title);
        editNewsSteps.editNewsLoad();
        editNewsSteps.checkEditNewsHasAllElements();
        editNewsSteps.editNews(editTitle, editDescription);
        editNewsSteps.changeStatus();
        editNewsSteps.clickCancelButton();
        editNewsSteps.clickOKButtonMessage();
        controlPanelSteps.checkNewsWithTitleExist(title);
    }


}