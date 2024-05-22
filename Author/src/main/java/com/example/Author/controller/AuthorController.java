package com.example.Author.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Author.entity.Author;
import com.example.Author.service.AuthorServiceImpl;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorServiceImpl authorServiceImpl;
	@GetMapping("/getAll")
	public List<Author> getAllAuthor(){
		return authorServiceImpl.getList();
	}
	@GetMapping("/findById/{id}")
	public Author getAuthorById(@PathVariable int id) {
		return authorServiceImpl.findAuthor(id);
	}
	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
}
