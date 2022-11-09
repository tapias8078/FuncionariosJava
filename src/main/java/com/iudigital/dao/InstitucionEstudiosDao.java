package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.InstitucionEstudios;
import com.iudigital.util.ConnectionUtil;

public class InstitucionEstudiosDao {

    private static final String GET_INSTITUCIONES = "select * from InstitucionEstudios";
    private static final String CREATE_INSTITUCION = "insert into InstitucionEstudios (nombre_inst) values (?)";
    private static final String GET_INSTITUCION_BY_ID = "select * from InstitucionEstudios where id_institucion = ?";
    private static final String UPDATE_INSTITUCION = "update InstitucionEstudios set nombre_inst= ? where id_institucion= ?";
    private static final String DELETE_INSTITUCION = "delete from InstitucionEstudios  where id_institucion=?";
    
    public void crearInstitucion(InstitucionEstudios institucion) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_INSTITUCION);        
        preparedStatement.setString(1,institucion.getInstitucion());
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
    
    public List<InstitucionEstudios> obtenerInstituciones() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<InstitucionEstudios> instituciones = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_INSTITUCIONES);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                InstitucionEstudios institucion = new InstitucionEstudios();
                institucion.setIdInstitucion(resultSet.getInt("id_institucion"));
                institucion.setInstitucion(resultSet.getString("nombre_inst"));
                instituciones.add(institucion);
            
            }
            return instituciones;
            
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
    
    public InstitucionEstudios obtenerInstitucion(int idInstitucion) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        InstitucionEstudios institucion = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_INSTITUCION_BY_ID);
           preparedStatement.setInt(1, idInstitucion);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            institucion = new InstitucionEstudios();
            institucion.setIdInstitucion(resultSet.getInt("id_institucion"));
            institucion.setInstitucion(resultSet.getString("nombre_inst"));
           }
           return institucion;
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
    
    public void actualizarInstitucion(int idInstitucion, InstitucionEstudios institucion) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_INSTITUCION);
            preparedStatement.setString(1, institucion.getInstitucion());
            preparedStatement.setInt(2, idInstitucion);
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
    
    public void eliminarInstitucion(int idInstitucion) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_INSTITUCION);
           preparedStatement.setInt(1, idInstitucion);
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
