package com.info.model;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid")
	private int cid;
	
	@Column(name="cname")
	private String cname;
	
	@Column(name="cdescription")
	private String cdescription;
	
	@Column(name="cimage")
	private String cimage;
	
	@Column(name="publish")
	private boolean publish;

	public Category() {

	}

	public Category(int cid, String cname, String cdescription, String cimage, boolean publish) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdescription = cdescription;
		this.cimage = cimage;
		this.publish = publish;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public String getCimage() {
		return cimage;
	}
	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	public boolean isPublish() {
		return publish;
	}
	public void setPublish(boolean publish) {
		this.publish = publish;
	}




}