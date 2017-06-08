package com.sample.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.ArrayList;
import java.util.List;

@ManagedResource(objectName = "Examples:type=JMX,name=UserMbean")
public class UserMbean {
	List<String> users = new ArrayList<>();

	@ManagedAttribute
	public String getLastUser() {
		return users.get(getSize() - 1);
	}

	@ManagedAttribute
	public int getSize() {
		return users.size();
	}

	@ManagedOperation
	public void addUser(String item) {
		users.add(item);
	}

	@ManagedOperation
	public String getUser(int pos) {
		return users.get(pos);
	}

	@ManagedOperation
	public List<String> getUsers() {
		return users;
	}
}
