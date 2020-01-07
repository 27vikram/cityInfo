package com.cityinfo.mycity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;


public class MappingCall {

		
public CityInfoResponse getCityInfo(Request r) {
		
		CityInfoResponse cir = new CityInfoResponse();
	
		cir.setTemperature(getWeather(r.getCity()));
		cir.setAirport("Sri Guru.....");
		cir.setPollutionLevel(1.55);
		
		
		return cir;
	}
	
	
	
	public Double getWeather(String cityName) {
		String finalUrl = "";
		String baseurl = "https://api.openweathermap.org/data/2.5/weather?";
		String city = "q=" + cityName;	
		String apiKey = "appid=44e2250efae90837e072f5ace23ac51e"; 
		String units = "units=metric";
		
		finalUrl = baseurl +apiKey+"&"+city+"&"+units;		
				
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(finalUrl);
		HttpResponse response;
		BufferedReader rd;
		int temp_int = 0;
		double temp_double = 0.00;
		String temp = "";
		
		StringBuffer result = new StringBuffer();
		try {
			 response = client.execute(request);
			 rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				String cityInfoResult = result.toString();
				JSONObject cityInfoResponse = new JSONObject(cityInfoResult);
			
				
				temp_double = cityInfoResponse.getJSONObject("main").getDouble("temp");
		
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return temp_double;
}
	}
	
	
	
	
	
