package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    private SelenideElement codeField = $x("//span[@data-test-id=\"code\"]//input");
    private SelenideElement verifyButton = $x("//button[@data-test-id=\"action-verify\"]");

//    public VerificationPage() {
//        codeField.shouldBe(visible);
//    }

    public DashboardPage validVerify(DataHelper info) {
        codeField.setValue(info.getCode());
        verifyButton.click();
        return new DashboardPage();
    }
}