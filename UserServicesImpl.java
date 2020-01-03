package com.deloitte.signup.userservices;

import java.util.ArrayList;

import com.deloitte.signup.dao.UserDAO;
import com.deloitte.signup.model.UserInfo;

public class UserServicesImpl implements UserServiceInterface {

	@Override
	public void AddUser(String email, String name, String fatherName, String motherName, String address, long contactNo,
			String gender, String password) {
		// TODO Auto-generated method stub
		UserInfo user=new UserInfo();
		user.setEmail(email);
		user.setName(name);
		user.setFatherName(fatherName);
		user.setMotherName(motherName);
		user.setAddress(address);
		user.setContactNo(contactNo);
		user.setGender(gender);
		user.setPassword(password);
		UserDAO.addUser(user);
	}

	@Override
	public ArrayList<UserInfo> allUser() {
		
		return UserDAO.showAllUser();
	}

	@Override
	public boolean loginUser(int userId, String password) {
		
		return UserDAO.loginUserDao(userId,password);
	}

	

}
