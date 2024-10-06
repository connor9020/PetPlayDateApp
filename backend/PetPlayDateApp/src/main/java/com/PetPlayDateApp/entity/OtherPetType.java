
package com.PetPlayDateApp.entity;

import jakarta.persistence.Entity;

@Entity
public class OtherPetType extends Pet {
	
	private String otherPetBreed;
	
	public OtherPetType(Long pid, String name, int age, String type, String color, User owner, String otherpetBreed) {
		super(pid, name, age, type, color, owner);
		this.otherPetBreed = otherpetBreed;
	}


	public String getOtherPetBreed() {
		return otherPetBreed;
	}

	public void setOtherPetBreed(String otherpetBreed) {
		this.otherPetBreed = otherpetBreed;
	}
	
	
	
}