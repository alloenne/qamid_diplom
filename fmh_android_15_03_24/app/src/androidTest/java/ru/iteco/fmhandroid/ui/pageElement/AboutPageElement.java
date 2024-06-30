package ru.iteco.fmhandroid.ui.pageElement;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
public class AboutPageElement {
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));;
    public ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
    public ViewInteraction versionText = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction versionValue = onView(withId(R.id.about_version_value_text_view));
    public ViewInteraction policyText = onView(withId(R.id.about_privacy_policy_label_text_view));
    public ViewInteraction termsOfUseText = onView(withId(R.id.about_terms_of_use_label_text_view));
    public ViewInteraction infoCompany = onView(withId(R.id.about_company_info_label_text_view));
    public ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
}
