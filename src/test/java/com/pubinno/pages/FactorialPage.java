package com.pubinno.pages;

import com.pubinno.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactorialPage {

    public FactorialPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "number")
    public WebElement inputBox;

    @FindBy(id = "getFactorial")
    public WebElement calculateButton;

    @FindBy(id = "resultDiv")
    public WebElement resultMessage;

    public String[] getResultNumbers (String message){
        String[] parts = message.split(" ");
        String givenNumber = parts[3];
        String resultOfFactorial = parts[5];
        String[] listOfNums = {givenNumber,resultOfFactorial};
        return listOfNums;
    }
}
