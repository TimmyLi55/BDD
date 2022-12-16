package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verCode = $("[data-test-id=code] input");
    private SelenideElement buttonNext = $("[data-test-id=action-verify]");

    public SelfKabPage validCode(DataHelper.VerificationCode code) {
        verCode.setValue(code.getCode());
        buttonNext.click();
        return new SelfKabPage();
    }

}
