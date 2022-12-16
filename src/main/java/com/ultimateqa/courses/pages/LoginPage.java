package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeText;
    @FindBy(id = "user[email]")
    WebElement emailField;
    @FindBy(name = "user[password]")
    WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement errorMessage;

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public void enterEmail(String email) {
        Reporter.log("Entered email " + email + " in email field " + emailField.toString());
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        Reporter.log("Entered password " + password + " in password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnSignInButton() {
        Reporter.log("Clicked on signin " + signInButton.toString());
        clickOnElement(signInButton);
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }
}
