package com.marcosvinicius.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosvinicius.workshopmongo.domain.Post;
import com.marcosvinicius.workshopmongo.repository.PostRepository;
import com.marcosvinicius.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("");
		}
		return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
}
