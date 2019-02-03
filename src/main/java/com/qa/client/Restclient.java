package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Restclient 

	{
		public void get(String url) throws ClientProtocolException, IOException, JSONException
		{
			CloseableHttpClient httpclient= HttpClients.createDefault();
			HttpGet httpget= new HttpGet(url);
			CloseableHttpResponse closeabehttpresponse= httpclient.execute(httpget);
			int statusCode=closeabehttpresponse.getStatusLine().getStatusCode();
			System.out.println("HTTP Response code:"+statusCode);
			String responsestring=EntityUtils.toString(closeabehttpresponse.getEntity(),"UTF-8");
			JSONObject responsejson=new JSONObject(responsestring);
			System.out.println("Response JSON:"+responsejson);
			Header[] headerarray=closeabehttpresponse.getAllHeaders();
			HashMap<String, String> allheaders=new HashMap<String, String>();
			for(Header header:headerarray)
			{
				allheaders.put(header.getName(), header.getValue());
			}
			System.out.println("All Headers:"+allheaders);
		}

	}
