package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Orders;

public interface IserviceOrders {
	//add Order
    public void addModifieOrders(Orders d);
	//select all Orders
    public List<Orders> selectAllOrders();
	//select by id Order
    public Optional<Orders> selectByIdOrders(int id);
	//delet Order by id
    public void deletOrders(int id); 
}
