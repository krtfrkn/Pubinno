package com.pubinno.step_definitions;

import com.pubinno.pages.FactorialPage;
import com.pubinno.utilities.ConfigurationReader;
import com.pubinno.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class FactorialStepDef {

    FactorialPage factorialPage = new FactorialPage();
    String givenNumber;
    WebDriverWait wait = new WebDriverWait(Driver.get(),20);

    @Given("the user is on given page")
    public void the_user_is_on_given_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @And("the user enters {string} in the input box")
    public void theUserEntersInTheInputBox(String num) {
        factorialPage.inputBox.sendKeys(num);
        givenNumber = num;
    }

    @When("the user clicks on the calculate button")
    public void theUserClicksOnTheCalculateButton() {
        factorialPage.calculateButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultDiv")));
    }

    @Then("the user sees {string} as a result and the message of factorial")
    public void theUserSeesAsAResultAndTheMessageOfFactorial(String expectedResultOfFactorial) {
        assertEquals("Given number is NOT same in the message",givenNumber,factorialPage.getResultNumbers(factorialPage.resultMessage.getText())[0]);
        assertEquals("Result is NOT same in the message",expectedResultOfFactorial,factorialPage.getResultNumbers(factorialPage.resultMessage.getText())[1]);
    }
}
