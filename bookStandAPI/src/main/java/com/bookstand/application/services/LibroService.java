package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bookstand.application.models.LibroModel.Libro;

@Component
public interface LibroService {
    public ArrayList<Libro> getLibros();
    public Libro findById(Long id);
    public Libro saveLibro(Libro libro);
    public Libro deleteLibro(Long id);
    public Libro updateLibro(Long id, Libro libro);
    public boolean addTipoNovela(Long id_libro, Long id_tipoNovela);
    public boolean removeTipoNovela(Long id_libro, Long id_tipoNovela);
}
