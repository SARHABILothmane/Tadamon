package com.Tadamon.Entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Receivers extends Accounts{
    private String name;
    private String adresse;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public Receivers() {
		super();
	}
	public Receivers(String name, String adresse, String tel, Cities citie) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.tel = tel;
		this.citie = citie;
	}
	@Override
	public String toString() {
		return "Receivers [name=" + name + ", adresse=" + adresse + ", tel=" + tel + ", citie=" + citie + "]";
	}
	
    
    
}
