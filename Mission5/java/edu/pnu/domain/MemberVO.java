package edu.pnu.domain;

import java.util.Date;

public class MemberVO {
	private Integer id;
	private String name;
	private String pass;
	private Date regidate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", pass=" + pass + ", regidate=" + regidate + "]";
	}
	
}
