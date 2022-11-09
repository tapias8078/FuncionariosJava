package com.iudigital.dominio;

public class InstitucionEstudios {
    private int idInstitucion;
    private String institucion;
    
    public int getIdInstitucion() {
        return idInstitucion;
    }
    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }
    public String getInstitucion() {
        return institucion;
    }
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    @Override
    public String toString() {
        return institucion;
    }

    
}
