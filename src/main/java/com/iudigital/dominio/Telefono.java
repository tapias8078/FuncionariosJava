package com.iudigital.dominio;

public class Telefono {
    
    private int idTelefono;
    private String telefono;
    public int getIdTelefono() {
        return idTelefono;
    }
    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return telefono;
    }

    
}
