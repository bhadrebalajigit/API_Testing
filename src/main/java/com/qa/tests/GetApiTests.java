package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.Restclient;

public class GetApiTests extends TestBase{

	public GetApiTests() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String url;
	@BeforeMethod
	public void  setup()
	{
		String serviceurl=prop.getProperty("url");
		String apiurl=prop.getProperty("serviceurl");
		 url=serviceurl + apiurl;
		
	}
	
	@Test
	public void getmethod() throws ClientProtocolException, IOException, JSONException
	{
		Restclient restclient=new Restclient();
		restclient.get(url);
	}
	
}
