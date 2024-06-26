package se.fit.UserRedis.reponsitory;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import se.fit.UserRedis.entity.User;

@Repository
public class UserReponsitory {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;
	public UserReponsitory(RedisTemplate redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}
	
	public void save(User user) {
		hashOperations.put("User", user.getId(), user);
	}
	public List<User> findAll() {
		return hashOperations.values("USER");
	}

	public User findById(int id) {
		return (User) hashOperations.get("USER", id);
	}

	public void update(User user) {
		save(user);
	}

	public void delete(int id) {
		hashOperations.delete("USER", id);
	}
}
