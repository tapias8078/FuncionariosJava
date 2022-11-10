package com.iudigital.dominio;

public class Funcionarios {
    
    private String idFunc;
    private String idnivelEst;
    private String idInstEst;
    private String idTituloAcad;    
    private String idPersona;
    private String cedulaPersona;
    private String nombresPersona;
    private String apellidosPersona;

    

    public String getNombresPersona() {
        return nombresPersona;
    }
    public void setNombresPersona(String nombresPersona) {
        this.nombresPersona = nombresPersona;
    }
    public String getApellidosPersona() {
        return apellidosPersona;
    }
    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }
    public String getIdFunc() {
        return idFunc;
    }
    public void setIdFunc(String idFunc) {
        this.idFunc = idFunc;
    }
    public String getIdnivelEst() {
        return idnivelEst;
    }
    public void setIdnivelEst(String idnivelEst) {
        this.idnivelEst = idnivelEst;
    }
    public String getIdInstEst() {
        return idInstEst;
    }
    public void setIdInstEst(String idInstEst) {
        this.idInstEst = idInstEst;
    }
    public String getIdTituloAcad() {
        return idTituloAcad;
    }
    public void setIdTituloAcad(String idTituloAcad) {
        this.idTituloAcad = idTituloAcad;
    }
    public String getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }
    public String getCedulaPersona() {
        return cedulaPersona;
    }
    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }
    @Override
    public String toString() {
        return cedulaPersona + " " + nombresPersona
                + " " + apellidosPersona;
    }

    

    

   

 
   


    
    
    
}
