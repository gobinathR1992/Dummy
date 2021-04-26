package testCase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.Test;


public class TestRunner {


	//static UtilitiesForApplication utils = new UtilitiesForApplication();
	static String env;
	static String wireMockValue;
	
	static StubServerMain ss = new StubServerMain();
	
	public static void main(String[] args) throws IOException {
		TestRunner.start();
	}

	public static void start() throws IOException {
		
		
			Properties props = new Properties();
			
			FileInputStream inStream;
				String path = System.getProperty("user.dir");
				//System.out.println(path);
				inStream = new FileInputStream(path+"\\config.properties");
				props.load(inStream);
				inStream.close();
				
				wireMockValue = props.getProperty("WireMock");
				//System.out.println(wireMockValue);
					

				if(wireMockValue.equalsIgnoreCase("on"))
					StubServerMain.startStub();
				else
				{
					//suites.add(path+"//RealApiTestNG.xml");
					System.out.println("Real Api Class");
				}
				//testng.setTestSuites(suites);
				//testng.run();
				
			}
	
	
}

