package com.springboot.restapi.service;

///*Service Layer:
///Purpose: Encapsulates business logic and coordinates between the repository and the controller.
////Role: Provides methods for business operations and transactional management. 
////Helps in separating business logic from presentation and data access layers.
//Service Implementation
//Implements the business logic methods defined in the service interface.*/
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
