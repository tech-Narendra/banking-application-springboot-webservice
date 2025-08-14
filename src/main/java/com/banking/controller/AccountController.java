package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.accountDTO.AccountDto;
import com.banking.service.accountservice.AccontService;

@RestController
@RequestMapping("/banking/accounts")
public class AccountController {
	
	@Autowired
	AccontService accservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<AccountDto>> save(@RequestBody AccountDto accdto) {
		ResponseStructure<AccountDto> resp = new ResponseStructure<>(HttpStatus.CREATED.value(),"Account Created", accservice.createAccount(accdto));
		return new ResponseEntity<ResponseStructure<AccountDto>>(resp,HttpStatus.CREATED);
	}
	
	@GetMapping("/getacc")
	public ResponseEntity<ResponseStructure<AccountDto>> getAccount(@RequestParam int id) {
		ResponseStructure<AccountDto> resp = new ResponseStructure<>(HttpStatus.OK.value(),"Successful", accservice.getAccount(id));
		return new ResponseEntity<ResponseStructure<AccountDto>>(resp,HttpStatus.OK);
	}
	
	@GetMapping("/getallaccounts")
	public ResponseEntity<ResponseStructure<List<AccountDto>>> getallAccounts() {
		ResponseStructure<List<AccountDto>> resp = new ResponseStructure<>(HttpStatus.OK.value(),"Successful", accservice.getAllAccounts());
		return new ResponseEntity<ResponseStructure<List<AccountDto>>>(resp,HttpStatus.OK);
	}
	
	@PutMapping("/deposit")
	public ResponseEntity<ResponseStructure<AccountDto>> deposit(@RequestParam int id, double balance) {
		ResponseStructure<AccountDto> resp = new ResponseStructure<>(HttpStatus.OK.value(),"Deposit Successful", accservice.deposit(id, balance));
		return new ResponseEntity<ResponseStructure<AccountDto>>(resp,HttpStatus.OK);
	}
	
	@PutMapping("/withdraw")
	public ResponseEntity<ResponseStructure<AccountDto>> withdraw(@RequestParam int id, double balance) {
		ResponseStructure<AccountDto> resp = new ResponseStructure<>(HttpStatus.OK.value(),"Withdrawl Successful", accservice.withdraw(id, balance));
		return new ResponseEntity<ResponseStructure<AccountDto>>(resp,HttpStatus.OK);
	}
	
	@GetMapping("/getbyname/{accholdername}")
	public ResponseEntity<ResponseStructure<List<AccountDto>>> getaccbyname(@PathVariable String accholdername) {
		ResponseStructure<List<AccountDto>> resp = new ResponseStructure<>(HttpStatus.OK.value(),"Successful", accservice.findbyname(accholdername));
		return new ResponseEntity<ResponseStructure<List<AccountDto>>>(resp,HttpStatus.OK);
	}
	
	@GetMapping("/getbyage/{age}")
	public ResponseEntity<ResponseStructure<List<AccountDto>>> getaccbyage(@PathVariable int age) {
		ResponseStructure<List<AccountDto>> resp = new ResponseStructure<>(HttpStatus.OK.value(),"Successful", accservice.findbyage(age));
		return new ResponseEntity<ResponseStructure<List<AccountDto>>>(resp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteacc(@RequestParam int id) {
		accservice.deleteacc(id);
		return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String> delete(){
		accservice.deleteall();
		return new ResponseEntity<String>("All Accounts Deleted", HttpStatus.OK);
	}

}
