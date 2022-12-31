package com.bookstand.application.models.RolModel;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    // @Enumerated(EnumType.STRING)
    // @Column(name = "nombre", length = 15)
    // private RolesEnum nombre;
    private String nombre;

    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    // public Rol(RolesEnum nombre) {
    //     this.nombre = nombre;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public RolesEnum getNombre() {
    //     return nombre;
    // }

    // public void setNombre(RolesEnum nombre) {
    //     this.nombre = nombre;
    // }
}
