package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;
import com.iudigital.dao.EstadoCivilDao;
import com.iudigital.dominio.EstadoCivil;

public class EstadoCivilController {

    private EstadoCivilDao estadoCivilDao;  

    public EstadoCivilController(){
        estadoCivilDao = new EstadoCivilDao();
    }
    
    public void crearEstadoCivil(EstadoCivil estadoCivil) throws SQLException{
        estadoCivilDao.crearEstadoCivil(estadoCivil);
    }
    public List<EstadoCivil> obtnerEstadosCiviles() throws SQLException {
        return estadoCivilDao.obtenerEstadosCiviles();
    }
    public EstadoCivil obtenerEstadoCivil(int id) throws SQLException{
        return estadoCivilDao.obtenerEstadoCivil(id);
    }
    public void actualizarEstadoCivil(int id, EstadoCivil estadoCivil) throws SQLException{
        estadoCivilDao.actualizarEstadoCivil(id, estadoCivil);
    }
    public void eliminarEstadoCivil(int id) throws SQLException{
        estadoCivilDao.eliminarEstadoCivil(id);
    }
    
}
