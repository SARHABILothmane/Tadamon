package com.Tadamon.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Tadamon.Entity.Accounts;
import com.Tadamon.Services.IserviceAccounts;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AccountsControllers {
	@Autowired
	private IserviceAccounts serviceAccounts;
	//
	@GetMapping(value="/accounts")
	public Accounts selectUser(@RequestParam("email") String email) {
		return serviceAccounts.findByEmail(email);
	}

////select all accounts
//	@GetMapping("/all/accounts")
//	public List<Accounts> selectAllAccount(){
//		return serviceAccounts.selectAllAccounts();
//	}
////select by id account
//	@GetMapping("/accounts/{id}")
//	public Accounts selectByIdAllAccount(@PathVariable("id") int id) {
//		return serviceAccounts.selectByIdAccounts(id).map(account ->{
//			return serviceAccounts.selectByIdAccounts(id).get();
//		}).orElseThrow(()-> new Error());
//	}
////add account
}
