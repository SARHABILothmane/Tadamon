package com.Tadamon.Services;

import java.util.List;
import java.util.Optional;

import com.Tadamon.Entity.Treasurers;

public interface IserviceTreasurers {
	//add treasuresr
    public void addModifieTreasurers(Treasurers t);
	//select all treasuresrs
    public List<Treasurers> selectAllTreasurers();
	//select by id treasuresr
    public Optional<Treasurers> selectByIdTreasurers(int id);
	//delet treasuresr by id
    public void deletTreasurers(int id);
}
