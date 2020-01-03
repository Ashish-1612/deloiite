package com.deloitte.signup.main;

import java.util.*;

import com.deloitte.signup.model.UserInfo;
import com.deloitte.signup.userservices.UserServicesImpl;

public class UserDemoClass {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int userId;
		String email;
		String name;
		String fatherName;
		String motherName;
		String address;
		long contactNo;
		String gender;
		String password;
		String confirmPassword;
		UserServicesImpl serviceCall=new UserServicesImpl();
		ArrayList<UserInfo> userList=null;
		while (true) {
			System.out.println("select option : " + "\n1. to add a new user" + "\n2. to show all user"
					+ "\n3. to login as a user" + "\n4. to exit");
			String option = sc.next();
			switch (option) {
			case "1":
				System.out.println("enter email address");
				email=sc.next();
				System.out.println("enter user name");
				name=sc.next();
				System.out.println("enter father name");
				fatherName=sc.next();
				System.out.println("enter mother name");
				motherName=sc.next();
				System.out.println("enter address");
				address=sc.next();
				System.out.println("enter contact number");
				contactNo=Long.parseLong(sc.next());
				System.out.println("enter gender");
				gender=sc.next();
				while(true) {
				System.out.println("enter password");
				password=sc.next();
				System.out.println("enter password");
				confirmPassword=sc.next();
				if(password.equals(confirmPassword)) {
					serviceCall.AddUser(email,name,fatherName,motherName,address,contactNo,gender,password);
					break;
				}
				else {
					System.out.println("password and confirm password should match");
				}
				}
				break;
			case "2":
				userList=serviceCall.allUser();
				if(userList.size()<1) {
					System.out.println("no data found in database");
				}
				else {
				for(UserInfo user:userList) {
					System.out.println(user);
				}
				}
				break;
			case "3":
				System.out.println("enter user Id");
				userId=Integer.parseInt(sc.next());
				System.out.println("enter password");
				password=sc.next();
				boolean loginUser=serviceCall.loginUser(userId, password);
				if(!loginUser) {
					System.out.println("user not found check userID and password");
				}
				else {
					System.out.println("login successful");
				}
				break;
			case "4":
				sc.close();
				System.exit(0);
				break;
			}
		}

	}

}
