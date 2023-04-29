package com.cname.core.framework.utility;

public class FileUploadhandler 
{
	public static void uploadFile(String filePath)
	{
		try 
		{
			Runtime.getRuntime().exec(Constants.uploadexefile+" "+filePath);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
