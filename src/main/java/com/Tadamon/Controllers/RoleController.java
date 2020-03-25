package com.Tadamon.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Tadamon.Entity.Roles;
import com.Tadamon.Services.IserviceRole;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RoleController {
@Autowired
private IserviceRole controllerRole;

@GetMapping("/roles")
public List<Roles> selectTousRole(){
	return controllerRole.selectTousRole();
}

//selection d'un role par ID
@GetMapping(value = "/roles/{id}")
public Roles sel(@PathVariable("id") int id) {
	return controllerRole.selectionRoleId(id).map(role -> {
		return controllerRole.selectionRoleId(id).get();
	}).orElseThrow(()-> new Error());
}
//ajoutation d'un role 
@PostMapping(value="/roles")
public Roles enregistreRole(@RequestBody Roles r) {
	controllerRole.ajouteModifierRole(r);
	return r;
}
//supprission role 
@DeleteMapping( value = "/roles/{id}")
public void suprimeRole(@PathVariable("id") int id) {
	controllerRole.suprimerRole(id);
}
//modifier role 
@PatchMapping("/roles/{id}")
public Roles modifierRole(@RequestBody Roles r , @PathVariable("id") int id) {
	Roles role = controllerRole.selectionRoleId(id).get();
	controllerRole.ajouteModifierRole(role);
	return r;
}
}
