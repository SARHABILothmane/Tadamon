package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Receivers;

public interface IserviceReceivers {
	//add receiver
    public void addModifieReceiver(Receivers r);
	//select all receiver
    public List<Receivers> selectAllReceiver();
	//select by id receiver
    public Optional<Receivers> selectByIdReceiver(int id);
	//delet receiver by id
    public void deletReceiver(int id);
}
