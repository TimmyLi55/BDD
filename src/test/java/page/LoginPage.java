package page;
import data.DataHelper;
import lombok.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;


import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement actionButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getDefAuth().getLogin());
        passwordField.setValue(info.getDefAuth().getPass());
        actionButton.click();
        return new VerificationPage();

    }

}
