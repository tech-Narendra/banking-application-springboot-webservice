package com.banking.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.banking.accountDTO.AccountDto;
import com.banking.entity.Account;
import com.banking.exceptionHandler.IdNotFoundException;
import com.banking.exceptionHandler.InSufficientBalance;
import com.banking.mapper.AccountMapper;
import com.banking.repository.AccountRepository;
import com.banking.service.accountservice.AccontService;

@Component
public class AccountServiceImplementation implements AccontService{
	
	@Autowired
	AccountRepository accrepo;

	@Override
	public AccountDto createAccount(AccountDto accdto) {
		Account acc = AccountMapper.maptoacc(accdto);
		accrepo.save(acc);
		return AccountMapper.maptoaccdto(acc);
	}

	@Override
	public AccountDto getAccount(int id) {
		Account accid = accrepo.findById(id).orElseThrow(()->new IdNotFoundException());
		return AccountMapper.maptoaccdto(accid);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> allaccounts = accrepo.findAll();
		return allaccounts.stream().map((account)->AccountMapper.maptoaccdto(account)).collect(Collectors.toList());
	}

	@Override
	public AccountDto deposit(int id, double balance) {
		Account acc = accrepo.findById(id).orElseThrow(()->new IdNotFoundException());
		acc.setBalance(acc.getBalance()+balance);
		accrepo.save(acc);
		return AccountMapper.maptoaccdto(acc);
	}

	@Override
	public AccountDto withdraw(int id, double balance) {
		Account acc = accrepo.findById(id).orElseThrow(()->new IdNotFoundException());
		if(balance>acc.getBalance()) {
			throw new InSufficientBalance();
		}
		acc.setBalance(acc.getBalance()-balance);
		accrepo.save(acc);
		return AccountMapper.maptoaccdto(acc);
	}

	@Override
	public List<AccountDto> findbyname(String name) {
		List<Account> accs = accrepo.findByAccholdername(name);
		return accs.stream().map((account)->AccountMapper.maptoaccdto(account)).collect(Collectors.toList());
	}

	@Override
	public List<AccountDto> findbyage(int age) {
		List<Account> accs = accrepo.findByAge(age);
		return accs.stream().map((account)->AccountMapper.maptoaccdto(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteacc(int id) {
		Account accid = accrepo.findById(id).orElseThrow(()->new IdNotFoundException());
		accrepo.deleteById(accid.getId());
	}

	@Override
	public void deleteall() {
		accrepo.deleteAll();
	}

}
