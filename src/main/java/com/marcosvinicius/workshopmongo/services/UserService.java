package com.marcosvinicius.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosvinicius.workshopmongo.domain.User;
import com.marcosvinicius.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newUser = findById(obj.getId());
		updateData(newUser, obj);
		return repository.save(newUser);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
}
