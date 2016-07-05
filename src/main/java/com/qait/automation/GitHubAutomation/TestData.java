package com.qait.automation.GitHubAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class TestData {
	public static String getvalue(String s)
	{
        // The path of your YAML file.
      final String fileName = "/home/natyagupta/Desktop/github.yaml";
      
      Yaml yaml = new Yaml();
      Object obj;
      Map result = null;
      try {
         InputStream ios = new FileInputStream(new File(fileName));
         
         // Parse the YAML file and return the output as a series of Maps and Lists
          obj =yaml.load(ios);
          result=(Map)obj;
         System.out.println(result.toString());
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      String str = result.get(s).toString();
		return str;
   }
}
