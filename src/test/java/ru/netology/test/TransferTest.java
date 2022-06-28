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


public class TransferTest {
    DataHelper info;
    int amount = 100;

    @BeforeEach
    public void authorize(){

        open("http://localhost:9999/");

        VerificationPage verificationPage = new VerificationPage();

        LoginPage loginPage = new LoginPage();
        info = new DataHelper();
        loginPage.login(info);
        verificationPage.validVerify(info);
        // VerificationPage verificationPage = loginPage.login(info);
        //dashboardPage = verificationPage.validVerify(info);
    }


    @Test
    public void shouldTransferToFirstCard(){
        DashboardPage dashboardPage = new DashboardPage();
        VerificationPage verificationPage = new VerificationPage();
        int balanceBeforeFirstCard = dashboardPage.getBalance(0);
        int balanceBeforeSecondCard = dashboardPage.getBalance(1);
        TransferPage transferPage = new TransferPage();
        transferPage = dashboardPage.transferButton(0);

        transferPage.transfer(info, amount, 1);

        dashboardPage.assertBalance(0, balanceBeforeFirstCard + amount);
        dashboardPage.assertBalance(1, balanceBeforeSecondCard - amount);

    }
    @Test
    public void shouldTransferToSecondCard(){
        DashboardPage dashboardPage = new DashboardPage();
        VerificationPage verificationPage = new VerificationPage();
        TransferPage transferPage = new TransferPage();
        int balanceBeforeFirstCard = dashboardPage.getBalance(0);
        int balanceBeforeSecondCard = dashboardPage.getBalance(1);
        transferPage = dashboardPage.transferButton(1);
        transferPage.transfer(info, 100, 0);

        dashboardPage.assertBalance(1, balanceBeforeSecondCard + amount);
        dashboardPage.assertBalance(0, balanceBeforeFirstCard - amount);
    }
}
