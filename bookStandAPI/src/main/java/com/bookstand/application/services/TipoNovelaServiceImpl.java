package com.bookstand.application.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstand.application.models.LibroModel.Libro;
import com.bookstand.application.models.TipoNovelaModel.TipoNovela;
import com.bookstand.application.repositories.TipoNovelaRepository;

@Service
public class TipoNovelaServiceImpl implements TipoNovelaService {
    @Autowired
    private TipoNovelaRepository tipoNovelaRepository;
    
    public ArrayList<TipoNovela> getTiposNovela(){
        return (ArrayList<TipoNovela>) tipoNovelaRepository.findAll();
    }

    public TipoNovela findById(Long id){
        return tipoNovelaRepository.findById(id).orElse(null);
    }

    public TipoNovela saveTipoNovela(TipoNovela tipoNovela){
        return tipoNovelaRepository.save(tipoNovela);
    }

    public TipoNovela deleteTipoNovela(Long id){
        TipoNovela tipoNovela = findById(id);
        if(tipoNovela != null){
            Set<Libro> libros = tipoNovela.getLibros();
            for(Libro libro : libros){
                libro.removeTipoNovela(tipoNovela);
            }
            
            tipoNovelaRepository.deleteById(id);
        }
        return tipoNovela;
    }

    public TipoNovela updateTipoNovela(Long id, TipoNovela tipoNovela){
        TipoNovela oldTipoNovela = findById(id);
        if(tipoNovelaRepository.existsById(id)){
            oldTipoNovela.setNombre(tipoNovela.getNombre());

            tipoNovelaRepository.save(oldTipoNovela);
        }
        return oldTipoNovela;
    }
}