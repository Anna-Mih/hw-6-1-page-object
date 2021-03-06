package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.getInfo;


public class TransferTest {
    DataHelper info;
    int amount = 100;

    @BeforeEach
    public void authorize() {
        open("http://localhost:9999/");
        VerificationPage verificationPage = new VerificationPage();
        LoginPage loginPage = new LoginPage();
        verificationPage.validVerify(info);
    }


    @Test
    public void shouldTransferToFirstCard() {
        DashboardPage dashboardPage = new DashboardPage();
        VerificationPage verificationPage = new VerificationPage();
        int balanceBeforeFirstCard = dashboardPage.getBalance(0);
        int balanceBeforeSecondCard = dashboardPage.getBalance(1);
        TransferPage transferPage = new TransferPage();
        transferPage = dashboardPage.transferButton(0);//какую карту пополняем

        transferPage.transfer(amount, 1);//с какой карты переводим

        int expectedBalanceFirstCard = balanceBeforeFirstCard + amount;
        int expectedBalanceSecondCard = balanceBeforeSecondCard - amount;

        int actualBalanceFirstCard = dashboardPage.getBalance(0);
        int actualBalanceSecondCard = dashboardPage.getBalance(1);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

    @Test
    public void shouldTransferToSecondCard() {
        DashboardPage dashboardPage = new DashboardPage();
        //VerificationPage verificationPage = new VerificationPage();
        TransferPage transferPage = new TransferPage();
        int balanceBeforeFirstCard = dashboardPage.getBalance(0);
        int balanceBeforeSecondCard = dashboardPage.getBalance(1);
        transferPage = dashboardPage.transferButton(1); //какую карту пополняем
        transferPage.transfer(amount, 0); // с какой карты пополняем

        int expectedBalanceFirstCard = balanceBeforeFirstCard - amount;
        int expectedBalanceSecondCard = balanceBeforeSecondCard + amount;

        int actualBalanceFirstCard = dashboardPage.getBalance(0);
        int actualBalanceSecondCard = dashboardPage.getBalance(1);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

    @Test
    public void shouldTransferToFirstCardIfAmountMoreThanBalance() {
        DashboardPage dashboardPage = new DashboardPage();
        VerificationPage verificationPage = new VerificationPage();
        TransferPage transferPage = new TransferPage();
        int balanceBeforeFirstCard = dashboardPage.getBalance(0);
        int balanceBeforeSecondCard = dashboardPage.getBalance(1);
        amount = amount + balanceBeforeSecondCard;
        transferPage = dashboardPage.transferButton(0); //какую карту пополняем
        transferPage.transfer(amount, 1); // с какой карты пополняем

        int actualBalanceFirstCard = dashboardPage.getBalance(0);
        int actualBalanceSecondCard = dashboardPage.getBalance(1);
        assertEquals(balanceBeforeFirstCard, actualBalanceFirstCard);
        assertEquals(balanceBeforeSecondCard, actualBalanceSecondCard);
    }
}
