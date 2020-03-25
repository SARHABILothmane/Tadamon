package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Tadamon.Dao.IvolunteersDao;
import com.Tadamon.Entity.Cities;
import com.Tadamon.Entity.Volunteers;

@Service
public class ServiceVolunteers implements IserviceVolunteers{
	@Autowired
	private IvolunteersDao volunteersDao;
	@Autowired
	PasswordEncoder passwordencoder; 
	//add volunteer
	    public void addModifieVolunteers(Volunteers v) {
	    	v.setPassword(passwordencoder.encode(v.getPassword()));
	    	volunteersDao.save(v);
	    }
	//select all volunteers
	    public List<Volunteers> selectAllVolunteers(){
	    	return volunteersDao.findAll();
	    }
	//select by id volunteers
	    public Optional<Volunteers> selectByIdVolunteers(int id){
	    	return volunteersDao.findById(id);
	    }
	//delet volunteers by id
	    public void deletVolunteers(int id) {
	    	volunteersDao.deleteById(id);
	    } 
	    

}
