package se.fit.UserRedis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.fit.UserRedis.entity.User;
import se.fit.UserRedis.reponsitory.UserReponsitory;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserReponsitory reponsitory;
	
	@GetMapping("/list")
	public List<User> getAll(){
		return reponsitory.findAll();
	}

	@PostMapping("/create")
	public User save(@RequestBody User user) {
		reponsitory.save(user);
		return user;
	}
}
