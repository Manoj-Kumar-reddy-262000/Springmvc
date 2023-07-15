package org.jsp.usermvcapp.controller;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserDao dao;

	@PostMapping(value = "/register")
	public ModelAndView saveUser(@ModelAttribute User u, ModelAndView view) {
		u = dao.saveUser(u);
		view.addObject("msg", "user saved with Id:" + u.getId());
		view.setViewName("print.jsp");
		return view;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int id, ModelAndView view) {
		User u = dao.findUserById(id);
		if (u != null) {
			view.addObject("u", u);
			view.setViewName("update.jsp");
			return view;
		} else {
			view.addObject("msg", "The id is invalid");
			view.setViewName("print.jsp");
			return view;
		}
	}

	@RequestMapping(value = "/update")
	public ModelAndView updateUser(@ModelAttribute User u, ModelAndView view) {
		dao.updateUser(u);
		view.addObject("msg", "user updated");
		view.setViewName("print.jsp");
		return view;
	}

	@RequestMapping("/verify-phone")
	public ModelAndView verifyUser(@RequestParam long phone, @RequestParam String password, ModelAndView view) {
		User u = dao.verifyUser(phone, password);
		if (u != null) {
			view.addObject("u", u);
			view.setViewName("view.jsp");
			return view;
		} else {
			view.addObject("msg", "Invalid Phone Number or Password");
			view.setViewName("print.jsp");
			return view;
		}
	}

	@RequestMapping("/verify-email")
	public ModelAndView verifyUser(@RequestParam String email, @RequestParam String password, ModelAndView view) {
		User u = dao.verifyUser(email, password);
		if (u != null) {
			view.addObject("u", u);
			view.setViewName("view.jsp");
			return view;
		} else {
			view.addObject("msg", "Invalid Email Id or Password");
			view.setViewName("print.jsp");
			return view;
		}
	}

	@RequestMapping("/verify-id")
	public ModelAndView verifyUser(@RequestParam int id, @RequestParam String password, ModelAndView view) {
		User u = dao.verifyUser(id, password);
		if (u != null) {
			view.addObject("u", u);
			view.setViewName("view.jsp");
			return view;
		} else {
			view.addObject("msg", "Invalid Email Id or Password");
			view.setViewName("print.jsp");
			return view;
		}
	}

	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id, ModelAndView view) {
		boolean deleted = dao.deleteUser(id);
		view.setViewName("print.jsp");
		if (deleted) {
			view.addObject("msg", "user deleted");
			return view;
		} else {
			view.addObject("msg", "Cannot deete User as the id is invalid");
			return view;
		}
	}
}
