package com.bookstand.application.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bookstand.application.models.EditorialModel.Editorial;

@Component
public interface EditorialService {
    public ArrayList<Editorial> getEditoriales();
    public Editorial findById(Long id);
    public Editorial saveEditorial(Editorial editorial);
    public Editorial deleteEditorial(Long id);
    public Editorial updateEditorial(Long id, Editorial editorial);
}
