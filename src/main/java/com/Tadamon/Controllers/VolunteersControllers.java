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

import com.Tadamon.Entity.Volunteers;
import com.Tadamon.Services.IserviceVolunteers;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VolunteersControllers {
@Autowired
private IserviceVolunteers serviceVolunteers;
//select all Volunteers;
@GetMapping("/volunteers")
public List<Volunteers> selectAllVolunteers(){
	return serviceVolunteers.selectAllVolunteers();
}
//select by id volunteer
@GetMapping("/volunteers/{id}")
public Volunteers selectByIdVolunteers(@PathVariable("id") int id) {
	return serviceVolunteers.selectByIdVolunteers(id).map(volunt ->{
		return serviceVolunteers.selectByIdVolunteers(id).get();
	}).orElseThrow(()-> new Error());
}
//add volunteer
@PostMapping(value = "/login/volunteers")
public void addVolunteer(@RequestBody Volunteers v) {
	serviceVolunteers.addModifieVolunteers(v);
}
//modifier volunteer
@PatchMapping(value = "/volunteers/{id}")
public Volunteers modifierVolunteer(@RequestBody Volunteers v , @PathVariable("id") int id) {
    v.setId(id);
	serviceVolunteers.addModifieVolunteers(v);
	return v;
}
//delet volunteer
@DeleteMapping(value = "/volunteers/{id}")
public void deletVolunteer(@PathVariable("id") int id) {
	serviceVolunteers.deletVolunteers(id);
}
}
