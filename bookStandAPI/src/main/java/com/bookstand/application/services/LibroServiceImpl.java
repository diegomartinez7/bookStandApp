package com.bookstand.application.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstand.application.models.LibroModel.Libro;
import com.bookstand.application.models.TipoNovelaModel.TipoNovela;
import com.bookstand.application.repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private TipoNovelaService tipoNovelaService;
    
    public ArrayList<Libro> getLibros(){
        return (ArrayList<Libro>) libroRepository.findAll();
    }

    public Libro findById(Long id){
        return libroRepository.findById(id).orElse(null);
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public Libro deleteLibro(Long id){
        Libro libro = findById(id);
        if(libro != null){
            ArrayList<Long> id_tiposNovela = new ArrayList<Long>();
            Set<TipoNovela> tiposNovela = libro.getTiposNovela();
            for(TipoNovela tipoNovela : tiposNovela){
                id_tiposNovela.add(tipoNovela.getId());
            }
            for(int i = 0; i<id_tiposNovela.size(); i++){
                removeTipoNovela(libro.getId(), id_tiposNovela.get(i));
            }

            libroRepository.deleteById(id);
        }
        return libro;
    }

    public Libro updateLibro(Long id, Libro libro){
        Libro oldLibro = findById(id);
        if(libroRepository.existsById(id)){
            oldLibro.setIsbn(libro.getIsbn());
            oldLibro.setTitulo(libro.getTitulo());
            oldLibro.setEditorial(libro.getEditorial());
            oldLibro.setAutor(libro.getAutor());
            oldLibro.setEmpastado(libro.getEmpastado());
            oldLibro.setCategoria(libro.getCategoria());
            oldLibro.setNo_paginas(libro.getNo_paginas());
            oldLibro.setIdioma(libro.getIdioma());
            oldLibro.setAnio(libro.getAnio());
            oldLibro.setSinopsis(libro.getSinopsis());
            oldLibro.setPrecio(libro.getPrecio());

            libroRepository.save(oldLibro);
        }
        return oldLibro;
    }

    @Override
    public boolean addTipoNovela(Long id_libro, Long id_tipoNovela) {
        boolean exito = false;
        Libro libro = findById(id_libro);
        TipoNovela tipoNovela = tipoNovelaService.findById(id_tipoNovela);
        if(libro != null && tipoNovela != null){
            Set<TipoNovela> tiposNovela = libro.getTiposNovela();
            // CHECAR SI SE NECESITA COMPROBAR QUE NO SE REPITA EL TIPO DE NOVELA
            tiposNovela.add(tipoNovela);
            libro.setTiposNovela(tiposNovela);
            libroRepository.save(libro);
            exito = true;
        }
        return exito;
    }

    @Override
    public boolean removeTipoNovela(Long id_libro, Long id_tipoNovela) {
        boolean exito = false;
        Libro libro = findById(id_libro);
        TipoNovela tipoNovela = tipoNovelaService.findById(id_tipoNovela);
        if(libro != null && tipoNovela != null){
            Set<TipoNovela> tiposNovela = libro.getTiposNovela();
            // CHECAR SI SE NECESITA COMPROBAR QUE ESTABA AÑADIDO EL TIPO DE NOVELA A ELIMINAR
            tiposNovela.remove(tipoNovela);
            libro.setTiposNovela(tiposNovela);
            libroRepository.save(libro);
            exito = true;
        }
        return exito;
    }
}
