package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tadamon.Dao.IaccountDao;
import com.Tadamon.Entity.Accounts;


@Service
public class ServiceAcount implements IserviceAccounts{
@Autowired
private IaccountDao accountDao;
//add Accounts
public void addModifierAccounts(Accounts a) {
	accountDao.save(a);
}
//select all Account
public List<Accounts> selectAllAccounts(){
	return accountDao.findAll();
}
//select by id Accounts
public Optional<Accounts> selectByIdAccounts(int id){
	return accountDao.findById(id);
}
//delet Accounts by id
public void deletAccounts(int id) {
	accountDao.deleteById(id);
} 
//
public Accounts findByEmail(String email) {
return accountDao.findByEmail(email);
}
}
