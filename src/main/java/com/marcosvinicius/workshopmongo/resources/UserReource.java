package com.marcosvinicius.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcosvinicius.workshopmongo.dto.UserDTO;
import com.marcosvinicius.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserReource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) //Or @GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> listDto = service.findAll().stream()
												 .map(x -> new UserDTO(x))
												 .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
