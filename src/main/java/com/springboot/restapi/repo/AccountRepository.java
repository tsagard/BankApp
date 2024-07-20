package com.springboot.restapi.repo;


//Repository Interface:
//Purpose: Provides CRUD operations for the entity.
//Role: Extends JpaRepository or CrudRepository to leverage Spring Data JPA functionalities like saving, deleting, 
//and finding entities without boilerplate code.
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
