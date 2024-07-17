package com.springboot.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
