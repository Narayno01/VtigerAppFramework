package com.crm.Vtiger.Framework.Fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.xml.XmlTest;

import com.crm.Vtiger.Framework.ListenerUtility.IpathConstants;

public class JSONFileUtility implements IpathConstants {

	public String getDataFromJSONFile( String Key) throws FileNotFoundException, IOException, ParseException {
	
		
	//step1: parse Json Physical file into java object using jasonparse class
			JSONParser parser= new JSONParser();
			Object obj=parser.parse(new FileReader(JSONfilepath));
			//step2: convert java object to json object
			JSONObject map= (JSONObject) obj;
			
			String Value =map.get(Key).toString();
			
			return Value;
}
}