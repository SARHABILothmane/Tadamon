package com.Tadamon.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String label;
    
//    @OneToMany(mappedBy="citie",cascade = CascadeType.ALL,orphanRemoval = true)
    @OneToMany(mappedBy="citie")
    @JsonIgnore
    private List<Volunteers> volunteer;

    @OneToMany(mappedBy="citie")
    @JsonIgnore
    private List<Treasurers> treasurer;
    
    @OneToMany(mappedBy="citie")
    @JsonIgnore
    private List<Receivers> receivers;

    @OneToMany(mappedBy="citie")
    @JsonIgnore
    private List<Donations> donation;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Volunteers> getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(List<Volunteers> volunteer) {
		this.volunteer = volunteer;
	}

	public List<Treasurers> getTreasurer() {
		return treasurer;
	}

	public void setTreasurer(List<Treasurers> treasurer) {
		this.treasurer = treasurer;
	}

	public List<Receivers> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<Receivers> receivers) {
		this.receivers = receivers;
	}

	
	public List<Donations> getDonation() {
		return donation;
	}

	public void setDonation(List<Donations> donation) {
		this.donation = donation;
	}

	public Cities() {
		super();
	}

	public Cities(int id, String label, List<Volunteers> volunteer, List<Treasurers> treasurer,
			List<Receivers> receivers, List<Donations> donation) {
		super();
		this.id = id;
		this.label = label;
		this.volunteer = volunteer;
		this.treasurer = treasurer;
		this.receivers = receivers;
		this.donation = donation;
	}

	@Override
	public String toString() {
		return "Cities [id=" + id + ", label=" + label + ", volunteer=" + volunteer + ", treasurer=" + treasurer
				+ ", receivers=" + receivers + ", donation=" + donation + "]";
	}
 
}
