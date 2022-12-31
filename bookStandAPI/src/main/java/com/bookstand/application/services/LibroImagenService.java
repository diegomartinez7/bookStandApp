package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bookstand.application.models.LibroImagenModel.LibroImagen;

@Component
public interface LibroImagenService {
    public ArrayList<LibroImagen> getLibroImagenes();
    public LibroImagen findById(Long id);
    public LibroImagen saveLibroImagen(LibroImagen libroImagen);
    public LibroImagen deleteLibroImagen(Long id);
    public LibroImagen updateLibroImagen(Long id, LibroImagen libroImagen);
}