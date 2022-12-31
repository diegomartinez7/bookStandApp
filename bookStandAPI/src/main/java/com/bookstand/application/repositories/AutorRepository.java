package com.bookstand.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstand.application.models.AutorModel.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
