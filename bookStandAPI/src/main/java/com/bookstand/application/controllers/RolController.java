package com.bookstand.application.controllers;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstand.application.models.RolModel.Rol;
import com.bookstand.application.models.RolModel.DTOs.RolReqDTO;
import com.bookstand.application.models.RolModel.DTOs.RolResDTO;
import com.bookstand.application.services.RolService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping(value = "/api/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<Rol> getRoles() {
        return rolService.getRoles();
    }

    @GetMapping("/{id}")
    public Rol getRol(@PathVariable Long id) {
        return rolService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public RolResDTO saveRol(@RequestBody RolReqDTO rolRequest) {
        Rol rol = modelMapper.map(rolRequest, Rol.class);
        rol = rolService.saveRol(rol);
        return modelMapper.map(rol, RolResDTO.class);
    }

    @DeleteMapping("/{id}")
    public Rol deleteRol(@PathVariable Long id) {
        return rolService.deleteRol(id);
    }

    @PutMapping("/{id}")
    public RolResDTO updateRol(@PathVariable Long id, @RequestBody RolReqDTO rolRequest){
        Rol rol = modelMapper.map(rolRequest, Rol.class);
        rol = rolService.updateRol(id, rol);
        return modelMapper.map(rol, RolResDTO.class);
    }
}
