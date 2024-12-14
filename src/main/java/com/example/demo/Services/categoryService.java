package com.example.demo.Services;

import com.example.demo.Entity.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.categoryRepository;

@Service
public class categoryService {
    
    @Autowired
    private categoryRepository catRepo;

    public categoryService(categoryRepository catRepo){
        this.catRepo=catRepo;
    }

    public void saveCategory(Category theCat){
        catRepo.save(theCat);
    }

    public List<Category> getAllCategory() {
        return catRepo.findAll();
    }

}
