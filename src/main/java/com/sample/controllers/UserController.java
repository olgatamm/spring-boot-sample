package com.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.models.User;
import com.sample.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, String email) {
		User user = null;
		try {
			user = new User(name, email);
			userService.insertUser(user);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + user.getId() + ")";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			userService.deleteUser(id);
		} catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/get-by-name")
	@ResponseBody
	public String getByname(String name) {
		String userId;
		try {
			User user = userService.getUser(name);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String name, String email) {
		try {
			User user = userService.getUserById(id);
			user.setName(name);
			user.setEmail(email);
			userService.insertUser(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}
	
	@RequestMapping("/index")
	public String userIndex(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "user/index";
	}

	@Autowired
	private UserService userService;

}
