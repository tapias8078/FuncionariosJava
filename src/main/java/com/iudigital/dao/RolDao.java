
package com.iudigital.dao;

import com.iudigital.dominio.Rol;
import com.iudigital.util.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RolDao {
    
    private static final String GET_ROLES = "select * from Rol";
    private static final String CREATE_ROL = "insert into rol (nombre_rol) values (?)";
    private static final String GET_ROL_BY_ID = "select * from rol where idRol = ?";
    private static final String UPDATE_ROL = "update rol set nombre_rol= ? where idRol = ?";
    private static final String DELETE_ROL = "delete from rol  where idRol=?";
    
    public void crearRol(Rol rol) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_ROL);        
        preparedStatement.setString(1,rol.getNombreRol());
        preparedStatement.executeUpdate();
        
        
    }finally{
        if(preparedStatement != null){
            preparedStatement.close();
        }
        if(connection != null){
            connection.close();
        }
        }
    
    }    
    
    public List<Rol> obtenerRoles() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Rol> roles = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ROLES);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Rol rol = new Rol();
                rol.setIdRol(resultSet.getInt("idRol"));
                rol.setNombreRol(resultSet.getString("nombre_rol"));
                roles.add(rol);
            
            }
            return roles;
            
        } finally{
        if(connection != null){
            connection.close();
        }
        if(preparedStatement != null){
        preparedStatement.close();
        }
        if(resultSet != null){
            connection.close();
        }        
        }
       
    }
    
    public Rol obtenerRol(int idRol) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Rol rol = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_ROL_BY_ID);
           preparedStatement.setInt(1, idRol);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            rol = new Rol();
            rol.setIdRol(resultSet.getInt("idRol"));
            rol.setNombreRol(resultSet.getString("nombre_rol"));
           }
           return rol;
        }finally{
                     if(preparedStatement != null){
            preparedStatement.close();
        }
        if(connection != null){
            connection.close();
        }
        if(resultSet != null){
            connection.close();
        }       
        }     
        
    }    
    
    public void actualizarRol(int idRol, Rol rol) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_ROL);
            preparedStatement.setString(1, rol.getNombreRol());
            preparedStatement.setInt(2, idRol);
            preparedStatement.executeUpdate();
            
            
        }finally{
        if(connection != null){
            connection.close();
        }
        if(preparedStatement != null){
        preparedStatement.close();
        }
        }
    }
    
    public void eliminarRol(int idRol) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_ROL);
           preparedStatement.setInt(1, idRol);
           preparedStatement.executeUpdate();
        }finally{
            if( connection != null){
                connection.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
        
    }
    
    
}
