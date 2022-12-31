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

import com.bookstand.application.models.LibroImagenModel.LibroImagen;
import com.bookstand.application.models.LibroImagenModel.DTOs.LibroImagenReqDTO;
import com.bookstand.application.models.LibroImagenModel.DTOs.LibroImagenResDTO;
import com.bookstand.application.models.LibroModel.Libro;
import com.bookstand.application.services.LibroImagenService;
import com.bookstand.application.services.LibroService;

@RestController
@RequestMapping(value = "/api/libroImagen")
public class LibroImagenController {
    @Autowired
    private LibroImagenService libroImagenService;

    @Autowired
    private ModelMapper customModelMapper;

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ArrayList<LibroImagen> getLibroImagenes() {
        return libroImagenService.getLibroImagenes();
    }

    @GetMapping("/{id}")
    public LibroImagen getLibroImagen(@PathVariable Long id) {
        return libroImagenService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public LibroImagenResDTO saveLibroImagen(@RequestBody LibroImagenReqDTO libroImagenRequest) {
        LibroImagenResDTO libroImagenResponse = null;
        Libro libro = libroService.findById(libroImagenRequest.getId_libro());
        if(libro != null){
            LibroImagen libroImagen = customModelMapper.map(libroImagenRequest, LibroImagen.class);
            libroImagen.setLibro(libro);
            libroImagen = libroImagenService.saveLibroImagen(libroImagen);
            
            libroImagenResponse = customModelMapper.map(libroImagen, LibroImagenResDTO.class);
        }
        return libroImagenResponse;
    }

    @DeleteMapping("/{id}")
    public LibroImagen deleteLibroImagen(@PathVariable Long id) {
        return libroImagenService.deleteLibroImagen(id);
    }

    @PutMapping("/{id}")
    public LibroImagenResDTO updateLibroImagen(@PathVariable Long id, @RequestBody LibroImagenReqDTO libroImagenRequest){
        LibroImagenResDTO libroImagenResponse = null;
        Libro libro = libroService.findById(libroImagenRequest.getId_libro());
        if(libro != null){
            LibroImagen libroImagen = customModelMapper.map(libroImagenRequest, LibroImagen.class);
            libroImagen.setLibro(libro);
            libroImagen = libroImagenService.updateLibroImagen(id, libroImagen);

            libroImagenResponse = customModelMapper.map(libroImagen, LibroImagenResDTO.class);
        }
        return libroImagenResponse;
    }
}
