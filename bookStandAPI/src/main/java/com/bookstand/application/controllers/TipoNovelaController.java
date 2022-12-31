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

import com.bookstand.application.models.TipoNovelaModel.TipoNovela;
import com.bookstand.application.models.TipoNovelaModel.DTOs.TipoNovelaReqDTO;
import com.bookstand.application.models.TipoNovelaModel.DTOs.TipoNovelaResDTO;
import com.bookstand.application.services.TipoNovelaService;

@RestController
@RequestMapping(value = "/api/tipoNovela")
public class TipoNovelaController {
    @Autowired
    private TipoNovelaService tipoNovelaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<TipoNovela> getTiposNovela() {
        return tipoNovelaService.getTiposNovela();
    }

    @GetMapping("/{id}")
    public TipoNovela getTipoNovela(@PathVariable Long id) {
        return tipoNovelaService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public TipoNovelaResDTO saveTipoNovela(@RequestBody TipoNovelaReqDTO tipoNovelaRequest) {
        TipoNovela tipoNovela = modelMapper.map(tipoNovelaRequest, TipoNovela.class);
        tipoNovela = tipoNovelaService.saveTipoNovela(tipoNovela);
        return modelMapper.map(tipoNovela, TipoNovelaResDTO.class);
    }

    @DeleteMapping("/{id}")
    public TipoNovela deleteTipoNovela(@PathVariable Long id) {
        return tipoNovelaService.deleteTipoNovela(id);
    }

    @PutMapping("/{id}")
    public TipoNovelaResDTO updateTipoNovela(@PathVariable Long id, @RequestBody TipoNovelaReqDTO tipoNovelaRequest){
        TipoNovela tipoNovela = modelMapper.map(tipoNovelaRequest, TipoNovela.class);
        tipoNovela = tipoNovelaService.updateTipoNovela(id, tipoNovela);
        return modelMapper.map(tipoNovela, TipoNovelaResDTO.class);
    }
}
