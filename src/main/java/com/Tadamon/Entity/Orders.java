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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@ManyToOne
	@JoinColumn(name="admin_id", nullable=false)
	private Admin admin;
	@ManyToOne
	@JoinColumn(name="receiver_id", nullable=false)
	private Receivers receiver;
	@ManyToOne
	@JoinColumn(name="treasurer_id", nullable=false)
	private Treasurers treasurer;
	@ManyToOne
	@JoinColumn(name="volunteer_id", nullable=false)
	private Volunteers volunteer;
	@ManyToOne
	@JoinColumn(name="citie_id", nullable=false)
	private Cities citie;
	
	private String content;
	private String adress;
	private String tel;
	private String message;
	private String status;
	private Boolean noMoney;
	
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Receivers getReceiver() {
		return receiver;
	}

	public void setReceiver(Receivers receiver) {
		this.receiver = receiver;
	}

	public Treasurers getTreasurer() {
		return treasurer;
	}

	public void setTreasurer(Treasurers treasurer) {
		this.treasurer = treasurer;
	}

	public Volunteers getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteers volunteer) {
		this.volunteer = volunteer;
	}

	public Cities getCitie() {
		return citie;
	}

	public void setCitie(Cities citie) {
		this.citie = citie;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getNoMoney() {
		return noMoney;
	}

	public void setNoMoney(Boolean noMoney) {
		this.noMoney = noMoney;
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

	public Orders() {
		super();
	}

	public Orders(int id, Admin admin, Receivers receiver, Treasurers treasurer, Volunteers volunteer, Cities citie,
			String content, String adress, String tel, String message, String status, Boolean noMoney, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.admin = admin;
		this.receiver = receiver;
		this.treasurer = treasurer;
		this.volunteer = volunteer;
		this.citie = citie;
		this.content = content;
		this.adress = adress;
		this.tel = tel;
		this.message = message;
		this.status = status;
		this.noMoney = noMoney;
		CreatedAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", admin=" + admin + ", receiver=" + receiver + ", treasurer=" + treasurer
				+ ", volunteer=" + volunteer + ", citie=" + citie + ", content=" + content + ", adress=" + adress
				+ ", tel=" + tel + ", message=" + message + ", status=" + status + ", noMoney=" + noMoney
				+ ", CreatedAt=" + CreatedAt + ", updatedAt=" + updatedAt + "]";
	}	
}
