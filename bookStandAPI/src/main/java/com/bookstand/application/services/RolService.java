package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bookstand.application.models.RolModel.Rol;

@Component
public interface RolService {
    public ArrayList<Rol> getRoles();
    public Rol findById(Long id);
    public Rol findByNombre(String nombre);
    public Rol saveRol(Rol rol);
    public Rol deleteRol(Long id);
    public Rol updateRol(Long id, Rol rol);
}
