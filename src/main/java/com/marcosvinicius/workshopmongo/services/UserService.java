package com.marcosvinicius.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosvinicius.workshopmongo.domain.User;
import com.marcosvinicius.workshopmongo.repository.UserRepository;
import com.marcosvinicius.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		if(!user.isPresent()) {
			throw new ObjectNotFoundException("");
		}
		return user.get();
	}
}
