package com.PetPlayDateApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetPlayDateApp.entity.Cat;
import com.PetPlayDateApp.repository.CatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {
	@Autowired
	private CatRepository catRepository;
	
	public Cat addCat(Cat cat) {
		return catRepository.save(cat);
	}
	
	public Optional<Cat> getCatById(Long id) {
		return catRepository.findById(id);
	}
	
	public List<Cat> getAllCats() {
		return catRepository.findAll();
	}
	
	public void deleteCat(Long id) {
		catRepository.deleteById(id);
	}
	
	public Cat updateCat(Long id, Cat cat) {
		Optional<Cat> existingCat = catRepository.findById(id);
		if (existingCat.isPresent()) {
			Cat updatedCat = existingCat.get();
			updatedCat.setName(cat.getName());
			updatedCat.setAge(cat.getAge());
			updatedCat.setColor(cat.getColor());
			updatedCat.setOwner(cat.getOwner());
			return catRepository.save(updatedCat);
		}
		return null;
	}
}
