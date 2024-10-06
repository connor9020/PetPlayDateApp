package com.PetPlayDateApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PetPlayDateApp.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	List<Pet> findByOwnerUid(Long uid);
}
