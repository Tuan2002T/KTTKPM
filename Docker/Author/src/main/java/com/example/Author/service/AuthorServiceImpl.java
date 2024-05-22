package com.example.Author.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Author.Repository.AuthorRepository;
import com.example.Author.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> getList(){
		return authorRepository.findAll();
	}

	@Override
	public Author findAuthor(int id) {
	    return authorRepository.findById(id)
	                           .orElseThrow();
	}
}
