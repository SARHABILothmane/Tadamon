package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Donations;

public interface IserviceDonations {
	//add Donation
    public void addModifieDonations(Donations d);
	//select all Donations
    public List<Donations> selectAllDonations();
	//select by id Donation
    public Optional<Donations> selectByIdDonations(int id);
	//delet Donation by id
    public void deletDonations(int id);
}
