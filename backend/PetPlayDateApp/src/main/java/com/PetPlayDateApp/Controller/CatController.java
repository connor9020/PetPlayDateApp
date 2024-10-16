package com.PetPlayDateApp.Controller;

import com.PetPlayDateApp.entity.Cat;
import com.PetPlayDateApp.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @PostMapping
    public Cat addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @GetMapping("/{id}")
    public Cat getCatById(@PathVariable Long id) {
        return catService.getCatById(id).orElse(null);
    }

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @PutMapping("/{id}")
    public Cat updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        return catService.updateCat(id, cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }
}

