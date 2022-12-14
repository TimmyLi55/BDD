package page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.util.StringJoiner;

import static com.codeborne.selenide.Selenide.$;

public class SelfKabPage {
    public SelenideElement firstCard = $("[data-test-id=92df3f1c-a033-48e6-8390-206f6b1f56c0]");
    public SelenideElement secondCard = $("[data-test-id=0f3f5c2a-249e-4c3d-8287-09f7a039391d]");

    private SelenideElement buttonReload = $("data-test-id=action-reload");
    private String stringBalanceStart = "баланс:";
    private String stringBalanceFinish = "р.";

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

    public int getCardBalance(SelenideElement card) {
        val balance = card.text();
        return pickFromText(balance);
    }

    public DepositsPage depositCard(SelenideElement card) {
        card.$("button").click();
        return new DepositsPage();
    }


}
