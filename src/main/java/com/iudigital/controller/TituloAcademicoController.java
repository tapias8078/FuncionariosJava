package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.TituloAcademicoDao;
import com.iudigital.dominio.TituloAcademico;

public class TituloAcademicoController {    

    private TituloAcademicoDao tituloAcademicoDao;
    
    public TituloAcademicoController(){
        tituloAcademicoDao = new TituloAcademicoDao();
    }
    
    public void crearTituloAcademico(TituloAcademico tituloAcademico) throws SQLException{
        tituloAcademicoDao.crearTituloAcademico(tituloAcademico);
    }
    public List<TituloAcademico> obtnerTitulosAcademicos() throws SQLException {
        return tituloAcademicoDao.obtenerTitulosAcademicos();
    }
    public TituloAcademico obtenerTituloAcademico(int id) throws SQLException{
        return tituloAcademicoDao.obtenerTituloAcademico(id);
    }
    public void actualizarTituloAcademico(int id, TituloAcademico tituloAcademico) throws SQLException{
        tituloAcademicoDao.actualizarTituloAcademico(id, tituloAcademico);
    }
    public void eliminarTituloAcademico(int id) throws SQLException{
        tituloAcademicoDao.eliminarTituloAcademico(id);
    }
}
