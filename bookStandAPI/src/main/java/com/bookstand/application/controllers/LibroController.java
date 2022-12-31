package com.bookstand.application.controllers;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstand.application.models.AutorModel.Autor;
import com.bookstand.application.models.EditorialModel.Editorial;
import com.bookstand.application.models.LibroModel.Libro;
import com.bookstand.application.models.LibroModel.DTOs.LibroReqDTO;
import com.bookstand.application.models.LibroModel.DTOs.LibroResDTO;
import com.bookstand.application.services.AutorService;
import com.bookstand.application.services.EditorialService;
import com.bookstand.application.services.LibroService;


@RestController
@RequestMapping(value = "/api/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @Autowired
    private ModelMapper customModelMapper;

    @Autowired
    private AutorService autorService;
    
    @Autowired
    private EditorialService editorialService;

    @GetMapping
    public ArrayList<Libro> getLibros() {
        return libroService.getLibros();
    }

    @GetMapping("/{id}")
    public Libro getLibro(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public LibroResDTO saveLibro(@RequestBody LibroReqDTO libroRequest) {
        LibroResDTO libroResponse = null;
        Autor autor = autorService.findById(libroRequest.getId_autor());
        Editorial editorial = editorialService.findById(libroRequest.getId_editorial());
        if(autor != null && editorial != null){
            Libro libro = customModelMapper.map(libroRequest, Libro.class);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro = libroService.saveLibro(libro);
            
            libroResponse = customModelMapper.map(libro, LibroResDTO.class);
        }
        return libroResponse;
    }

    @DeleteMapping("/{id}")
    public Libro deleteLibro(@PathVariable Long id) {
        return libroService.deleteLibro(id);
    }

    @PutMapping("/{id}")
    public LibroResDTO updateLibro(@PathVariable Long id, @RequestBody LibroReqDTO libroRequest){
        LibroResDTO libroResponse = null;
        Autor autor = autorService.findById(libroRequest.getId_autor());
        Editorial editorial = editorialService.findById(libroRequest.getId_editorial());
        if(autor != null && editorial != null){
            Libro libro = customModelMapper.map(libroRequest, Libro.class);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro = libroService.updateLibro(id, libro);

            libroResponse = customModelMapper.map(libro, LibroResDTO.class);
        }
        return libroResponse;
    }

    @PutMapping("/{id}/addTipoNovela/{id_tipoNovela}")
    @ResponseBody
    public boolean addTipoNovela(@PathVariable Long id, @PathVariable Long id_tipoNovela) {
        return libroService.addTipoNovela(id, id_tipoNovela);
    }

    @PutMapping("/{id}/removeTipoNovela/{id_tipoNovela}")
    @ResponseBody
    public boolean removeTipoNovela(@PathVariable Long id, @PathVariable Long id_tipoNovela) {
        return libroService.removeTipoNovela(id, id_tipoNovela);
    }
}
