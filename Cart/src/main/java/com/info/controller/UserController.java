package com.info.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.info.DAO.UserDao;
import com.info.model.User;
import com.info.service.UserService;

@Controller
@RequestMapping(value={"/user", "/user/"})
@SessionAttributes("username")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute(new User());
		return "signup";
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView signupsubmit(@Valid @ModelAttribute("user") User user, Model model, BindingResult rs) {

		if ( rs != null) {
			System.out.println("this is from signup post");
			userService.add(user);
			model.addAttribute("username", user.getUsername());
			return new ModelAndView("redirect:/");
		}
		
		else return new ModelAndView("user/signup");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "login";
	}

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, Model model) {
		System.out.println("your username is ===>>>>>" + user.getUsername());
		String username = (userService.getUserByName(user.getUsername(), user.getPassword()).getFirstName());
		System.out.println("Username is =====>>>> " + username);
		
		if ( username != null ) {
			model.addAttribute("username", username);
			System.out.println("login success");
			return "redirect:/";
		}
		
		else {
			model.addAttribute("errormsg", "Invalid Login");
			System.out.println("login failure");
			return "login";
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, SessionStatus status) {
		HttpSession session = request.getSession();
		session.invalidate();
		status.setComplete();
		
		return "redirect:/";
	}


}
