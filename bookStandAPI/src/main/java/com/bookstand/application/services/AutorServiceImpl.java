package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstand.application.models.AutorModel.Autor;
import com.bookstand.application.repositories.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorRepository autorRepository;
    
    public ArrayList<Autor> getAutores(){
        return (ArrayList<Autor>) autorRepository.findAll();
    }

    public Autor findById(Long id){
        return autorRepository.findById(id).orElse(null);
    }

    public Autor saveAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor deleteAutor(Long id){
        Autor autor = findById(id);
        if(autor != null){
            autorRepository.deleteById(id);
        }
        return autor;
    }

    public Autor updateAutor(Long id, Autor autor){
        Autor oldAutor = findById(id);
        if(autorRepository.existsById(id)){
            oldAutor.setNombre(autor.getNombre());
            oldAutor.setSeudonimo(autor.getSeudonimo());
            oldAutor.setPais(autor.getPais());
            oldAutor.setAnio_nacimiento(autor.getAnio_nacimiento());
            oldAutor.setDescripcion(autor.getDescripcion());

            autorRepository.save(oldAutor);
        }
        return oldAutor;
    }
}
