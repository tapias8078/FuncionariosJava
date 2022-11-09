package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.Direccion;
import com.iudigital.util.ConnectionUtil;

public class DireccionDao {
    private static final String GET_DIRECCIONES = "select * from Direccion";
    private static final String CREATE_DIRECCION = "insert into direccion (direccion) values (?)";
    private static final String GET_DIRECCION_BY_ID = "select * from direccion where id_direccion = ?";
    private static final String UPDATE_DIRECCION = "update direccion set direccion= ? where id_direccion= ?";
    private static final String DELETE_DIRECCION = "delete from direccion  where id_direccion=?";
    
    public void crearDireccion(Direccion direccion) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_DIRECCION);        
        preparedStatement.setString(1,direccion.getDireccion());
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
    
    public List<Direccion> obtenerDirecciones() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Direccion> direcciones = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_DIRECCIONES);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Direccion direccion = new Direccion();
                direccion.setIdDireccion(resultSet.getInt("id_direccion"));
                direccion.setDireccion(resultSet.getString("direccion"));
                direcciones.add(direccion);
            
            }
            return direcciones;
            
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
    
    public Direccion obtenerDireccion(int idDireccion) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Direccion direccion = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_DIRECCION_BY_ID);
           preparedStatement.setInt(1, idDireccion);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            direccion = new Direccion();
            direccion.setIdDireccion(resultSet.getInt("id_direccion"));
            direccion.setDireccion(resultSet.getString("direccion"));
           }
           return direccion;
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
    
    public void actualizarDireccion(int idDireccion, Direccion direccion) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_DIRECCION);
            preparedStatement.setString(1, direccion.getDireccion());
            preparedStatement.setInt(2, idDireccion);
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
    
    public void eliminarDireccion(int idDireccion) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_DIRECCION);
           preparedStatement.setInt(1, idDireccion);
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
