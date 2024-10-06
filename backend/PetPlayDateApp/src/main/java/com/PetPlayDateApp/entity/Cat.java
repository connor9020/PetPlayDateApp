package com.PetPlayDateApp.entity;

import jakarta.persistence.Entity;

@Entity
public class Cat extends Pet {
	
	private String catBreed;
	
	public Cat(Long pid, String name, int age, String type, String color, User owner, String catBreed) {
		super(pid, name, age, type, color, owner);
		this.catBreed = catBreed;
	}                                                                                                                                                         

                                                        
	public String getCatBreed() {
		return catBreed;
	}

	public void setCatBreed(String catBreed) {
		this.catBreed = catBreed;
	}
	
	
	
}