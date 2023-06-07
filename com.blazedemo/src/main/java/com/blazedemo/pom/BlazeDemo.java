package com.blazedemo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.generic.BaseClass;

public class BlazeDemo extends BaseClass{

	@FindBy(xpath="//select[@name='fromPort']")
	private WebElement choseYourDepartureCityDropdown;
	
	@FindBy(xpath="//select[@name='toPort']")
	private WebElement ChooseYourDestinationCity;
	
	@FindBy (xpath="//a[contains(text(),'The Beach!')]")
	private WebElement CheckOutLink;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement FindFlightsBtn;
	
	@FindBy(xpath="//input[@value='Purchase Flight']")
	private WebElement purchaseTicket;
	
	public BlazeDemo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getChoseYourDepartureCityDropdown() {
		return choseYourDepartureCityDropdown;
	}

	public WebElement getChooseYourDestinationCity() {
		return ChooseYourDestinationCity;
	}

	public WebElement getCheckOutLink() {
		return CheckOutLink;
	}

	public WebElement getFindFlightsBtn() {
		return FindFlightsBtn;
	}

	public WebElement getPurchaseTicket() {
		return purchaseTicket;
	}
	
	
	
	
}
