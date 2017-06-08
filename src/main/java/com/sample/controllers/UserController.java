package com.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.jmx.UserMbean;
import com.sample.models.User;
import com.sample.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//see "/metrics" endpoint for new counters
	@Autowired
	private CounterService counterService;
	
	// mbean. see jconsole
	@Autowired
	UserMbean userMbean;

	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, String email) {
		User user = null;
		try {
			user = new User(name, email);
			userService.insertUser(user);
			counterService.increment("user.create.success");
			userMbean.addUser(name);
		} catch (Exception ex) {
			counterService.increment("user.create.fail");
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + user.getId() + ")";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			userService.deleteUser(id);
			counterService.increment("user.delete.success");
		} catch (Exception ex) {
			counterService.increment("user.delete.fail");
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
			counterService.increment("user.update.success");
		} catch (Exception ex) {
			counterService.increment("user.update.fail");
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
