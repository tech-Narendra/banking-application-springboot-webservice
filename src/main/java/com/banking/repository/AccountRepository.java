package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	public List<Account> findByAccholdername(String name);
	
	public List<Account> findByAge(int age);
	
}
