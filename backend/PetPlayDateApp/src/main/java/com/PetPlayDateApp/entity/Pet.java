
package com.PetPlayDateApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	
	private String name;
	private int age;
	private String type;
	private String color;
	
    @ManyToOne
    @JoinColumn(name = "uid")
    @JsonBackReference
    private User owner;
	
	public Pet() {
	}
	
	public Pet(Long pid, String name, int age, String type, String color, User owner) {
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.type = type;
		this.color = color;
		this.owner = owner;
	}

	public Long getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
	
	
}

