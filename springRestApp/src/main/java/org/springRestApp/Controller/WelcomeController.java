package org.springRestApp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springRestApp.Configuration.dynamicConfiguration;
import org.springRestApp.Service.welcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@Autowired
	welcomeService myService;
	
	@Autowired
	dynamicConfiguration config;
	
	@RequestMapping("/welcome")
	public String welcome(@RequestParam String name)
	{
		String myStr =  myService.greet();
		return myStr+name;
	}
	
	@RequestMapping("/Config")
	public Map config()
	{
		Map myMap = new HashMap();
		myMap.put("Int Val", config.getIntData());
		myMap.put("Str Val", config.getStrData());
		myMap.put("bool Val", config.isBoolData());
		return myMap;
	}
}
