package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public VerificationPage login(DataHelper info) {
        $x("//span[@data-test-id=\"login\"]//input").setValue(info.getLogin());
        $x("//span[@data-test-id=\"password\"]//input").setValue(info.getPassword());
        $x("//button[@data-test-id=\"action-login\"]").click();
        return new VerificationPage();
    }
}
