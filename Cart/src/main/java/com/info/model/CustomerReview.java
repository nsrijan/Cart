package com.info.model;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class CustomerReview {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rid")
	private int rid;
	
	@Column(name="pid")
	private int pid;
	
	@Column(name="remail")
	private String remail;
	
	@Column(name="rname")
	private String rname;
	
	@Column(name="rphone")
	private String rphone;
	
	@Column(name="rdescription")
	private String rdescription;
	
	@Column(name="publish")
	private boolean publish;
	
	
	public CustomerReview() { }
	
	public CustomerReview(int pid, String remail, String rname, String rphone, String rdescription, boolean publish) {
		super();
		this.pid = pid;
		this.remail = remail;
		this.rname = rname;
		this.rphone = rphone;
		this.rdescription = rdescription;
		this.publish = publish;
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRdescription() {
		return rdescription;
	}
	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}
	public boolean isPublish() {
		return publish;
	}
	public void setPublish(boolean publish) {
		this.publish = publish;
	}
	
	

}
