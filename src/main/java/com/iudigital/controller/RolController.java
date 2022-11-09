
package com.iudigital.controller;

import com.iudigital.dao.RolDao;
import com.iudigital.dominio.Rol;
import java.sql.SQLException;
import java.util.List;

public class RolController {
    
    private RolDao rolDao;
    
    public RolController(){
        rolDao = new RolDao();
    }
    
    public void crearRol(Rol rol) throws SQLException{
        rolDao.crearRol(rol);
    }
    public List<Rol> obtnerRoles() throws SQLException {
        return rolDao.obtenerRoles();
    }
    public Rol obtenerRol(int id) throws SQLException{
        return rolDao.obtenerRol(id);
    }
    public void actualizarRol(int id, Rol rol) throws SQLException{
        rolDao.actualizarRol(id, rol);
    }
    public void eliminarRol(int id) throws SQLException{
        rolDao.eliminarRol(id);
    }
}
