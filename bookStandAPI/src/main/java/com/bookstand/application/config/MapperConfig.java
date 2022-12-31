package com.bookstand.application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstand.application.models.LibroImagenModel.LibroImagen;
import com.bookstand.application.models.LibroImagenModel.DTOs.LibroImagenReqDTO;
import com.bookstand.application.models.LibroImagenModel.DTOs.LibroImagenResDTO;
import com.bookstand.application.models.LibroModel.Libro;
import com.bookstand.application.models.LibroModel.DTOs.LibroReqDTO;
import com.bookstand.application.models.LibroModel.DTOs.LibroResDTO;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapper customModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setAmbiguityIgnored(true)
            .setImplicitMappingEnabled(false);

        //Mapping para Libro

        modelMapper.typeMap(LibroReqDTO.class, Libro.class)
            .addMappings(mapper -> {
                mapper.skip(Libro::setAutor);
                mapper.skip(Libro::setEditorial);
            }
            ).implicitMappings();

        modelMapper.typeMap(Libro.class, LibroResDTO.class)
            .addMappings(mapper -> {
                mapper.map(src -> src.getAutor().getId(), LibroResDTO::setId_autor);
                mapper.map(src -> src.getEditorial().getId(), LibroResDTO::setId_editorial);
            })
            .implicitMappings();

        //Mapping para LibroImagen

        modelMapper.typeMap(LibroImagenReqDTO.class, LibroImagen.class)
            .addMappings(mapper -> {
                mapper.skip(LibroImagen::setLibro);
            })
            .implicitMappings();

        modelMapper.typeMap(LibroImagen.class, LibroImagenResDTO.class)
            .addMappings(mapper -> {
                mapper.map(src -> src.getLibro().getId(), LibroImagenResDTO::setId_libro);
            })
            .implicitMappings();

        return modelMapper;
    }
}