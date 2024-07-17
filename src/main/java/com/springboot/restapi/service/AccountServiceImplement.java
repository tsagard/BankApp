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
