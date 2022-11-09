package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.SexoDao;
import com.iudigital.dominio.Sexo;

public class SexoController {
      
    private SexoDao sexoDao;
    
    public SexoController(){
        sexoDao = new SexoDao();
    }
    
    public void crearSexo(Sexo sexo) throws SQLException{
        sexoDao.crearSexo(sexo);
    }
    public List<Sexo> obtnerSexos() throws SQLException {
        return sexoDao.obtenerSexos();
    }
    public Sexo obtenerSexo(int id) throws SQLException{
        return sexoDao.obtenerSexo(id);
    }
    public void actualizarSexo(int id, Sexo sexo) throws SQLException{
        sexoDao.actualizarSexo(id, sexo);
    }
    public void eliminarSexo(int id) throws SQLException{
        sexoDao.eliminarSexo(id);
    }
}
