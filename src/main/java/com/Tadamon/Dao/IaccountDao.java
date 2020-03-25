package com.Tadamon.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Tadamon.Entity.Accounts;

public interface IaccountDao extends JpaRepository<Accounts, Integer>{
	public Accounts findByEmail(String email);
}
