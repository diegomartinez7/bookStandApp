package com.bookstand.application.models.RegistroInventarioModel;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bookstand.application.models.LibroModel.Libro;
import com.bookstand.application.models.SucursalModel.Sucursal;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "registro_inventario")
public class RegistroInventario {
    
    @EmbeddedId
    RegistroInventarioPK id;

    @ManyToOne
    @MapsId("id_libro")
    @JoinColumn(name = "id_libro")
    @JsonBackReference
    private Libro libro;

    @ManyToOne
    @MapsId("id_sucursal")
    @JoinColumn(name = "id_sucursal")
    @JsonBackReference
    private Sucursal sucursal;

    private Integer cantidad;
    private Date fecha_reposicion;
    
    public RegistroInventario() {
    }

    public RegistroInventario(RegistroInventarioPK id, Libro libro, Sucursal sucursal, Integer cantidad, Date fecha_reposicion) {
        this.id = id;
        this.libro = libro;
        this.sucursal = sucursal;
        this.cantidad = cantidad;
        this.fecha_reposicion = fecha_reposicion;
    }

    public RegistroInventarioPK getId() {
        return id;
    }

    public void setId(RegistroInventarioPK id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_reposicion() {
        return fecha_reposicion;
    }

    public void setFecha_reposicion(Date fecha_reposicion) {
        this.fecha_reposicion = fecha_reposicion;
    }
}
