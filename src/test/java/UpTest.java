import data.DataHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.*;

import static com.codeborne.selenide.Selenide.open;

public class UpTest {
    @Test
    void upBalanceTest() {
        String amount = "100";
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verifiPage = loginPage.validLogin(DataHelper.AuthInfo.getDefAuth());
        var selfKabPage = verifiPage.validCode(DataHelper.VerificationCode.getVerificationCodeFor());
        int balanceCardBeforeFirst = selfKabPage.getCardBalance(DataHelper.CardNumbers.getFirstCard());
        int balanceCardBeforeSecond = selfKabPage.getCardBalance(DataHelper.CardNumbers.getSecondCard());
        var deposPage = selfKabPage.upBalanceCard(DataHelper.CardNumbers.getFirstCard());
        var selfKabPage2 = deposPage.upBalanceCard(amount, DataHelper.CardNumbers.getSecondCard());
        int balanceCardAfterFirst = selfKabPage2.getCardBalance(DataHelper.CardNumbers.getFirstCard());
        int balanceCardAfterSecond = selfKabPage2.getCardBalance(DataHelper.CardNumbers.getSecondCard());
        int expected = balanceCardBeforeFirst + Integer.parseInt(amount);
        int expected2 = balanceCardBeforeSecond - Integer.parseInt(amount);
        Assertions.assertEquals(expected,balanceCardAfterFirst);
        Assertions.assertEquals(expected2,balanceCardAfterSecond);
    }
}
