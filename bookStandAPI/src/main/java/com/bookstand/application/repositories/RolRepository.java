package com.bookstand.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstand.application.models.RolModel.Rol;
// import com.bookstand.application.models.RolModel.RolesEnum;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    // Optional<Rol> findByNombre(RolesEnum nombre);
    Optional<Rol> findByNombre(String nombre);
}
