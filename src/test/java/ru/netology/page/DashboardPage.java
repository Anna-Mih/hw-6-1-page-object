package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Integer.valueOf;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$("//li[@class='list__item']/div");


    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public TransferPage transferButton(int index){
        $$("//button[@data-test-id='action-deposit']").get(index).click();
        return new TransferPage();
    }

    public int getBalance(int index) {
        $$("//button[@data-test-id='action-reload']").get(index).click();
        String[] parts = cards.get(index).toString().split(" ");
        int balance = valueOf(parts[6]);
        return balance;
    }
}

