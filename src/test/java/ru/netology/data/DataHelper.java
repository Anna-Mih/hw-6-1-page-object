package ru.netology.data;

import lombok.Value;

public class DataHelper {

    public static String getCardByIndex(int index) {
        String[] cards = new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"};
        String card = cards[index];
        return card;
    }

    @Value
    public static class Info {
        private String login;
        private String password;

    }

    public static Info getInfo() {
        return new Info("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

}

