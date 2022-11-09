package com.iudigital.dominio;

public class NivelEstudios {
    private int idNivelEst;
    private String nivelEst;
    public int getIdNivelEst() {
        return idNivelEst;
    }
    public void setIdNivelEst(int idNivelEst) {
        this.idNivelEst = idNivelEst;
    }
    public String getNivelEst() {
        return nivelEst;
    }
    public void setNivelEst(String nivelEst) {
        this.nivelEst = nivelEst;
    }
    @Override
    public String toString() {
        return nivelEst;
    }

    

}
