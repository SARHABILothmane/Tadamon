package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Tadamon.Dao.IadminDao;
import com.Tadamon.Entity.Admin;

@Service
public class ServiceAdmin implements IserviceAdmin{
@Autowired
private IadminDao adminDao;
@Autowired
PasswordEncoder passwordencoder; 
//add admin
    public void addModifierAdmin(Admin a) {
    	a.setPassword(passwordencoder.encode(a.getPassword()));
    	adminDao.save(a);
    }
//select all admin
    public List<Admin> selectAllAdmin(){
    	return adminDao.findAll();
    }
//select by id admin
    public Optional<Admin> selectByIdAdmin(int id){
    	return adminDao.findById(id);
    }
//delet admin by id
    public void deletAdmin(int id) {
    	adminDao.deleteById(id);
    } 
}
