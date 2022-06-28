package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.valueOf;

public class TransferPage {
    public void transfer(DataHelper info, int amount, int indexFrom) {
        $x("//span[@data-test-id=\"amount\"]//input").setValue(valueOf(amount));
        $x("//span[@data-test-id=\"from\"]//input").setValue(info.getCardByIndex(indexFrom));
        $x("//button[@data-test-id=\"action-transfer\"]").click();
    }
}
