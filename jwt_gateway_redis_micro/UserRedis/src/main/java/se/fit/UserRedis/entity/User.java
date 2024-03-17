package se.fit.UserRedis.entity;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8083368108687600216L;
	private int id;
	private String name;
	private String adrress;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String adrress) {
		super();
		this.id = id;
		this.name = name;
		this.adrress = adrress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	
	
}
