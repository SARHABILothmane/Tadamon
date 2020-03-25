package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Roles;


public interface IserviceRole {
	public void ajouteModifierRole(Roles r);
	public List<Roles> selectTousRole();
	public Optional<Roles> selectionRoleId(int id);
	public void suprimerRole(int id) ;
}
