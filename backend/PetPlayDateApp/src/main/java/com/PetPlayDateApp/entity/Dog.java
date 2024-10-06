package com.PetPlayDateApp.entity;

import jakarta.persistence.Entity;

@Entity
public class Dog extends Pet {
	
	private String dogBreed;
	
	public Dog(Long pid, String name, int age, String type, String color, User owner, String dogBreed) {
		super(pid, name, age, type, color, owner);
		this.dogBreed = dogBreed;
	}


	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}
	
	
	
}