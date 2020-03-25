package com.Tadamon.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tadamon.Entity.Admin;
import com.Tadamon.Services.IserviceAdmin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminControllers {
@Autowired
private IserviceAdmin serviceAdmin;
//select all admin
@GetMapping("/admins")
public List<Admin> selectAllAdmin(){
	return serviceAdmin.selectAllAdmin();
}
//select by id admin
@GetMapping("/admins/{id}")
public Admin selectByIdAdmin(@PathVariable("id") int id) {
	return serviceAdmin.selectByIdAdmin(id).map(admin ->{
		return serviceAdmin.selectByIdAdmin(id).get();
	}).orElseThrow(()-> new Error());
}
//add admin
@PostMapping(value = "/login/admins")
       public void addAdmin(@RequestBody Admin a) {
    	  serviceAdmin.addModifierAdmin(a); 
       }
//modifier admin by id
@PutMapping(value = "/admins/{id}")
public Admin modifierAdmin(@RequestBody Admin a ,@PathVariable("id")  int id) {
//	Admin admin = serviceAdmin.selectByIdAdmin(id).map(admi ->{
//		return serviceAdmin.selectByIdAdmin(id).get();
//	}).orElseThrow(()-> new Error());
//	serviceAdmin.addModifierAdmin(admin);
	a.setId(id);
	serviceAdmin.addModifierAdmin(a);
	return a;
}
//delet admin by id
@DeleteMapping(value = "/admins/{id}")
public void deletAdmin(@PathVariable("id") int id) {
	serviceAdmin.deletAdmin(id);
}
}
