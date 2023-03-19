package com.marcosvinicius.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcosvinicius.workshopmongo.domain.User;
import com.marcosvinicius.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserReource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) //Or @GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
}
