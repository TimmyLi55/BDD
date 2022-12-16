package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import lombok.val;


import static com.codeborne.selenide.Selenide.*;

public class SelfKabPage {

    private SelenideElement buttonReload = $("[data-test-id=action-reload]");
    private String stringBalanceStart = "баланс: ";
    private String stringBalanceFinish = " р.";

    private ElementsCollection cards = $$(".list__item div");

    public SelfKabPage reloadPage() {
        buttonReload.click();
        return this;
    }


    public int pickFromText(String text) {
        val start = text.indexOf(stringBalanceStart);
        val finish = text.indexOf(stringBalanceFinish);
        val value = text.substring(start + stringBalanceStart.length(), finish);
        return Integer.parseInt(value);

    }

    public int getCardBalance(DataHelper.CardNumbers dataCard) {
        val balance = cards.findBy(Condition.attribute("data-test-id", dataCard.getIdCard())).text();
        return pickFromText(balance);
    }

    public DepositPage upBalanceCard (DataHelper.CardNumbers dataCard){
        cards.findBy(Condition.attribute("data-test-id", dataCard.getIdCard())).$("button").click();
        return new DepositPage();
    }

}
