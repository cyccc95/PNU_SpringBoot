package edu.pnu.domain;

import java.util.Date;

public class LogVO {
	private Integer id;
	private String method;
	private String sqlstring;
	private Date regidate;
	private boolean success;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSqlstring() {
		return sqlstring;
	}
	public void setSqlstring(String sqlstring) {
		this.sqlstring = sqlstring;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
