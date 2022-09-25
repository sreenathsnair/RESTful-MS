package org.springRestApp.Repository;

import java.util.List;

import org.springRestApp.Model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usres", path = "users")
interface userRestRepository extends PagingAndSortingRepository<User, Long>{
	List<User> findByRole(@Param("role") String role);
}
