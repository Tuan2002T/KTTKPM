package com.example.Book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Book.dto.AuthorDTO;
import com.example.Book.dto.BookDTO;
import com.example.Book.entity.Book;
import com.example.Book.repository.BookRepository;
import com.example.Book.service.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {
	private  RestTemplate res;
	@Autowired
	public BookController(RestTemplate res) {
		super();
		this.res = res;
	}
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@GetMapping("/bookByid/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookServiceImpl.findBook(id);
	}
	
	@GetMapping("/book/{id}")
	public BookDTO getBookWithAuthor(@PathVariable int id) {
        Book b = bookServiceImpl.findBook(id);
        int idd = b.getIdAuthor();
        AuthorDTO author = res.getForObject("http://authorservice:8082/author/findById/{idd}", AuthorDTO.class, idd);
        BookDTO book = new BookDTO();
        book.setId(b.getId());
        book.setName(b.getName());
        book.setAuthor(author);

        return book;
    }
	
	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
}
