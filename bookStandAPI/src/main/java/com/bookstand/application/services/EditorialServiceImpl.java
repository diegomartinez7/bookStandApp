package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstand.application.models.EditorialModel.Editorial;
import com.bookstand.application.repositories.EditorialRepository;

@Service
public class EditorialServiceImpl implements EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;
    
    public ArrayList<Editorial> getEditoriales(){
        return (ArrayList<Editorial>) editorialRepository.findAll();
    }

    public Editorial findById(Long id){
        return editorialRepository.findById(id).orElse(null);
    }

    public Editorial saveEditorial(Editorial editorial){
        return editorialRepository.save(editorial);
    }

    public Editorial deleteEditorial(Long id){
        Editorial editorial = findById(id);
        if(editorial != null){
            editorialRepository.deleteById(id);
        }
        return editorial;
    }

    public Editorial updateEditorial(Long id, Editorial editorial){
        Editorial oldEditorial = findById(id);
        if(editorialRepository.existsById(id)){
            oldEditorial.setNombre(editorial.getNombre());
            oldEditorial.setPais(editorial.getPais());
            oldEditorial.setSitio(editorial.getSitio());
            oldEditorial.setImagen(editorial.getImagen());

            editorialRepository.save(oldEditorial);
        }
        return oldEditorial;
    }
}
