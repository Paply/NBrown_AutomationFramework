package com.cname.core.framework.datalayer;

import java.io.FileInputStream;
import java.util.Properties;

import com.cname.core.framework.utility.Constants;

public class Property 
{
	public static String getProData(String key)
	{
		String data=null;
		try
		{
			FileInputStream fis = new FileInputStream(Constants.sConfigFolderPath);
			Properties pro = new Properties();
			pro.load(fis);
			data = pro.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
