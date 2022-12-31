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

import com.bookstand.application.models.EditorialModel.Editorial;
import com.bookstand.application.models.EditorialModel.DTOs.EditorialReqDTO;
import com.bookstand.application.models.EditorialModel.DTOs.EditorialResDTO;
import com.bookstand.application.services.EditorialService;

@RestController
@RequestMapping(value = "/api/editorial")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<Editorial> getEditoriales() {
        return editorialService.getEditoriales();
    }

    @GetMapping("/{id}")
    public Editorial getEditorial(@PathVariable Long id) {
        return editorialService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public EditorialResDTO saveEditorial(@RequestBody EditorialReqDTO editorialRequest) {
        Editorial editorial = modelMapper.map(editorialRequest, Editorial.class);
        editorial = editorialService.saveEditorial(editorial);
        return modelMapper.map(editorial, EditorialResDTO.class);
    }

    @DeleteMapping("/{id}")
    public Editorial deleteEditorial(@PathVariable Long id) {
        return editorialService.deleteEditorial(id);
    }

    @PutMapping("/{id}")
    public EditorialResDTO updateEditorial(@PathVariable Long id, @RequestBody EditorialReqDTO editorialRequest){
        Editorial editorial = modelMapper.map(editorialRequest, Editorial.class);
        editorial = editorialService.updateEditorial(id, editorial);
        return modelMapper.map(editorial, EditorialResDTO.class);
    }
}
