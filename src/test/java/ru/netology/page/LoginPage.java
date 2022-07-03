package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public VerificationPage login(DataHelper Info) {
        $x("//span[@data-test-id=\"login\"]//input").setValue(Info.getInfo().getLogin());
        $x("//span[@data-test-id=\"password\"]//input").setValue(Info.getInfo().getPassword());
        $x("//button[@data-test-id=\"action-login\"]").click();
        return new VerificationPage();
    }
}
