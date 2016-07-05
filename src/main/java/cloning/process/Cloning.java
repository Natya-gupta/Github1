package cloning.process;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qait.automation.GitHubAutomation.TestData;

public class Cloning
{
	WebDriver driver;
	String comment;
	 
public Cloning()
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
public  String writeFile() throws IOException, InterruptedException
{
	String UserName="Natya-gupta";                              //getting url
    String RepoName="abc";
    String CloneUrl="https://github.com/"+UserName+"/"+RepoName+".git";
    String workDir = System.getProperty("user.dir");
    String fil = "demo.sh";
    File myFile = new File(workDir + fil);
    String userPath = myFile.getPath();
    System.out.println("workDir : "+workDir);
    System.out.println("myFile : "+myFile);
	System.out.println("userPath:"+userPath);
    
    File file = new File(workDir +"/fil");
	file.createNewFile();
    file.setExecutable(true);
	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	PrintWriter pw = new PrintWriter(fw);
    pw.println("#!/bin/bash"); 
    pw.println("cd ~");
    pw.println("cd Desktop");
    pw.println("mkdir abc");
    pw.println("git clone "+CloneUrl);
    pw.println("cd abc");
    pw.println("touch Readme.txt");
    
    pw.println("git add Readme.txt");
   comment="added by terminal";
    Date date= new Date();
	 String timestamp=new Timestamp(date.getTime()).toString();

   System.out.println(timestamp);
	
	 String msg="added by terminal"+timestamp;

   
    pw.println("git commit -m \""+comment+"\"");
    pw.println("git push https://"+"Natya-gupta"+":"+"Passw0rd"+"@github.com/"+"Natya-gupta"+"/"+"abc"+".git");
 
    pw.close();	
    try{
		ProcessBuilder pb = new ProcessBuilder(workDir+"/fil");
		 Process p = pb.start();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 String line = null;
		 while ((line = reader.readLine()) != null)
		 {
		    System.out.println(line);
		 }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    return comment;
    }


public String pullCommand() throws Exception
{
	String workDir = System.getProperty("user.dir");
    String fil1 = "pulling.sh";
    File myFile1 = new File(workDir + fil1);
    String userPath = myFile1.getPath();
    System.out.println("workDir : "+workDir);
    System.out.println("myFile : "+myFile1);
	System.out.println("userPath:"+userPath);
    
    File file = new File(workDir +"/fil1");
	file.createNewFile();
    file.setExecutable(true);
	File file1 = new File("/home/natyagupta/Desktop/pulling.sh");
	file1.createNewFile();
    file1.setExecutable(true);
	FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
	PrintWriter pw1 = new PrintWriter(fw1);
    pw1.println("#!/bin/bash"); 
    pw1.println("cd ~");
    pw1.println("cd Desktop");
    pw1.println("cd abc");
    pw1.println("git pull ");
    pw1.println("git status");
    pw1.close();
    Process p1=new ProcessBuilder(workDir+"/fil1").start();
    int rc = p1.waitFor();
    InputStream is = p1.getInputStream();
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	String line = null;
	while ((line = reader.readLine()) != null)
		System.out.println(line);
	    BufferedReader br = new BufferedReader(new FileReader("/home/natyagupta/Desktop/abc/ReadMe.txt"));
	    String updatedline = br.readLine();
	    br.close();
	   return updatedline;

}
}
