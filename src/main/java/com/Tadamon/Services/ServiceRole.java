package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tadamon.Dao.Iroledao;
import com.Tadamon.Entity.Roles;


@Service
public class ServiceRole implements IserviceRole{
@Autowired
private Iroledao roleDao;
public void ajouteModifierRole(Roles r) {
	roleDao.save(r);
}
public List<Roles> selectTousRole(){
return roleDao.findAll();
}
public Optional<Roles> selectionRoleId(int id){
	return roleDao.findById(id);
}
public void suprimerRole(int id) {
	roleDao.deleteById(id);
}
}
