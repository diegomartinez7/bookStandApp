package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstand.application.models.LibroImagenModel.LibroImagen;
import com.bookstand.application.repositories.LibroImagenRepository;

@Service
public class LibroImagenServiceImpl implements LibroImagenService {
    @Autowired
    private LibroImagenRepository libroImagenRepository;
    
    public ArrayList<LibroImagen> getLibroImagenes(){
        return (ArrayList<LibroImagen>) libroImagenRepository.findAll();
    }

    public LibroImagen findById(Long id){
        return libroImagenRepository.findById(id).orElse(null);
    }

    public LibroImagen saveLibroImagen(LibroImagen libroImagen){
        return libroImagenRepository.save(libroImagen);
    }

    public LibroImagen deleteLibroImagen(Long id){
        LibroImagen libroImagen = findById(id);
        if(libroImagen != null){
            libroImagenRepository.deleteById(id);
        }
        return libroImagen;
    }

    public LibroImagen updateLibroImagen(Long id, LibroImagen libroImagen){
        LibroImagen oldLibroImagen = findById(id);
        if(libroImagenRepository.existsById(id)){
            oldLibroImagen.setLibro(libroImagen.getLibro());
            oldLibroImagen.setImagen(libroImagen.getImagen());
            oldLibroImagen.setNombre(libroImagen.getNombre());
            oldLibroImagen.setExtension(libroImagen.getExtension());

            libroImagenRepository.save(oldLibroImagen);
        }
        return oldLibroImagen;
    }
}
