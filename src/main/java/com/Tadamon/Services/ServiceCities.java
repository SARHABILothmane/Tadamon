package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tadamon.Dao.IcitiesDao;
import com.Tadamon.Entity.Cities;
import com.Tadamon.Entity.Receivers;
import com.Tadamon.Entity.Treasurers;
import com.Tadamon.Entity.Volunteers;

@Service
public class ServiceCities implements IserviceCities{
	@Autowired
	private IcitiesDao citiesDao;
	//add Citie
	    public void addModifieCities(Cities t) {
	    	citiesDao.save(t);
	    }
	//select all Cities
	    public List<Cities> selectAllCities(){
	    	return citiesDao.findAll();
	    }
	//select by id Citie
	    public Optional<Cities> selectByIdCities(int id){
	    	return citiesDao.findById(id);
	    }
	//delet Cities by id
	    public void deletCities(int id) {
	    	citiesDao.deleteById(id);
	    } 
		  //select list volunter for cites
	    public List<Volunteers> findAllVolunteer(Cities c) {
			return c.getVolunteer();
		}
		  //select list treasurers for cites
	    public List<Treasurers> findAllTreasurers(Cities c) {
			return c.getTreasurer();
		}
	    
		  //select list receivers for cites
	    public List<Receivers> findAllReceivers(Cities c) {
			return c.getReceivers();
		}
}
