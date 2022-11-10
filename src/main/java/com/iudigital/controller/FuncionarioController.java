package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.FuncionariosDao;
import com.iudigital.dominio.Funcionarios;

public class FuncionarioController {

    private FuncionariosDao funcionariosDao;
    
    public FuncionarioController(){
        funcionariosDao = new FuncionariosDao();
    }
    
    public void crearFuncionario(Funcionarios funcionario) throws SQLException{
        funcionariosDao.crearFuncionario(funcionario);
    }
    public List<Funcionarios> obtnerFuncionarios() throws SQLException {
        return funcionariosDao.obtenerFuncionarios();
    }
    public Funcionarios obtenerFuncionario(int id) throws SQLException{
        return funcionariosDao.obtenerFuncionario(id);
    }
    public void actualizarFuncionario(int id, Funcionarios funcionario) throws SQLException{
        funcionariosDao.actualizarFuncionario(id, funcionario);
    }
    public void eliminarFuncionario(int id) throws SQLException{
        funcionariosDao.eliminarFuncionario(id);
    }
    
}
