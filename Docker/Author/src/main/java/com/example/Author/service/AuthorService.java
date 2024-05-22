package com.example.Author.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Author.Repository.AuthorRepository;
import com.example.Author.entity.Author;

@ Service
public interface AuthorService {
	List<Author> getList();
	Author findAuthor(int id);

}
