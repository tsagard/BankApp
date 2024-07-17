package com.springboot.restapi.service;

import java.util.List;

import com.springboot.restapi.entity.Account;

public interface AccountService {
        public Account createAccount(Account account);
        public Account getaccdetails(Long accountNumber);
        public List<Account> getAllAccountDetails();
        public Account depositMoney(Long accountNumber,Double money);
        public Account withdrawMoney(Long accountNumber, Double money);
        public void closeAccount(Long accountNumber);
        
}
