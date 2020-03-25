package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tadamon.Dao.IordersDao;
import com.Tadamon.Entity.Orders;

@Service
public class ServiceOrders implements IserviceOrders{
	@Autowired
	private IordersDao ordersDao;
	//add Order
	    public void addModifieOrders(Orders d) {
	    	ordersDao.save(d);
	    }
	//select all Orders
	    public List<Orders> selectAllOrders(){
	    	return ordersDao.findAll();
	    }
	//select by id Order
	    public Optional<Orders> selectByIdOrders(int id){
	    	return ordersDao.findById(id);
	    }
	//delet Order by id
	    public void deletOrders(int id) {
	    	ordersDao.deleteById(id);
	    } 
}
