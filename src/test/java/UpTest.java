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
        var verifiPage = loginPage.validLogin(DataHelper.getDefAuth());
        var selfKabPage = verifiPage.validCode(DataHelper.getVerificationCodeFor());
        int balanceCardBeforeFirst = selfKabPage.getCardBalance(DataHelper.getFirstCard());
        int balanceCardBeforeSecond = selfKabPage.getCardBalance(DataHelper.getSecondCard());
        var deposPage = selfKabPage.upBalanceCard(DataHelper.getFirstCard());
        var selfKabPage2 = deposPage.upBalanceCard(amount, DataHelper.getSecondCard());
        int balanceCardAfterFirst = selfKabPage2.getCardBalance(DataHelper.getFirstCard());
        int balanceCardAfterSecond = selfKabPage2.getCardBalance(DataHelper.getSecondCard());
        int expected = balanceCardBeforeFirst + Integer.parseInt(amount);
        int expected2 = balanceCardBeforeSecond - Integer.parseInt(amount);
        Assertions.assertEquals(expected,balanceCardAfterFirst);
        Assertions.assertEquals(expected2,balanceCardAfterSecond);
    }
}
