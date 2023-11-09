package com.server.sopt.seminar.service;

import com.server.sopt.seminar.dto.response.category.CategoryResponse;
import com.server.sopt.seminar.entity.Category;
import com.server.sopt.seminar.entity.CategoryId;
import com.server.sopt.seminar.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getByCategoryId(CategoryId categoryId) {
        return categoryRepository.findById(Short.valueOf(categoryId.getCategoryId())).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
    }

    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다.")));
    }
}