package com.devtest.lab02.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.devtest.lab02.model.Client;
import com.devtest.lab02.repository.ClientRepository;
import com.devtest.lab02.status.Status;

@RestController
public class ClientController {
    
	 @Autowired
	    ClientRepository clientRepository;
	 
	    @PostMapping("/client/enregister")
	    public Status registerClient(@Valid @RequestBody Client c) {
	        List<Client> list = clientRepository.findAll();
	        System.out.println("creer client: " + c.toString());
	        for (Client client : list) {
	            System.out.println("sauvegarder client: " + c.toString());
	            if (client.equals(c)) {
	                System.out.println("existe!");
	                return Status.EXSITE;
	            }
	        }
	         clientRepository.save(c);
	         return Status.SUCCESS;
	    }
	    
       @PostMapping("/client/supprimer")
	    public Status deleteClient(@Valid @RequestBody Client c) {
	        List<Client> list = clientRepository.findAll();
	        for (Client client : list) {
	            if (client.getcode_client().equals(c.getcode_client())) {
	            	clientRepository.delete(c);
	                return Status.delete;
	            }
	        }
	         return Status.N_EXISTE_PAS;
	    }
       
       @PostMapping("/client")
       public List<Client> getAllClient() {
           return clientRepository.findAll();
       }
       
      
}