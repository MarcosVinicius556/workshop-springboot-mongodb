package com.marcosvinicius.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcosvinicius.workshopmongo.domain.User;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //Or @GetMapping
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		UserDTO obj = new UserDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST) //or PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO dto){
		User obj = service.fromDTO(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(obj.getId())
				 .toUri(); //Irá criar o endereço do novo objeto criado
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
