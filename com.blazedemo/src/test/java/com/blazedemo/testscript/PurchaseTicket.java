package com.blazedemo.testscript;

import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.blazedemo.generic.BaseClass;
import com.blazedemo.pom.BlazeDemo;

public class PurchaseTicket extends BaseClass{
	@Test
	public void purchaseFlightTicket() throws InterruptedException
	{
		BlazeDemo bd= new BlazeDemo(driver);
		Select s= new Select(bd.getChoseYourDepartureCityDropdown());
		s.selectByValue("Mexico City");

		Select s1= new Select(bd.getChooseYourDestinationCity());
		s1.selectByValue("London");
		bd.getFindFlightsBtn().click();
	
		List<WebElement> prices = driver.findElements(By.xpath("//td[6]"));
		
		TreeSet<Double> ts= new TreeSet();
		
		for(WebElement p: prices)
		{
			String pri = p.getText().replaceAll("[^0-9.]", "");
			ts.add(Double.valueOf(pri));
		}
	
		driver.findElement(By.xpath("//td[contains(text(),'"+ts.first() +"')]/..//input[@type='submit']")).click();
	String totalCost = driver.findElement(By.xpath("//p[text()='Total Cost: ']/em")).getText();
	Assert.assertTrue(totalCost.matches("\\d{3}\\.\\d{2}"), "Total Cost is not in the xxx.xx format");
	bd.getPurchaseTicket().click();
	String id = driver.findElement(By.xpath("//td[2]")).getText();
	Reporter.log("The Ticket"+id,true);

	}
}


