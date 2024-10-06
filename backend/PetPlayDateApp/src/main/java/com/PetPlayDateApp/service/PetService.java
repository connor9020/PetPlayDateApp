package com.PetPlayDateApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetPlayDateApp.entity.Pet;
import com.PetPlayDateApp.entity.User;
import com.PetPlayDateApp.repository.PetRepository;
import com.PetPlayDateApp.repository.UserRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	//@Autowired
	//private UserRepository userRepository;
	
	
	public Pet createPet(Pet pet) {
			return petRepository.save(pet);
	
	}
	
	
	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}
	
	public Optional<Pet> getPetById(Long pid) {
		return petRepository.findById(pid);
	}
	
	public Pet updatePet(Long pid, Pet petDetails) {
		Optional<Pet> existingPet = petRepository.findById(pid);
		if (existingPet.isPresent()) {
			Pet pet = existingPet.get();
			pet.setName(petDetails.getName());
			//pet.setBreed(petDetails.getBreed());
			pet.setAge(petDetails.getAge());
			
			return petRepository.save(pet);
		} else {
			throw new RuntimeException ("Pet not found with pid: "+pid);
		}
	}
	
	public void deletePet(Long pid) {
		petRepository.deleteById(pid);
	}

}