package com.PetPlayDateApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetPlayDateApp.entity.OtherPetType;
import com.PetPlayDateApp.repository.OtherPetTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OtherPetTypeService {
	@Autowired
	private OtherPetTypeRepository otherPetTypeRepository;
	
	public OtherPetType addOtherPetType(OtherPetType otherPetType) {
		return otherPetTypeRepository.save(otherPetType);
	}
	
	public Optional<OtherPetType> getOtherPetTypeById(Long id) {
		return otherPetTypeRepository.findById(id);
	}
	
	public List<OtherPetType> getAllOtherPetTypes() {
		return otherPetTypeRepository.findAll();
	}
	
	public void deleteOtherPetType(Long id) {
		otherPetTypeRepository.deleteById(id);
	}
	
	public OtherPetType updateOtherPetType(Long id, OtherPetType otherPetType) {
		Optional<OtherPetType> existingOtherPetType = otherPetTypeRepository.findById(id);
		if (existingOtherPetType.isPresent()) {
			OtherPetType updatedOtherPetType = existingOtherPetType.get();
			updatedOtherPetType.setName(otherPetType.getName());
			updatedOtherPetType.setAge(otherPetType.getAge());
			updatedOtherPetType.setColor(otherPetType.getColor());
			updatedOtherPetType.setOwner(otherPetType.getOwner());
			return otherPetTypeRepository.save(updatedOtherPetType);
		}
		return null;
	}
}

