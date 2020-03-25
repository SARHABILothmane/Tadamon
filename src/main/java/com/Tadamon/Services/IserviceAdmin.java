package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Admin;

public interface IserviceAdmin {
	//add admin
	public void addModifierAdmin(Admin a) ;
	//select all admin
    public List<Admin> selectAllAdmin();
  //select by id admin
    public Optional<Admin> selectByIdAdmin(int id);
  //delet admin by id
    public void deletAdmin(int id);
}
