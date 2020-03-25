package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Volunteers;

public interface IserviceVolunteers {
	//add volunteer
    public void addModifieVolunteers(Volunteers v) ;
	//select all volunteers
    public List<Volunteers> selectAllVolunteers();
	//select by id volunteers
    public Optional<Volunteers> selectByIdVolunteers(int id);
	//delet volunteers by id
    public void deletVolunteers(int id) ;
    
}
