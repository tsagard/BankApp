package com.springboot.restapi;


//This is Controller:

//Purpose: Handles HTTP requests and maps them to the appropriate service methods.
//Role: Acts as an interface between the client and the service layer. 
//Uses annotations like @RestController and @RequestMapping to define endpoints.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.entity.Account;
import com.springboot.restapi.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
     
	@Autowired
	AccountService service;
	
	@PostMapping("/create")                                         //localhost:8081/account/create
	public Account createAccount(@RequestBody Account account) {
	   Account createAccount = service.createAccount(account);
	   return createAccount;
	}
	@GetMapping("/{accountNumber}")                                 //localhost:8081/account/accountNumber
	public Account getaccdetails(@PathVariable Long accountNumber) {
		Account account = service.getaccdetails(accountNumber);
		return account;
	}
	@GetMapping("/getall")                                          //localhost:8081/account/getall
	public List<Account> getAllAccountDetails(){
	   List<Account> allAccountDetails = service.getAllAccountDetails();
	     return allAccountDetails;
	}	
	
	@PutMapping("/Deposit/{accountNumber}/{amount}")           //localhost:8081/account/Deposit//{accountNumber}/{amount}
	public Account depositMoney(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account account = service.depositMoney(accountNumber, amount);
		return account;
	}
	@PutMapping("/withdraw/{accountNumber}/{amount}")           //localhost:8081/account/withdraw/{accountNumber}/{amount}
	public Account withdrawMoney(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account account = service.withdrawMoney(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/Delete/{accountNumber}")                    //localhost:8081/account/Delete/{accountNumber}
	   public void deleteAccount(@PathVariable Long accountNumber) {
		service.closeAccount(accountNumber);
		
	}
}


















