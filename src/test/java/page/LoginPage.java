package page;
import data.DataHelper;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement actionButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(DataHelper.getDefAuth().getLogin());
        passwordField.setValue(DataHelper.getDefAuth().getPass());
        actionButton.click();
        return new VerificationPage();

    }

}
