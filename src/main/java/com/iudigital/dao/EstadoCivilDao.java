package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.EstadoCivil;
import com.iudigital.util.ConnectionUtil;

public class EstadoCivilDao {

    private static final String GET_ESTCIVILES = "select * from EstadoCivil";
    private static final String CREATE_ESTCIVIL = "insert into EstadoCivil (estado_civil) values (?)";
    private static final String GET_ESTCIVIL_BY_ID = "select * from EstadoCivil where id_est_civil = ?";
    private static final String UPDATE_ESTCIVIL = "update estadoCivil set Estado_civil= ? where id_est_civil= ?";
    private static final String DELETE_ESTCIVIL = "delete from EstadoCivil  where id_est_civil=?";
    
    public void crearEstadoCivil(EstadoCivil estadoCivil) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_ESTCIVIL);        
        preparedStatement.setString(1,estadoCivil.getEstado());
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
    
    public List<EstadoCivil> obtenerEstadosCiviles() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EstadoCivil> estadosCiviles = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ESTCIVILES);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                EstadoCivil estadoCivil = new EstadoCivil();
                estadoCivil.setIdEstado(resultSet.getInt("id_est_civil"));
                estadoCivil.setEstado(resultSet.getString("estado_civil"));
                estadosCiviles.add(estadoCivil);
            
            }
            return estadosCiviles;
            
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
    
    public EstadoCivil obtenerEstadoCivil(int idEstadoCivil) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        EstadoCivil estadoCivil = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_ESTCIVIL_BY_ID);
           preparedStatement.setInt(1, idEstadoCivil);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            estadoCivil = new EstadoCivil();
            estadoCivil.setIdEstado(resultSet.getInt("id_est_ivil"));
            estadoCivil.setEstado(resultSet.getString("estado_civil"));
           }
           return estadoCivil;
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
    
    public void actualizarEstadoCivil(int idEstadoCivil, EstadoCivil estadoCivil) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_ESTCIVIL);
            preparedStatement.setString(1, estadoCivil.getEstado());
            preparedStatement.setInt(2, idEstadoCivil);
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
    
    public void eliminarEstadoCivil(int idEstadoCivil) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_ESTCIVIL);
           preparedStatement.setInt(1, idEstadoCivil);
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
