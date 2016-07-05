package com.qait.automation.GitHubAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
WebDriver driver;
public LogInPage(WebDriver driver)
{
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
@FindBy(name="login")
public WebElement username;
		
@FindBy(name="password")
public WebElement password;

@FindBy(name="commit")
public WebElement logIn;
		
public String enterDetails() throws InterruptedException
{
		//username.sendKeys("Natya-gupta");
		username.sendKeys(TestData.getvalue("Username"));
		password.sendKeys(TestData.getvalue("Password"));
		//password.sendKeys("Passw0rd");
		logIn.click();
		Thread.sleep(2000);
		return driver.getTitle();
}
}
