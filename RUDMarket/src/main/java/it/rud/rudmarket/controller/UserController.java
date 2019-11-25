package it.rud.rudmarket.controller;

import it.rud.rudmarket.service.RUDUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    @Qualifier("udsi")
    RUDUserDetailsService rudUserDetailsService;

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @PostMapping("/doRegister")
    public ModelAndView doRegister(@RequestParam(name="username") String username, @RequestParam(name="password") String password) {
        ModelAndView modelAndView = new ModelAndView("index");

        rudUserDetailsService.createUser(username, password);

        return modelAndView;
    }
}
