package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.Telefono;
import com.iudigital.util.ConnectionUtil;

public class TelefonoDao {

    private static final String GET_TELEFONOS = "select * from Telefono";
    private static final String CREATE_TELEFONO = "insert into telefono (telefono) values (?)";
    private static final String GET_TELEFONO_BY_ID = "select * from telefono where id_telefono = ?";
    private static final String UPDATE_TELEFONO = "update telefono set telefono = ? where id_telefono= ?";
    private static final String DELETE_TELEFONO = "delete from telefono  where id_telefono=?";
    
    public void crearTelefono(Telefono telefono) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_TELEFONO);        
        preparedStatement.setString(1,telefono.getTelefono());
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
    
    public List<Telefono> obtenerTelefonos() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Telefono> telefonos = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TELEFONOS);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Telefono telefono = new Telefono();
                telefono.setIdTelefono(resultSet.getInt("id_telefono"));
                telefono.setTelefono(resultSet.getString("telefono"));
                telefonos.add(telefono);
            
            }
            return telefonos;
            
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
    
    public Telefono obtenerTelefono(int idTelefono) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Telefono telefono = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_TELEFONO_BY_ID);
           preparedStatement.setInt(1, idTelefono);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            telefono = new Telefono();
            telefono.setIdTelefono(resultSet.getInt("id_telefono"));
            telefono.setTelefono(resultSet.getString("telefono"));
           }
           return telefono;
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
    
    public void actualizarTelefono(int idTelefono, Telefono telefono) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_TELEFONO);
            preparedStatement.setString(1, telefono.getTelefono());
            preparedStatement.setInt(2, idTelefono);
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
    
    public void eliminarTelefono(int idTelefono) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_TELEFONO);
           preparedStatement.setInt(1, idTelefono);
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
