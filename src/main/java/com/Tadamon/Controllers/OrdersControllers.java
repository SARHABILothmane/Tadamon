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

import com.Tadamon.Entity.Orders;
import com.Tadamon.Services.IserviceOrders;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrdersControllers {
@Autowired
private IserviceOrders serviceOrders;
//select all Orders
@GetMapping("/orders")
public List<Orders> selectAllOrders(){
	return serviceOrders.selectAllOrders();
}
//select by id order
@GetMapping("/orders/{id}")
public Orders selectByIdOrder(@PathVariable("id") int id) {
	return serviceOrders.selectByIdOrders(id).map(order ->{
		return serviceOrders.selectByIdOrders(id).get();
	}).orElseThrow(()-> new Error());
}
//add order
@PostMapping("/orders")
public void addOrders(@RequestBody Orders o) {
	serviceOrders.addModifieOrders(o);
}
//modifier order
@PutMapping("/orders/{id}")
public Orders modifieOrder(@RequestBody Orders o ,@PathVariable("id")int id) {
     o.setId(id);
	serviceOrders.addModifieOrders(o);
	return o;
}
//delet order
	@DeleteMapping(value = "/orders/{id}")
	public void deletOrders(@PathVariable("id") int id) {
		serviceOrders.deletOrders(id);
	}

}
