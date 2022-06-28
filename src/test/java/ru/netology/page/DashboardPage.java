package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$x("//li[@class=\"list__item\"]/div");


    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public TransferPage transferButton(int index) {
        $$x("//button[@data-test-id=\"action-deposit\"]").get(index).click();
        return new TransferPage();
    }

    public int getBalance(int index) {
        $x("//button[@data-test-id=\"action-reload\"]").click();
        String[] parts = cards.get(index).toString().split(" ");
        int balance = valueOf(parts[6]);
        return balance;

    }

    public void assertBalance(int index, int expected) {
        int actual = getBalance(index);
        assertEquals(expected, actual);
    }
}

