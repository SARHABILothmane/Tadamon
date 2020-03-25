package com.Tadamon.Entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Volunteers extends Accounts{
    private String name;
    private String tel;
    @ManyToOne
	@JoinColumn(name="citie_id", nullable=false)
	private Cities citie;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Cities getCitie() {
		return citie;
	}
	public void setCitie(Cities citie) {
		this.citie = citie;
	}
	public Volunteers() {
		super();
	}
	public Volunteers(String name, String tel, Cities citie) {
		super();
		this.name = name;
		this.tel = tel;
		this.citie = citie;
	}
	@Override
	public String toString() {
		return "Volunteers [name=" + name + ", tel=" + tel + ", citie=" + citie + "]";
	}

    
}
