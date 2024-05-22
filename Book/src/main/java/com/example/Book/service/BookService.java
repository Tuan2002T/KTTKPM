package com.example.Book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Book.entity.Book;
@Service
public interface BookService {
	List<Book> getList();
	Book findBook(int id);
}
