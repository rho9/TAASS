package it.rud.rudmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping("/user")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView("user");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@GetMapping("/error")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView("error");
		return modelAndView;
	}
}
