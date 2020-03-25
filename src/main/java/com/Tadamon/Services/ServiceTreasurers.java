package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Tadamon.Dao.ItreasuresrsDao;
import com.Tadamon.Entity.Treasurers;


@Service
public class ServiceTreasurers implements IserviceTreasurers{
	@Autowired
	private ItreasuresrsDao treasuresrsDao;
	@Autowired
	PasswordEncoder passwordencoder; 
	//add treasuresr
	    public void addModifieTreasurers(Treasurers t) {
	    	t.setPassword(passwordencoder.encode(t.getPassword()));
	    	treasuresrsDao.save(t);
	    }
	//select all treasuresrs
	    public List<Treasurers> selectAllTreasurers(){
	    	return treasuresrsDao.findAll();
	    }
	//select by id treasuresr
	    public Optional<Treasurers> selectByIdTreasurers(int id){
	    	return treasuresrsDao.findById(id);
	    }
	//delet treasuresr by id
	    public void deletTreasurers(int id) {
	    	treasuresrsDao.deleteById(id);
	    } 
}
