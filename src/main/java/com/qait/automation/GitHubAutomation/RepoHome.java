package com.qait.automation.GitHubAutomation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RepoHome {
WebDriver driver;
String comitMsg;
	
public RepoHome(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
@FindBy(xpath="(//td[@class='message'])[1]//a")
public WebElement commit;
	
@FindBy(linkText="Readme.txt")
public WebElement ReadMe;
	
@FindBy(css=".octicon-pencil")
public WebElement Pencil;
	
@FindBy(css=".ace_text-input")
public WebElement type;
	
@FindBy(id="submit-file")
public WebElement submit;
	
public String getCommitMsg()
{
	   comitMsg=commit.getText();
	   return comitMsg;
}
	
public void editReadMe() throws InterruptedException
{
	ReadMe.click();
	Thread.sleep(3000);
	Pencil.click();
	Thread.sleep(3000);
	type.sendKeys(TestData.getvalue("Text"));
	submit.click();
}
}
