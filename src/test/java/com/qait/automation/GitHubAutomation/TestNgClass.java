package com.qait.automation.GitHubAutomation;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cloning.process.Cloning;

public class TestNgClass 
{
		WebDriver driver;
		String url;
		SignInPage sign;
		LogInPage logIn;
		HomePage home;
		CreateRepo repo;
		Cloning clone;
		RepoHome repoHomePage;
		String UIcommit;
		String commit;
		DetectOS detect;
		TestData data;
		String updatedline;
    	private final static Logger logger = Logger.getLogger(TestNgClass.class.getName());
		@BeforeClass
		public void initialize() throws SecurityException, IOException{
			driver=new FirefoxDriver();
			url="https://github.com/";
			sign=new SignInPage(driver);
			logIn=new LogInPage(driver);
		    home=new HomePage(driver);
			repo=new CreateRepo(driver);
			clone=new Cloning();
			repoHomePage=new RepoHome(driver);
			detect=new DetectOS();
			data=new TestData();
			String workDir = System.getProperty("user.dir");
		    String fil2 = "MyLogFile.log";
		    File myFile = new File(workDir + fil2);
		    String userPath = myFile.getPath();
		    System.out.println("workDir : "+workDir);
		    System.out.println("myFile : "+myFile);
			System.out.println("userPath:"+userPath);
		    
			
		FileHandler  fh = new FileHandler(workDir +"/fil2");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);}
		
		@Test
		public void case1() throws Exception                   
		{
			driver.get(url);
			driver.manage().window().maximize();
			String title1=sign.click2();
			Assert.assertEquals(title1,"Sign in to GitHub · GitHub");
			 logger.info("Verify the both the titles");
		}
		@Test
		public void case2() throws InterruptedException
		{
			String title2=logIn.enterDetails();
			Assert.assertEquals(title2,"GitHub");
			 logger.info("Verify the details of user");

		}
		@Test
		public void case3()
		{
		String title3=home.create_repo();
		Assert.assertEquals(title3,"Create a New Repository");
		repo.enter();
		 logger.info("Verify the Repository is create");

		}
		
		@Test
		public void case4() throws Exception               
		{
			commit=clone.writeFile();
			Thread.sleep(2000);
			driver.navigate().refresh();
			UIcommit=repoHomePage.getCommitMsg();
			Assert.assertEquals(UIcommit,commit);
			logger.info("verify the commits");
		}
		@Test
		public void case5() throws Exception
		{
			repoHomePage.editReadMe();
			updatedline=clone.pullCommand();
			clone.pullCommand();
			driver.quit();
			logger.info("verify the pull command");
		}
		
		@Test
		public void case6() throws Exception
		{
			DetectOS.isUnix();
			 logger.info("Verify the unix");

		
		}
		@Test
		public void case7() throws Exception
		{
			DetectOS.isWindows();
			logger.info("verify the windows");
		}
		@Test
		public void case8() throws Exception
		{
			repoHomePage.editReadMe();
	        String b1=clone.pullCommand();
			 clone.pullCommand();
			 Assert.assertEquals(b1,"True");
			 logger.info("Verifying pull operation");
		
		}
		
		
	    @Test(dependsOnMethods={"case5"})
		public void case9() throws Exception
		{
	    	Assert.assertEquals(TestData.getvalue("Text"),updatedline);
	    	logger.info("This is info : Updation text given by you matches Updated text of ReadMe.txt file");	
		}

}



