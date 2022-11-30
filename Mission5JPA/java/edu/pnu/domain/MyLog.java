package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyLog {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private MyMethod method;
	private String string;
	private boolean success;
	
	public MyLog() {
		// TODO Auto-generated constructor stub
	}

	public MyLog(int id, MyMethod method, String string, boolean success) {
		super();
		this.id = id;
		this.method = method;
		this.string = string;
		this.success = success;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MyMethod getMethod() {
		return method;
	}

	public void setMethod(MyMethod method) {
		this.method = method;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "MyLog [id=" + id + ", method=" + method + ", string=" + string + ", success=" + success + "]";
	}
}
