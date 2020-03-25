package com.Tadamon.Controllers;

import java.util.List;
import java.util.Optional;

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

import com.Tadamon.Entity.Cities;
import com.Tadamon.Entity.Receivers;
import com.Tadamon.Entity.Treasurers;
import com.Tadamon.Entity.Volunteers;
import com.Tadamon.Services.IserviceCities;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CitiesControllers {
@Autowired
private IserviceCities serviceCities;
//select all cities
@GetMapping("/cities")
public List<Cities> selectAllCities(){
	return serviceCities.selectAllCities();
}
//select by id cities
@GetMapping("/cities/{id}")
public Cities selectByIdCities(@PathVariable("id") int id) {
	Optional<Cities> citieId = serviceCities.selectByIdCities(id);
	if (!citieId.isPresent()) {
		return null;
	}
	return citieId.get();
}
//add citie
@PostMapping(value = "/cities")
public void addCities(@RequestBody Cities c) {
	serviceCities.addModifieCities(c);
}
//modifier cities
@PutMapping("/cities/{id}")
public Cities modifierCities(@RequestBody Cities c , @PathVariable("id") int id) {
c.setId(id);
serviceCities.addModifieCities(c);
	return c;
}
//delet citie
@DeleteMapping(value = "/cities/{id}")
public void deletCitie(@PathVariable("id") int id) {
	serviceCities.deletCities(id);
}

//select list volunter for cites
@GetMapping("/cities/volunteers/{city_id}")
public List<Volunteers> findAllVolunteer(@PathVariable("city_id") int id){
	return serviceCities.findAllVolunteer(serviceCities.selectByIdCities(id).get());
}

//select list Treasurers for cites
@GetMapping("/cities/treasurers/{city_id}")
public List<Treasurers> findAllTreasurers(@PathVariable("city_id") int id){
	return serviceCities.findAllTreasurers(serviceCities.selectByIdCities(id).get());
}

//select list Receivers for cites
@GetMapping("/cities/receivers/{city_id}")
public List<Receivers> findAllReceivers(@PathVariable("city_id") int id){
	return serviceCities.findAllReceivers(serviceCities.selectByIdCities(id).get());
}
}
