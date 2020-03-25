package com.Tadamon.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tadamon.Entity.Receivers;
import com.Tadamon.Services.IserviceReceivers;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReceiversControllers {
@Autowired
private IserviceReceivers serviceReceivers;
//select all receivers
@GetMapping("/receivers")
public List<Receivers> selectAllReceivers(){
	return serviceReceivers.selectAllReceiver();
}
//select by id receivers
@GetMapping("/receivers/{id}")
public Receivers selectByIdReceivers(@PathVariable("id") int id) {
	return serviceReceivers.selectByIdReceiver(id).map(receiver ->{
		return serviceReceivers.selectByIdReceiver(id).get();
	}).orElseThrow(()-> new Error());
}
//add receivers
@PostMapping(value = "/login/receivers")
public void addReceiver(@RequestBody Receivers r) {
	serviceReceivers.addModifieReceiver(r);
}
//modifier receivers
@PatchMapping(value = "/receivers/{id}")
public Receivers modifierReceiver(@RequestBody Receivers r , @PathVariable("id") int id) {
     r.setId(id);
	serviceReceivers.addModifieReceiver(r);
	return r;
}
//delet receivers
@DeleteMapping(value = "/receivers/{id}")
public void deletReceivers(@PathVariable("id") int id) {
	serviceReceivers.deletReceiver(id);
}
}
