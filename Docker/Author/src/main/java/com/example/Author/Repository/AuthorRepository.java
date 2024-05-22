package com.example.Author.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Author.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
}
