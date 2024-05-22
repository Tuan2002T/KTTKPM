package com.example.Book.dto;

import lombok.Data;

@Data
public class BookDTO {
	private int id;
    private String name;
    private AuthorDTO author;
    
    public BookDTO(int id, String name, AuthorDTO author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public BookDTO() {
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

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
    
    
}
