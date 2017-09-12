package com.info.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="oid")
	private int oid;
	
	@Column(name="pid")
	private int pid;
	
	
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="status")
	private boolean status;
	
	//@Pattern(regexp="[^0-9]*")
	@Column(name="buyerName")
	private String buyerName;
	
	@Column(name="buyerEmail")
	private String buyerEmail;
	
	public Orders() {
	}

	public Orders(int pid, Date date, boolean status, String buyerName, String buyerEmail) {
		super();
		this.pid = pid;
		this.date = date;
		this.status = status;
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	
	
	
}
