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

import com.Tadamon.Entity.Donations;
import com.Tadamon.Services.IserviceDonations;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DonationControllers {
	@Autowired
	private IserviceDonations serviceDonations;
//select all donation
	@GetMapping("/donations")
	public List<Donations> selectAllDonations(){
		return serviceDonations.selectAllDonations();
	}
//select by id donation
	@GetMapping("/donations/{id}")
	public Donations selectByIdDonation(@PathVariable("id") int id) {
		return serviceDonations.selectByIdDonations(id).map(don ->{
			return serviceDonations.selectByIdDonations(id).get();
		}).orElseThrow(()-> new Error());
	}
//add donation
	@PostMapping(value = "/donations")
	public void addDonation(@RequestBody Donations d) {
		serviceDonations.addModifieDonations(d);
	}
//modifier donation
	@PutMapping(value = "/donations/{id}")
	public Donations modifierDonation(@RequestBody Donations d,@PathVariable("id") int id) {
        d.setId(id);
		serviceDonations.addModifieDonations(d);
		return d;
	}
//delet donation 
	@DeleteMapping(value = "/donations/{id}")
	public void deletDonation(@PathVariable("id") int id) {
		serviceDonations.deletDonations(id);
	}
}
