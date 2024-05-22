package com.example.Book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Book.entity.Book;
import com.example.Book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findBook(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).orElseThrow();
	}
	
	
}
