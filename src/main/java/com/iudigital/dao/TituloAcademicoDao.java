package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.TituloAcademico;
import com.iudigital.util.ConnectionUtil;

public class TituloAcademicoDao {

    private static final String GET_TITULOSACADEMICOS = "select * from TituloAcademico";
    private static final String CREATE_TITULOACADEMICO = "insert into tituloAcademico (nombre_titulo) values (?)";
    private static final String GET_TITULOACADEMICO_BY_ID = "select * from tituloAcademico where id_titulo = ?";
    private static final String UPDATE_TITULOACADEMICO = "update tituloAcademico set nombre_titulo= ? where id_titulo= ?";
    private static final String DELETE_TITULOACADEMICO = "delete from tituloAcademico  where id_titulo=?";
    
    public void crearTituloAcademico(TituloAcademico tituloAcademico) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_TITULOACADEMICO);        
        preparedStatement.setString(1,tituloAcademico.getTitulo());
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
    
    public List<TituloAcademico> obtenerTitulosAcademicos() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<TituloAcademico> titulosAcademicos = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TITULOSACADEMICOS);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                TituloAcademico tituloAcademico = new TituloAcademico();
                tituloAcademico.setIdTitulo(resultSet.getInt("id_titulo"));
                tituloAcademico.setTitulo(resultSet.getString("nombre_titulo"));
                titulosAcademicos.add(tituloAcademico);
            
            }
            return titulosAcademicos;
            
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
    
    public TituloAcademico obtenerTituloAcademico(int idTituloAcademico) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TituloAcademico tituloAcademico = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_TITULOACADEMICO_BY_ID);
           preparedStatement.setInt(1, idTituloAcademico);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            tituloAcademico = new TituloAcademico();
            tituloAcademico.setIdTitulo(resultSet.getInt("id_titulo"));
            tituloAcademico.setTitulo(resultSet.getString("nombre_titulo"));
           }
           return tituloAcademico;
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
    
    public void actualizarTituloAcademico(int idTituloAcademico, TituloAcademico tituloAcademico) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_TITULOACADEMICO);
            preparedStatement.setString(1, tituloAcademico.getTitulo());
            preparedStatement.setInt(2, idTituloAcademico);
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
    
    public void eliminarTituloAcademico(int idTituloAcademico) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_TITULOACADEMICO);
           preparedStatement.setInt(1, idTituloAcademico);
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
