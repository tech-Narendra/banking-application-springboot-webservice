package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String accholdername;
	private int age;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(int id, String accholdername, int age, double balance) {
		super();
		this.id = id;
		this.accholdername = accholdername;
		this.age = age;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccholdername() {
		return accholdername;
	}
	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
