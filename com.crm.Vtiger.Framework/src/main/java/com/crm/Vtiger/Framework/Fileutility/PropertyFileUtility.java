package com.crm.Vtiger.Framework.Fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.crm.Vtiger.Framework.ListenerUtility.IpathConstants;

public class PropertyFileUtility implements IpathConstants{

	public String getPropertyValue(String Key) throws IOException {
		FileInputStream fis=new FileInputStream(propertyfilepath);

				Properties p=new Properties();
				p.load(fis);

					String data=p.getProperty(Key);
					return data;
					
	}
	
	

}
