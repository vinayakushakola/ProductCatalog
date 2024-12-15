package dev.vinayak.ProductCatalog.repositories;

import dev.vinayak.ProductCatalog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
extends JpaRepository<Category, Long> {
}
