package ru.netology.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

//@Data
//public class DataHelper<cards> {
//    private String login = "vasya";
//    private String password = "qwerty123";
//    private String code = "12345";
//    private String[] cards = new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"};
//
//    public String getCardByIndex(int index) {
//        String card = cards[index];
//        return card;
//    }
//}
@Data
@RequiredArgsConstructor
public class DataHelper {
    private String[] cards = new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"};

    public String getCardByIndex(int index) {
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

