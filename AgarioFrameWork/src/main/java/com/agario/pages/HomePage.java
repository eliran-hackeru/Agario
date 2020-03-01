package com.agario.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.agario.utility.Helper;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "btnFacebookLogin") WebElement signIn;

	@FindBy(id = "freeCoins") WebElement freeCoins;

	@FindBy(xpath = "//span[.='Get Potions']") WebElement getPotions;

	@FindBy(id = "email") WebElement emailAddress;

	@FindBy(id = "pass") WebElement password;

	@FindBy(css = "input[value='Log In']") WebElement logIn;
	
	@FindBy(xpath="//span[.='Collect in:']") WebElement noCoins;

	public void clickSignIn() {
		signIn.click();
	}

	public void getFreeCoins() {
		Helper.swithcWindow(driver);

		Helper.waitForElementByID(driver, "freeCoins");
		
		freeCoins.click();
		
		for (int i=0; i<5; i++)
		{
			Helper.waitAsec();
		}	
	}

	public void getFreePorions() {

		getPotions.click();
		Helper.waitAsec();
	}

	public void userCredential(String emailApplication, String passwordApplication) {
		Helper.swithcWindow(driver);
		emailAddress.sendKeys(emailApplication);
		password.sendKeys(passwordApplication);
		logIn.click();

	}

}
