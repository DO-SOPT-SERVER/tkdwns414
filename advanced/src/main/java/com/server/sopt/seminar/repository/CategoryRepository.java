package com.server.sopt.seminar.repository;

import com.server.sopt.seminar.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Short> {
}
