package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.GrupoFamiliarDao;
import com.iudigital.dominio.GrupoFamiliar;

public class GrupoFamiliarController {

    private GrupoFamiliarDao grupoFamiliarDao;
    
    public GrupoFamiliarController(){
        grupoFamiliarDao = new GrupoFamiliarDao();
    }
    
    public void crearGrupoFamiliar(GrupoFamiliar grupoFamiliar) throws SQLException{
        grupoFamiliarDao.crearGrupoFamiliar(grupoFamiliar);
    }
    public List<GrupoFamiliar> obtnerGruposFamiliares() throws SQLException {
        return grupoFamiliarDao.obtenerGruposFamiliares();
    }
    public GrupoFamiliar obtenerGrupoFamiliar(int id) throws SQLException{
        return grupoFamiliarDao.obtenerGrupoFamiliar(id);
    }
    public void actualizarGrupoFamiliar(int id, GrupoFamiliar grupoFamiliar) throws SQLException{
        grupoFamiliarDao.actualizarGrupoFamiliar(id, grupoFamiliar);
    }
    public void eliminarGrupoFamiliar(int id) throws SQLException{
        grupoFamiliarDao.eliminarGrupoFamiliar(id);
    }
    
}
