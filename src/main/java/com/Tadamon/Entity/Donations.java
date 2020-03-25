package com.Tadamon.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Donations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@ManyToOne
	@JoinColumn(name="citie_id", nullable=false)
	private Cities citie;
	private String donor;
	private String amount;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date CreatedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cities getCitie() {
		return citie;
	}

	public void setCitie(Cities citie) {
		this.citie = citie;
	}

	public String getDonor() {
		return donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Donations() {
		super();
	}

	public Donations(int id, Cities citie, String donor, String amount, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.citie = citie;
		this.donor = donor;
		this.amount = amount;
		CreatedAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Donations [id=" + id + ", citie=" + citie + ", donor=" + donor + ", amount=" + amount + ", CreatedAt="
				+ CreatedAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
