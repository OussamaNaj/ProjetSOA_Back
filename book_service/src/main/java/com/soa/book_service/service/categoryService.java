package com.soa.book_service.service;

import javax.transaction.Transactional;

import com.soa.book_service.model.Category;
import com.soa.book_service.repository.categoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class categoryService {
    private final categoryRepository categoryRepository;

    @Autowired
    public categoryService(categoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) throws Exception {
        if (categoryRepository.findById(category.getId()).isPresent())
            throw new Exception("category already exists");
        return categoryRepository.save(category);
    }

    public void deleCategory(Long id) throws Exception {
        if (!categoryRepository.findById(id).isPresent())
            throw new Exception("category doesn't exist");
        categoryRepository.deleteById(id);
    }
}
