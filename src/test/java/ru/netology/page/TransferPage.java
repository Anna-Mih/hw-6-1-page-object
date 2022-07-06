package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.valueOf;
import static ru.netology.data.DataHelper.getCardByIndex;

public class TransferPage {

    public void transfer(int amount, int indexFrom) {
        $x("//span[@data-test-id=\"amount\"]//input").setValue(valueOf(amount));
        $x("//span[@data-test-id=\"from\"]//input").setValue(getCardByIndex(indexFrom));
        $x("//button[@data-test-id=\"action-transfer\"]").click();
    }
}
