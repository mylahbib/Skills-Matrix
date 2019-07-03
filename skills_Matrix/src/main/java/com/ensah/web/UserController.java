package com.ensah.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ensah.entity.User;
import com.ensah.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService ;
	@RequestMapping(value="/admin/users")
	public String listUser(Model model , @RequestParam(name="mc", defaultValue="")String mc ) {
	 List<User> listUsers = 	userService.chercherUsers("%"+mc+"%");
									
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@RequestMapping(value="/admin/delete",method=RequestMethod.GET)
	public String delete(Long id) {
		userService.deleteUser(id);   
		return "redirect:/admin/users";
	}
	
	
	@RequestMapping(value="/admin/form",method=RequestMethod.GET)
	public String  FormUser(Model model) {
		model.addAttribute("user", new User());
	return "FormUser";
	}
	@RequestMapping(value="/admin/save",method=RequestMethod.POST)
	public String  save(Model model , @Valid User user,BindingResult bindingResult ) {
		if(bindingResult.hasErrors())
			return "FormUser";
		userService.addUser(user);
		return "confirmation";
	}
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String  home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		if (currentPrincipalName.equals("admin")) {
			return "redirect:/admin/users";

		}
		return "redirect:/index";

	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String  login() {
		
		
	return "login";
	}
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String  accessDenied() {
	return "403";
	}
	@RequestMapping(value="/404",method=RequestMethod.GET)
	public String  notFound(HttpServletRequest httpRequest) {
		
	return "404";
	}
}
