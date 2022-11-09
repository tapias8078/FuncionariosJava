package com.iudigital.controller;


import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.DireccionDao;
import com.iudigital.dominio.Direccion;

public class DireccionController {

    private DireccionDao direccionDao;  
    
     public DireccionController(){
        direccionDao = new DireccionDao();
    }
    
    
    
    public void crearDireccion(Direccion direccion) throws SQLException{
        direccionDao.crearDireccion(direccion);
    }
    public List<Direccion> obtnerDirecciones() throws SQLException {
        return direccionDao.obtenerDirecciones();
    }
    public Direccion obtenerDireccion(int id) throws SQLException{
        return direccionDao.obtenerDireccion(id);
    }
    public void actualizarDireccion(int id, Direccion direccion) throws SQLException{
        direccionDao.actualizarDireccion(id, direccion);
    }
    public void eliminarDireccion(int id) throws SQLException{
        direccionDao.eliminarDireccion(id);
    }

    
}
