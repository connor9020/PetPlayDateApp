package com.PetPlayDateApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PetPlayDateApp.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {
  
}
