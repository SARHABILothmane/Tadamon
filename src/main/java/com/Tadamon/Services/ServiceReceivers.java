package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Tadamon.Dao.IreceiverDao;
import com.Tadamon.Entity.Receivers;

@Service
public class ServiceReceivers implements IserviceReceivers{
	@Autowired
	private IreceiverDao receiverDao;
	@Autowired
	PasswordEncoder passwordencoder; 
	//add receiver
	    public void addModifieReceiver(Receivers r) {
	    	r.setPassword(passwordencoder.encode(r.getPassword()));
	    	receiverDao.save(r);
	    }
	//select all receiver
	    public List<Receivers> selectAllReceiver(){
	    	return receiverDao.findAll();
	    }
	//select by id receiver
	    public Optional<Receivers> selectByIdReceiver(int id){
	    	return receiverDao.findById(id);
	    }
	//delet receiver by id
	    public void deletReceiver(int id) {
	    	receiverDao.deleteById(id);
	    } 
}

