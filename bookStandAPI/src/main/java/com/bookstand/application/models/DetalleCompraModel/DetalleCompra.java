package com.bookstand.application.models.DetalleCompraModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bookstand.application.models.CompraModel.Compra;
import com.bookstand.application.models.LibroModel.Libro;
import com.bookstand.application.models.SucursalModel.Sucursal;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_compra", nullable = false)
    @JsonBackReference
    private Compra compra;  //private Long id_compra;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_libro", nullable = false)
    @JsonBackReference
    private Libro libro;  //private Long id_libro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sucursal", nullable = false)
    @JsonBackReference
    private Sucursal sucursal;  //private Long id_sucursal;

    private Integer cantidad;
    private double total;

    public DetalleCompra() {
    }

    public DetalleCompra(Compra compra, Libro libro, Sucursal sucursal, Integer cantidad, double total) {
        this.compra = compra;
        this.libro = libro;
        this.sucursal = sucursal;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
