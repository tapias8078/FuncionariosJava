package com.iudigital.dominio;

public class TipoDocumento {
    private int idTipoDoc;
    private String tipoDoc;
    public int getIdTipoDoc() {
        return idTipoDoc;
    }
    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }
    public String getTipoDoc() {
        return tipoDoc;
    }
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Override
    public String toString() {
        return tipoDoc;
    }
}
