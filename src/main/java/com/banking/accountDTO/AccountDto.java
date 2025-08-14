package com.banking.accountDTO;

public class AccountDto {
	
	private int id;
	private String accholdername;
	private int age;
	private double balance;
	
	public AccountDto(int id, String accholdername, int age, double balance) {
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
