package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.NivelEstudiosDao;
import com.iudigital.dominio.NivelEstudios;

public class NivelEstudiosController {

    private NivelEstudiosDao nivelEstudiosDao;
    
    public NivelEstudiosController(){
        nivelEstudiosDao = new NivelEstudiosDao();
    }
    
    public void crearNivelEstudio(NivelEstudios nivelEstudios) throws SQLException{
        nivelEstudiosDao.crearNivelEstudios(nivelEstudios);
    }
    public List<NivelEstudios> obtnerNivelEstudios() throws SQLException {
        return nivelEstudiosDao.obtenerNivelesEstudios();
    }
    public NivelEstudios obtenerNivelEstudio(int id) throws SQLException{
        return nivelEstudiosDao.obtenerNivelEstudio(id);
    }
    public void actualizarNivelEstudio(int id, NivelEstudios nivelEstudios) throws SQLException{
        nivelEstudiosDao.actualizarNivelEstudios(id, nivelEstudios);
    }
    public void eliminarNivelEstudio(int id) throws SQLException{
        nivelEstudiosDao.eliminarNivelEstudios(id);
    }
    
}
