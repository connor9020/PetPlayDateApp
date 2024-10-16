package com.PetPlayDateApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetPlayDateApp.entity.Dog;
import com.PetPlayDateApp.repository.DogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
	@Autowired
	private DogRepository dogRepository;
	
	public Dog addDog(Dog dog) {
		return dogRepository.save(dog);
	}
	
	public Optional<Dog> getDogById(Long id) {
		return dogRepository.findById(id);
	}
	
	public List<Dog> getAllDogs() {
		return dogRepository.findAll();
	}
	
	public void deleteDog(Long id) {
		dogRepository.deleteById(id);
	}
	
	public Dog updateDog(Long id, Dog dog) {
		Optional<Dog> existingDog = dogRepository.findById(id);
		if (existingDog.isPresent()) {
			Dog updatedDog = existingDog.get();
			updatedDog.setName(dog.getName());
			updatedDog.setAge(dog.getAge());
			updatedDog.setColor(dog.getColor());
			updatedDog.setOwner(dog.getOwner());
			return dogRepository.save(updatedDog);
		}
		return null;
	}
}
