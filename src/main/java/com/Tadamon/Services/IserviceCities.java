package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Cities;
import com.Tadamon.Entity.Receivers;
import com.Tadamon.Entity.Treasurers;
import com.Tadamon.Entity.Volunteers;

public interface IserviceCities {
	//add Citie
    public void addModifieCities(Cities t);
	//select all Cities
    public List<Cities> selectAllCities();
	//select by id Citie
    public Optional<Cities> selectByIdCities(int id);
	//delet Cities by id
    public void deletCities(int id);
	  //select list volunter for cites
    public List<Volunteers> findAllVolunteer(Cities c);
	  //select list treasurers for cites
    public List<Treasurers> findAllTreasurers(Cities c);
	  //select list receivers for cites
    public List<Receivers> findAllReceivers(Cities c) ;
}
