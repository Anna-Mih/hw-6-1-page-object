package ru.netology.data;

import lombok.Data;

@Data
public class DataHelper<cards> {
    private String login = "vasya";
    private String password = "qwerty123";
    private String code = "12345";
    private String[] cards = new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"};

    public String getCardByIndex(int index) {
        String card = cards[index];
        return card;
    }
}
