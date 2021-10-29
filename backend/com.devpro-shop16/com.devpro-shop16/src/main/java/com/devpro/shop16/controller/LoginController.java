package com.devpro.shop16.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop16.entities.Role;
import com.devpro.shop16.entities.User;
import com.devpro.shop16.services.UserService;

@Controller
public class LoginController extends BaseController {
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		return "views/Login";// duong toi view
	}
	
	@RequestMapping(value = { "/resgitry" }, method = RequestMethod.GET)
	public String resgitry(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		return "views/Resgitry";// duong toi view
	}
	@RequestMapping(value = { "/resgitry" }, method = RequestMethod.POST)
	public String resgitry_Post(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User();
		Role role = new Role();
		role.setName("user");
		role.setDescription("user");
		
		user.setUsername(username);
		user.setPassword(new BCryptPasswordEncoder(4).encode(password));
		user.setEmail(email);
		user.getRoles().add(role);
		role.getUsers().add(user);
//		role.setId(13);
//		user.addRoles(role);
		userService.saveOrUpdate(user);
		
		
		
		return "views/Login";// duong toi view
	}
}
