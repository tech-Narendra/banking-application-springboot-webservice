package com.banking.service.accountservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.accountDTO.AccountDto;

@Service
public interface AccontService {
	
	public AccountDto createAccount(AccountDto accdto);
	
	public AccountDto getAccount(int id);
	
	public List<AccountDto> findbyname(String name);
	
	public List<AccountDto> findbyage(int age);
	
	public List<AccountDto> getAllAccounts();
	
	public AccountDto deposit(int id, double balance);
	
	public AccountDto withdraw(int id, double balance);
	
	public void deleteacc(int id);
	
	public void deleteall();

}
