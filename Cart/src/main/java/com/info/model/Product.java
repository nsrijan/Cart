package com.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private int pid;
	
	@Column(name="cid")
	private int cid;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="pdescription")
	private String pdescription;
	
	@Column(name="pprice")
	private float pprice;
	
	@Column(name="pofferprice")
	private float pofferprice;
	
	@Column(name="pimages")
	private String pimages;
	
	@Column(name="publish")
	private boolean publish;
	
	public Product() {
		
	}
	
	public Product(int pid, int cid, String pname, String pdescription, float pprice, float pofferprice,
			String pimages, boolean publish) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.pdescription = pdescription;
		this.pprice = pprice;
		this.pofferprice = pofferprice;
		this.pimages = pimages;
		this.publish = publish;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public float getPofferprice() {
		return pofferprice;
	}
	public void setPofferprice(float pofferprice) {
		this.pofferprice = pofferprice;
	}
	public String getPimages() {
		return pimages;
	}
	public void setPimages(String pimages) {
		this.pimages = pimages;
	}
	public boolean isPublish() {
		return publish;
	}
	public void setPublish(boolean publish) {
		this.publish = publish;
	}
	
	
	
}