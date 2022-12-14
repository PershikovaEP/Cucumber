package ru.netology.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import static com.codeborne.selenide.Selenide.$x;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
// Данный класс как пример генерации тестовых данных
// Вместа передачи данных через сценарий (feature)
// можно вызывать подобные методы непосредственно в шагах сценария (steps)
public class DataHelper {

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class Card {
        String number;
        String id;

    }

    public static Card getCard(String id) {
        Card card1 = new Card("5559000000000001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
        Card card2 = new Card("5559000000000002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
        Card[] cards = {card1, card2};
        Card resultCard = cards[0];
        if (id.equals("1")) {
            resultCard = cards[0];
            }
        if (id.equals("2")) {
            resultCard = cards[1];
        }
        return resultCard;
    }


}