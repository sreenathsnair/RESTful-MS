package org.springRestApp.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class welcomeService {
	
	@Value("${welcome.message}")
	public String greetings;
	
	public String greet()
	{
		//return "Welcome to Spring Boot Rest App!!!";
		return greetings;
	}
}
