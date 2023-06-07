package com.blazedemo.testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Set;

import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;


import com.blazedemo.generic.BaseClass;
import com.blazedemo.pom.BlazeDemo;

public class BlazeDemoTest1 extends BaseClass{

	@Test(priority = 2)
	public void testHomeTitle()
	{
		String etitle = driver.getTitle();
		String atitle = "Welcome to the Simple Travel Agency!";
		assertEquals(etitle, atitle,"The title is different");


	}

	@Test(priority = 1)
	public void testNavigation() throws InterruptedException
	{
		BlazeDemo bd= new BlazeDemo(driver);
		bd.getCheckOutLink().click();
		Set<String> wn = driver.getWindowHandles();
		int count = wn.size();

		if(count>1)
		{
			Reporter.log("the link is opened in new Tab",true);
		}
		else
		{
			Reporter.log("the link is  not opened in new Tab",true);
		}
		driver.navigate().back();
		String etitle = driver.getTitle();
		String atitle = "BlazeDemo";
		assertEquals(etitle, atitle,"Navigated back to home Page");



	}
}

	