package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstand.application.models.RolModel.Rol;
import com.bookstand.application.repositories.RolRepository;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;
    
    public ArrayList<Rol> getRoles(){
        return (ArrayList<Rol>) rolRepository.findAll();
    }

    public Rol findById(Long id){
        return rolRepository.findById(id).orElse(null);
    }

    public Rol findByNombre(String nombre){
        return rolRepository.findByNombre(nombre)
            .orElseThrow(() -> new RuntimeException("Error: No se encontró el rol"));
    }

    public Rol saveRol(Rol rol){
        return rolRepository.save(rol);
    }

    public Rol deleteRol(Long id){
        Rol rol = findById(id);
        if(rol != null){
            rolRepository.deleteById(id);
        }
        return rol;
    }

    public Rol updateRol(Long id, Rol rol){
        Rol oldRol = findById(id);
        if(rolRepository.existsById(id)){
            oldRol.setNombre(rol.getNombre());
            rolRepository.save(oldRol);
        }
        return oldRol;
    }
}
