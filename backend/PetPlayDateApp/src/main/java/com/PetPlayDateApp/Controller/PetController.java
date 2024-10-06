package com.PetPlayDateApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PetPlayDateApp.entity.Pet;
import com.PetPlayDateApp.entity.User;
import com.PetPlayDateApp.repository.UserRepository;
import com.PetPlayDateApp.service.PetService;


@RestController
@RequestMapping("/pets")
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping
	public List<Pet> getAllPets() {
		return petService.getAllPets();
	}
	
	@GetMapping("/{pid}")
	public Optional<Pet> getPetById(@PathVariable Long pid){
		return petService.getPetById(pid);			
	}
	
	// still need to fix
	@GetMapping("/byowner/{uid}")
	public List<Pet> getPetsByUid(@PathVariable Long uid){
		return petService.getPetsByUid(uid);
	}
	
	@PostMapping
	public Pet createPet(@RequestBody Pet pet) {
	    return petService.createPet(pet);
	}
	
	@PutMapping("/{pid}")
	public Pet updatePet(@PathVariable Long pid, @RequestBody Pet petDetails) {
		return petService.updatePet(pid, petDetails);	
	}
	
	@DeleteMapping("/{pid}")
	public void deletePet(@PathVariable Long pid) {
		petService.deletePet(pid);
	}
	
	
}
