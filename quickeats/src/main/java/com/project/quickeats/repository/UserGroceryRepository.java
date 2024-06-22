package com.project.quickeats.repository;

import com.project.quickeats.model.UserGrocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroceryRepository extends JpaRepository<UserGrocery, Long> {
}
