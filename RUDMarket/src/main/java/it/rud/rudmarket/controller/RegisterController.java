package it.rud.rudmarket.controller;

import it.rud.rudmarket.service.RUDUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    @Qualifier("udsi")
    RUDUserDetailsService rudUserDetailsService;

    @RequestMapping("/viewRegister")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping("/doRegister")
    public String doRegister(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "nome") String nome,
            @RequestParam(name = "cognome") String cognome,
            @RequestParam(name = "password") String password) {
        if (rudUserDetailsService.createUser(email, nome, cognome, null, password)) {
            return "forward:/";
        } else {
          return "forward:/error";
        }
    }
}
