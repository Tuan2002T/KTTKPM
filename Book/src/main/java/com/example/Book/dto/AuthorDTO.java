package com.example.Book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthorDTO {
	 private int id;
	 private String name;
	 private int age;
	 
	 public AuthorDTO(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public AuthorDTO() {
		// TODO Auto-generated constructor stub
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	 
	 
}
