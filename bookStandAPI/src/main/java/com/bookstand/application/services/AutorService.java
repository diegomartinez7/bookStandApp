package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bookstand.application.models.AutorModel.Autor;

@Component
public interface AutorService {
    public ArrayList<Autor> getAutores();
    public Autor findById(Long id);
    public Autor saveAutor(Autor autor);
    public Autor deleteAutor(Long id);
    public Autor updateAutor(Long id, Autor autor);
}