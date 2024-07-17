package com.springboot.restapi.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@EntityScan
@Table
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private long account_number;
	@Column
     private String account_name;
	@Column
     private double account_balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(String account_name, double account_balance) {
		super();
		this.account_name = account_name;
		this.account_balance = account_balance;
	}


	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", account_name=" + account_name + ", account_balance="
				+ account_balance + "]";
	}
    
}
