package com.qait.automation.GitHubAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateRepo {
WebDriver driver;
public CreateRepo(WebDriver driver)
{
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
@FindBy(id="repository_name")
public WebElement repo_name;
	
//@FindBy(id="repository_auto_init")
//public WebElement readMe;
	
@FindBy(className="btn-primary")
public WebElement make;
	
public void enter()
{
		repo_name.sendKeys(TestData.getvalue("RepositoryName"));
		make.click();
}
}
