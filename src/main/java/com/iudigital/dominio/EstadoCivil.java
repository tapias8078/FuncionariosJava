package com.iudigital.dominio;

public class EstadoCivil {
    
    private int idEstado;
    private String Estado;
    
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    @Override
    public String toString() {
        return Estado;
    }

    
}
