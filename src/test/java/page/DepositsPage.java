package page;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

public class DepositsPage {


    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement fromCard = $("[data-test-id=from] input");
    private SelenideElement buttonAction = $("[data-test-id=action-transfer]");

    public SelfKabPage upToFirstCard(String amount, DataHelper.CardNumbers numbers) {
        this.amount.setValue(amount);
        fromCard.setValue(numbers.getNumber());
        buttonAction.click();
        return new SelfKabPage();
    }
}
