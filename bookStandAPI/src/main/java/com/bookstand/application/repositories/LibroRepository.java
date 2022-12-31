package com.bookstand.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstand.application.models.LibroModel.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
