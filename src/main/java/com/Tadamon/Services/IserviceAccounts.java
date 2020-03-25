package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Accounts;

public interface IserviceAccounts {
	//add Accounts
	public void addModifierAccounts(Accounts a);
	//select all Account
	public List<Accounts> selectAllAccounts();
	//select by id Accounts
	public Optional<Accounts> selectByIdAccounts(int id);
	//delet Accounts by id
	public void deletAccounts(int id);
	//
	public Accounts findByEmail(String email);
}
