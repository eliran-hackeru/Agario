package com.agario.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.agario.pages.BaseClass;
import com.agario.pages.HomePage;

public class CoinsTest extends BaseClass
{
	@Test
	public void agarioApp()
	{
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.clickSignIn();
		
		homePage.userCredential("mendybendavid@gmail.com", "0142450220Be");
		
		homePage.getFreeCoins();
		
//		homePage.getFreePorions();
	}

}
