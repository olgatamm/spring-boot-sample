package com.sample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.models.User;
import com.sample.models.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDAO;

	@Transactional
	public void insertUser(User user) {
		userDAO.create(user);
	}

	@Transactional
	public User getUserById(Long userId) {
		return userDAO.getById(userId);
	}

	@Transactional
	public User getUser(String username) {
		return userDAO.getByEmail(username);
	}

	@Transactional
	public List<User> getUsers() {
		return userDAO.getAll();
	}

	@Transactional
	public void deleteUser(Long userId) {
		User user = new User(userId);
		userDAO.delete(user);
	}
}
