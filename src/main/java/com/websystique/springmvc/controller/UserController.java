package com.websystique.springmvc.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	Logger log = Logger.getLogger(UserController.class);

	@RequestMapping(value="/getUser")
	public void getUser() {
		try {
//			User user = userService.findById(1);
//			System.out.println(user);
//			System.out.println(user.getUserProfiles().size());
			// 3,'sso3',123456,'fname3','lname3','email3'
			User newUser = new User();
//			newUser.setId(5);
			newUser.setSsoId("sso8");
			newUser.setPassword("123456");
			newUser.setFirstName("fname8");
			newUser.setLastName("lname8");
			newUser.setEmail("email8");

					UserProfile up1 = new UserProfile();
					up1.setId(1);
					UserProfile up2 = new UserProfile();
					up2.setId(2);
					
					Set<UserProfile> setUserProfiles = new HashSet<UserProfile>();
					setUserProfiles.add(up1);
					setUserProfiles.add(up2);
					
					newUser.setUserProfiles(setUserProfiles);

			userService.saveUser(newUser);
		} catch(Exception e) {
			log.info(e.getMessage(), e);
		}
	}
}
