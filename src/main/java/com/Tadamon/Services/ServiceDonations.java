package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tadamon.Dao.IdonationsDao;
import com.Tadamon.Entity.Donations;
@Service
public class ServiceDonations implements IserviceDonations{
	@Autowired
	private IdonationsDao donationsDao;
	//add Donation
	    public void addModifieDonations(Donations d) {
	    	donationsDao.save(d);
	    }
	//select all Donations
	    public List<Donations> selectAllDonations(){
	    	return donationsDao.findAll();
	    }
	//select by id Donation
	    public Optional<Donations> selectByIdDonations(int id){
	    	return donationsDao.findById(id);
	    }
	//delet Donation by id
	    public void deletDonations(int id) {
	    	donationsDao.deleteById(id);
	    } 
}
