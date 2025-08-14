package com.banking.mapper;

import com.banking.accountDTO.AccountDto;
import com.banking.entity.Account;

public class AccountMapper {
	
	public static AccountDto maptoaccdto(Account acc) {
		AccountDto accdto = new AccountDto(acc.getId(),acc.getAccholdername(), acc.getAge(), acc.getBalance());
		return accdto;
	}
	
	public static Account maptoacc(AccountDto accdto) {
		Account acc = new Account(accdto.getId(), accdto.getAccholdername(), accdto.getAge(), accdto.getBalance());
		return acc;
	}

}
