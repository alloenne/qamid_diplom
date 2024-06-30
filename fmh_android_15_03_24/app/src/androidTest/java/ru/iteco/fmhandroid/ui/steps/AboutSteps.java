package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitingElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.AboutPageElement;
public class AboutSteps {
    AboutPageElement aboutPage = new AboutPageElement();

    public void checkAboutHasAllElements() {
        Allure.step("Наличие на странице  \"About\" всех предполагаемых элементов");
        waitingElement(withId(R.id.about_version_title_text_view), 5000);
        aboutPage.logo.check(matches(isDisplayed()));
        aboutPage.backButton.check(matches(isDisplayed()));
        aboutPage.versionText.check(matches(isDisplayed()));
        aboutPage.versionValue.check(matches(isDisplayed()));
        aboutPage.policyText.check(matches(isDisplayed()));
        aboutPage.termsOfUseText.check(matches(isDisplayed()));
        aboutPage.infoCompany.check(matches(isDisplayed()));
        aboutPage.privacyPolicyLink.check(matches(isDisplayed()));
        aboutPage.termsOfUseLink.check(matches(isDisplayed()));
        aboutPage.infoCompany.check(matches(isDisplayed()));
    }

    public void loadAbout() {
        Allure.step("Загрузка страницы About");
        waitingElement(withId(R.id.about_version_title_text_view), 5000);

    }

    public void linkPrivacyPolicy() {
        Allure.step("Открыть ссылку на политику конфиденциальности");
        aboutPage.privacyPolicyLink.perform(click());

    }

    public void linkTermsOfUse() {
        Allure.step("Открыть ссылку на пользовательское соглашение");
        aboutPage.termsOfUseLink.perform(click());
    }

    public void returnBack() {
        Allure.step("Возврат на предыдущую страницу");
        aboutPage.backButton.perform(click());
    }


}

