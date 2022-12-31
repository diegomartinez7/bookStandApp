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
import com.bookstand.application.models.AutorModel.DTOs.AutorReqDTO;
import com.bookstand.application.models.AutorModel.DTOs.AutorResDTO;
import com.bookstand.application.services.AutorService;

@RestController
@RequestMapping(value = "/api/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<Autor> getAutores() {
        return autorService.getAutores();
    }

    @GetMapping("/{id}")
    public Autor getAutor(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public AutorResDTO saveAutor(@RequestBody AutorReqDTO autorRequest) {
        Autor autor = modelMapper.map(autorRequest, Autor.class);
        autor = autorService.saveAutor(autor);
        return modelMapper.map(autor, AutorResDTO.class);
    }

    @DeleteMapping("/{id}")
    public Autor deleteAutor(@PathVariable Long id) {
        return autorService.deleteAutor(id);
    }

    @PutMapping("/{id}")
    public AutorResDTO updateAutor(@PathVariable Long id, @RequestBody AutorReqDTO autorRequest){
        Autor autor = modelMapper.map(autorRequest, Autor.class);
        autor = autorService.updateAutor(id, autor);
        return modelMapper.map(autor, AutorResDTO.class);
    }
}
