package com.deloitte.signup.userservices;

import java.util.ArrayList;
import com.deloitte.signup.model.UserInfo;

public interface UserServiceInterface {
	
	public void AddUser(String email,String name,String fatherName,String motherName,String address,long contactNo,String gender,String password);
	
	public ArrayList<UserInfo> allUser();
	public boolean loginUser(int userId,String password);

}
