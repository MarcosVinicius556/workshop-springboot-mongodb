package com.marcosvinicius.workshopmongo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcosvinicius.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserReource {

	
	@RequestMapping(method=RequestMethod.GET) //Or @GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(null);
	}
	
}
