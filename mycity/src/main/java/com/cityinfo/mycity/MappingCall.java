package com.cityinfo.mycity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MappingCall {

	public String index2(Request r) {
		
		System.out.println(r.getCity());
			
		String finalUrl = "";
		String baseurl = "https://api.openweathermap.org/data/2.5/weather?";
		String city = "q=" + r.getCity();	
		String apiKey = "appid=44e2250efae90837e072f5ace23ac51e"; 
		String units = "units=metric";
		
		finalUrl = baseurl +apiKey+"&"+city+"&"+units;		
				
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(finalUrl);
		HttpResponse response;
		BufferedReader rd;
		Double str_data1 = null;
		StringBuffer result = new StringBuffer();
		try {
			 response = client.execute(request);
			 rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				String inLine = result.toString();
				JSONParser parse = new JSONParser();
				try {
					JSONObject jobj = (JSONObject)parse.parse(inLine);
					JSONObject obj1 = (JSONObject)jobj.get("main");
					str_data1 = (Double) obj1.get("temp");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return str_data1.toString();
		}
}
