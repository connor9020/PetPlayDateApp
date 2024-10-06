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
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private UserRepository userRepository;
	
	
	public Pet createPet(Pet pet) {
        // Log the incoming owner (User) object
        System.out.println("Owner object: " + pet.getOwner());

        // Check if the owner (User) object is null
        if (pet.getOwner() == null) {
            throw new RuntimeException("User is null in request.");
        }

        // Log the incoming User ID
        System.out.println("User ID: " + pet.getOwner().getUid());

        User user = pet.getOwner();

        // Ensure the User has a valid ID before proceeding
        if (user.getUid() != null) {
            // Fetch the User from the database to ensure it's managed (persistent)
            User existingUser = userRepository.findById(user.getUid())
                    .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + user.getUid()));
            pet.setOwner(existingUser);
        } else {
            throw new RuntimeException("User id is null or invalid.");
        }

        // Save the pet and return
        return petRepository.save(pet);
    }

	
	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}
	
	public Optional<Pet> getPetById(Long pid) {
		return petRepository.findById(pid);
	}
	
	public List<Pet> getPetsByUid(Long uid){
		return petRepository.findByOwnerUid(uid);
	}
	
	public Pet updatePet(Long pid, Pet petDetails) {
		Optional<Pet> existingPet = petRepository.findById(pid);
		if (existingPet.isPresent()) {
			Pet pet = existingPet.get();
			pet.setName(petDetails.getName());
			//pet.setBreed(petDetails.getBreed());
			pet.setAge(petDetails.getAge());
			pet.setColor(petDetails.getColor());
			pet.setType(petDetails.getType());
			
			return petRepository.save(pet);
		} else {
			throw new RuntimeException ("Pet not found with pid: "+pid);
		}
	}
	
	public void deletePet(Long pid) {
		petRepository.deleteById(pid);
	}

}