package com.devtest.lab02.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.devtest.lab02.model.Login;
import com.devtest.lab02.repository.LoginRepository;
import com.devtest.lab02.status.Status;

import java.util.List;

@RestController
public class LoginController {
	 @Autowired
	    LoginRepository loginRepository;
	    @PostMapping("/login")
	    
	    public Status registerUser(@Valid @RequestBody Login l) {
	        List<Login> list = loginRepository.findAll();
	        for (Login login : list) {
	            if (login.equals(l)) {
	                System.out.println("existe!");
	                return Status.EXSITE;
	            }
	            else {
	            	System.out.println("n'existe pas!");
	                return Status.N_EXISTE_PAS;
	            }
	        }
	         //loginRepository.save(newLogin);
	         return Status.SUCCESS;
	    }
}








    
  