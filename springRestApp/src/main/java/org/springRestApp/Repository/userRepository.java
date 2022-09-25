package org.springRestApp.Repository;

import java.util.List;

import org.springRestApp.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
interface userRepository extends CrudRepository<User, Long>{
	List<User> findByRole(String role);

}
