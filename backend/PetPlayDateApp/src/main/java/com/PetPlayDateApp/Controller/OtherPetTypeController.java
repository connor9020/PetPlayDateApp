package com.PetPlayDateApp.Controller;

import com.PetPlayDateApp.entity.OtherPetType;
import com.PetPlayDateApp.service.OtherPetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otherPetTypes")
public class OtherPetTypeController {

    @Autowired
    private OtherPetTypeService otherPetTypeService;

    @PostMapping
    public OtherPetType addOtherPetType(@RequestBody OtherPetType otherPetType) {
        return otherPetTypeService.addOtherPetType(otherPetType);
    }

    @GetMapping("/{id}")
    public OtherPetType getOtherPetTypeById(@PathVariable Long id) {
        return otherPetTypeService.getOtherPetTypeById(id).orElse(null);
    }

    @GetMapping
    public List<OtherPetType> getAllOtherPetTypes() {
        return otherPetTypeService.getAllOtherPetTypes();
    }

    @PutMapping("/{id}")
    public OtherPetType updateOtherPetType(@PathVariable Long id, @RequestBody OtherPetType otherPetType) {
        return otherPetTypeService.updateOtherPetType(id, otherPetType);
    }

    @DeleteMapping("/{id}")
    public void deleteOtherPetType(@PathVariable Long id) {
        otherPetTypeService.deleteOtherPetType(id);
    }
}

