package com.springboot.restapi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.restapi.entity.Account;

import com.springboot.restapi.repo.AccountRepository;

@Service
public class AccountServiceImplement implements AccountService {
    @Autowired
    AccountRepository repo;
	
    @Override
	public Account createAccount(Account account) {
		Account account_save = repo.save(account);
		return account_save;
	}                                                   //Done

	@Override
	public Account getaccdetails(Long accountNumber) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("account does not exists");
		}
		Account account_found=account.get();
		return account_found;                        //Done
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> allAccount = repo.findAll();
		return allAccount;                           //Done
	}

	@Override
	public Account depositMoney(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
		throw new RuntimeException("account does not exists");
		}
		Account accountPresent=account.get();
		Double totalBalance = accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrawMoney(Long accountNumber, Double amount) {
			Optional<Account> account = repo.findById(accountNumber);
			if(account.isEmpty()) {
			throw new RuntimeException("account does not exists");
			}
			Account accountPresent=account.get();
			
			Double totalBalance = accountPresent.getAccount_balance()-amount;
			accountPresent.setAccount_balance(totalBalance);
			repo.save(accountPresent);
			return accountPresent;
		
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getaccdetails(accountNumber);
		repo.deleteById(accountNumber);
	}
}
/*Explanation of the Service Implementation

Annotations:
@Service: Marks the class as a service provider in the Spring context.

@Transactional: Ensures that the methods are executed within a transactional context, 
providing rollback capabilities in case of errors.
Dependency Injection:

 @Autowired: Injects the UserRepository to interact with the database. 
 
 CRUD Methods: 
  
  createUser: Saves a new user to the database. 
  getUserById: Retrieves a user by their ID. 
  getAllUsers: Retrieves all users. 
  updateUser: Updates the details of an existing user. 
  deleteUser: Deletes a user by their ID. 
  Error Handling:The updateUser method includes error handling for cases where the user is not found.

This service implementation handles the business logic and data manipulation required for CRUD operations, 
providing a clean separation of concerns and ensuring maintainability and scalability of the application.*/



