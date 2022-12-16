package data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String pass;

        public static AuthInfo getDefAuth() {
            return new AuthInfo("vasya", "qwerty123");
        }
    }


    @Value
    public static class VerificationCode {
        private String code;

        public static VerificationCode getVerificationCodeFor() {
            return new VerificationCode("12345");

        }
    }


    @Value
    public static class CardNumbers {
        private String number;
        private int defBalance;
        private String idCard;

        public static CardNumbers getFirstCard() {
            return new CardNumbers("5559 0000 0000 0001", 10_000,"92df3f1c-a033-48e6-8390-206f6b1f56c0");
        }

        public static CardNumbers getSecondCard() {
            return new CardNumbers("5559 0000 0000 0002", 10_000,"0f3f5c2a-249e-4c3d-8287-09f7a039391d");
        }
    }


}