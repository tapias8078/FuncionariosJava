package com.iudigital.dao;
import com.iudigital.dominio.Sexo;
import com.iudigital.util.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SexoDao {

    
    private static final String GET_SEXOS = "select * from sexo";
    private static final String CREATE_SEXO = "insert into sexo (sexo) values (?)";
    private static final String GET_SEXO_BY_ID = "select * from sexo where id_sexo = ?";
    private static final String UPDATE_SEXO = "update sexo set sexo=? where id_sexo=?";
    private static final String DELETE_SEXO = "delete from sexo  where id_sexo=?";
    
    public void crearSexo(Sexo sexo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_SEXO);        
        preparedStatement.setString(1,sexo.getSexo());
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
    
    public List<Sexo> obtenerSexos() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sexo> sexos = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_SEXOS);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Sexo sexo = new Sexo();
                sexo.setIdSexo(resultSet.getInt("id_sexo"));
                sexo.setSexo(resultSet.getString("Sexo"));
                sexos.add(sexo);
            
            }
            return sexos;
            
        } finally{
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
    
    public Sexo obtenerSexo(int idSexo) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Sexo sexo = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_SEXO_BY_ID);
           preparedStatement.setInt(1, idSexo);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            sexo = new Sexo();
            sexo.setIdSexo(resultSet.getInt("id_sexo"));
            sexo.setSexo(resultSet.getString("sexo"));
           }
           return sexo;
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
    
    public void actualizarSexo(int idSexo, Sexo sexo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_SEXO);
            preparedStatement.setString(1, sexo.getSexo());
            preparedStatement.setInt(2, idSexo);
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
    
    public void eliminarSexo(int idSexo) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_SEXO);
           preparedStatement.setInt(1, idSexo);
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

    

