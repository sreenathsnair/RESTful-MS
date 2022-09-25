package org.springRestApp.Repository;

import org.springRestApp.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class userCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private userRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Sreenath", "Admin"));
		repository.save(new User("Eeshu", "User"));
		repository.save(new User("Ponnu", "User"));
		
		for(User user:repository.findAll())
			System.out.println(user);

		for(User user:repository.findByRole("User"))
			System.out.println(user);
		
	}

}
