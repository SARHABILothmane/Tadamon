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

import com.Tadamon.Entity.Treasurers;
import com.Tadamon.Services.IserviceTreasurers;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TreasurersController {
@Autowired
private IserviceTreasurers serviceTreasurers;
//select all treasurers
@GetMapping("/treasurers")
public List<Treasurers> selectAllTreasurers(){
	return serviceTreasurers.selectAllTreasurers();
}
//select by id treasurers
@GetMapping("/treasurers/{id}")
public Treasurers selectByIdTreasurers(@PathVariable("id") int id) {
	return serviceTreasurers.selectByIdTreasurers(id).map(treasurer ->{
		return serviceTreasurers.selectByIdTreasurers(id).get();
	}).orElseThrow(()-> new Error());
}
//add treasurer
@PostMapping(value = "/login/treasurers")
public void addTreasurers(@RequestBody Treasurers t) {
	serviceTreasurers.addModifieTreasurers(t);
}
//modifier treasurer
@PatchMapping(value = "/treasurers/{id}")
public Treasurers modifierTreasurers(@RequestBody Treasurers t,@PathVariable("id") int id) {
     t.setId(id);
	serviceTreasurers.addModifieTreasurers(t);
	return t;
}
//delet treasurer
@DeleteMapping(value = "/treasurers/{id}")
public void deletTreasurer(@PathVariable("id") int id) {
	serviceTreasurers.deletTreasurers(id);
}
}
