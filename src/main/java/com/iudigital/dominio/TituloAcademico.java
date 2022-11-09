package com.iudigital.dominio;

public class TituloAcademico {
    private int IdTitulo;
    private String titulo;
    public int getIdTitulo() {
        return IdTitulo;
    }
    public void setIdTitulo(int idTitulo) {
        IdTitulo = idTitulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
