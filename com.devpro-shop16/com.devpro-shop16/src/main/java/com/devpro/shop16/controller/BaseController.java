package com.devpro.shop16.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.shop16.entities.Role;
import com.devpro.shop16.entities.Categories;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.entities.User;
import com.devpro.shop16.services.CategoryService;
import com.devpro.shop16.services.ProductsService;

@Controller
public abstract class BaseController {
	private List<String> roles() {
		List<String> roles = new ArrayList<String>();
		User logined = getUserLogined();
		
		if(logined == null) return roles;
		for(Role r : logined.getRoles()) {
			roles.add(r.getAuthority());
		}
		
		return roles;
	}
	
	@ModelAttribute("isAdmin")
	public boolean isAdmin() {
		for(String role : roles()) {
			if(role.equalsIgnoreCase("admin")) return true;
		}
		return false;
	}
	
	@ModelAttribute("isMember")
	public boolean isMember() {
		for(String role : roles()) {
			if(role.equalsIgnoreCase("member")) return true;
		}
		return false;
	}
	@ModelAttribute("userLogined")
	public User getUserLogined() {
		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogined != null && userLogined instanceof UserDetails)
			return (User) userLogined;
		
		return null;
	}

	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("categories")
	public List<Categories> categories() {
		return categoryService.findAll();
	}
	
	
	
	


	// lau curen page 
	public int getCurrentPage(HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
		
	}
	public Integer getInteger(HttpServletRequest request, String paramName) {
		try {
			
			return Integer.parseInt(request.getParameter(paramName));
		} catch (Exception e) {
			return null;
		}
	}
	

}
