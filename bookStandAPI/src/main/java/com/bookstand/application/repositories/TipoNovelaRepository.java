package com.bookstand.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstand.application.models.TipoNovelaModel.TipoNovela;

@Repository
public interface TipoNovelaRepository extends JpaRepository<TipoNovela, Long> {
}
