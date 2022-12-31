package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bookstand.application.models.TipoNovelaModel.TipoNovela;

@Component
public interface TipoNovelaService {
    public ArrayList<TipoNovela> getTiposNovela();
    public TipoNovela findById(Long id);
    public TipoNovela saveTipoNovela(TipoNovela tipoNovela);
    public TipoNovela deleteTipoNovela(Long id);
    public TipoNovela updateTipoNovela(Long id, TipoNovela tipoNovela);
}