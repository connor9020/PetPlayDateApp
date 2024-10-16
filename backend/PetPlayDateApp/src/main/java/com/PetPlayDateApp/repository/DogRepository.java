package com.PetPlayDateApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PetPlayDateApp.entity.Dog;

public interface DogRepository extends JpaRepository<Dog, Long> {
}

