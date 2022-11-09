package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.TelefonoDao;
import com.iudigital.dominio.Telefono;

public class TelefonoController {

    private TelefonoDao telefonoDao;
    
    public TelefonoController(){
        telefonoDao = new TelefonoDao();
    }
    
    public void crearTelefono(Telefono telefono) throws SQLException{
        telefonoDao.crearTelefono(telefono);
    }
    public List<Telefono> obtnerTelefonos() throws SQLException {
        return telefonoDao.obtenerTelefonos();
    }
    public Telefono obtenerTelefono(int id) throws SQLException{
        return telefonoDao.obtenerTelefono(id);
    }
    public void actualizarTelefono(int id, Telefono telefono) throws SQLException{
        telefonoDao.actualizarTelefono(id, telefono);
    }
    public void eliminarTelefono(int id) throws SQLException{
        telefonoDao.eliminarTelefono(id);
    }
    
}
