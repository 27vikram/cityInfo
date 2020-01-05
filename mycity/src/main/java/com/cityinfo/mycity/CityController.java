package com.cityinfo.mycity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CityController {
	
	@GetMapping(value="/cityinfo")
	public String cityinfo(@RequestParam(required=true) String q, @RequestParam(required=false) String units, @RequestParam(required=true) String appid) {
		Request r = new Request();
		r.setApiKey("44e2250efae90837e072f5ace23ac51e");
		r.setCity(q);
		r.setUnit("metric");
		
		MappingCall mc = new MappingCall();
		String result2 = mc.index2(r);
		
		String population = "11,30,000";
		String size = "210 km²";
		String airport = "Sri Guru Ram Dass Jee International Airport";
		
		return 	"Temperature: "+result2+"\n"+ "Population: "+population+"\n"+ "Size: "+size+"\n"+ "Airport: "+airport;
	}

}
