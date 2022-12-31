package com.bookstand.application.models.RegistroInventarioModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RegistroInventarioPK implements Serializable {
    
    @Column(name = "id_libro")
    private Long id_libro;
    @Column(name = "id_sucursal")
    private Long id_sucursal;
    
    public RegistroInventarioPK() {
    }

    public RegistroInventarioPK(Long id_libro, Long id_sucursal) {
        this.id_libro = id_libro;
        this.id_sucursal = id_sucursal;
    }

    public Long getId_libro() {
        return id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    public Long getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Long id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_libro == null) ? 0 : id_libro.hashCode());
        result = prime * result + ((id_sucursal == null) ? 0 : id_sucursal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegistroInventarioPK other = (RegistroInventarioPK) obj;
        if (id_libro == null) {
            if (other.id_libro != null)
                return false;
        } else if (!id_libro.equals(other.id_libro))
            return false;
        if (id_sucursal == null) {
            if (other.id_sucursal != null)
                return false;
        } else if (!id_sucursal.equals(other.id_sucursal))
            return false;
        return true;
    }
}
