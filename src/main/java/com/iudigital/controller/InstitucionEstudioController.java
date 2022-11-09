package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.InstitucionEstudiosDao;
import com.iudigital.dominio.InstitucionEstudios;

public class InstitucionEstudioController {
    
    private InstitucionEstudiosDao institucionEstudiosDao;
    
    public InstitucionEstudioController(){
        institucionEstudiosDao = new InstitucionEstudiosDao();
    }
    
    public void crearInstitucionEstudios(InstitucionEstudios institucionEstudios) throws SQLException{
        institucionEstudiosDao.crearInstitucion(institucionEstudios);
    }
    public List<InstitucionEstudios> obtnerInstitucionesEstudios() throws SQLException {
        return institucionEstudiosDao.obtenerInstituciones();
    }
    public InstitucionEstudios obtenerInstitucionEstudios(int id) throws SQLException{
        return institucionEstudiosDao.obtenerInstitucion(id);
    }
    public void actualizarInstitucionEstudios(int id, InstitucionEstudios institucionEstudios) throws SQLException{
        institucionEstudiosDao.actualizarInstitucion(id, institucionEstudios);
    }
    public void eliminarInstitucionEstudios(int id) throws SQLException{
        institucionEstudiosDao.eliminarInstitucion(id);
    }

}
