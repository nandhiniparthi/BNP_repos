package com.bank.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.model.PrimaryAccount;
import com.bank.model.SavingsAccount;
import com.bank.model.User;
import com.bank.service.UserService;



@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public  String login() {
		return "login";
	}
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@RequestMapping("/online_banking_app")
	public String ICINBank(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("savingsAccount", savingsAccount);

        return "ICINBank";
    }
}
