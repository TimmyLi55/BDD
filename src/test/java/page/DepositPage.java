package page;

import com.codeborne.selenide.*;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class DepositPage {
    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement upButton = $("[data-test-id=action-transfer]");
    private SelenideElement buttonCancel = $("[data-test-id=action-cancel]");

    public SelfKabPage upBalanceCard(String amount, DataHelper.CardNumbers card) {
        this.amount.setValue(amount);
        from.setValue(card.getNumber());
        upButton.click();
        return new SelfKabPage();
    }
}
