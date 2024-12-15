package dev.vinayak.ProductCatalog.repositories;

import dev.vinayak.ProductCatalog.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository
extends JpaRepository<Price, Long> {
}
