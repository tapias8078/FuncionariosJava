package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.NivelEstudios;
import com.iudigital.util.ConnectionUtil;

public class NivelEstudiosDao {
    
    private static final String GET_NIVESTUDIOS = "select * from NivelEstudios";
    private static final String CREATE_NIVEST = "insert into nivelEstudios (nivel_est) values (?)";
    private static final String GET_NIVEST_BY_ID = "select * from nivelEstudios where id_niv_est = ?";
    private static final String UPDATE_NIVEST = "update nivelEstudios set nivel_est= ? where id_niv_est= ?";
    private static final String DELETE_NIVEST = "delete from nivelEstudios where id_niv_est=?";
    
    public void crearNivelEstudios(NivelEstudios nivelEstudio) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_NIVEST);        
        preparedStatement.setString(1,nivelEstudio.getNivelEst());
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
    
    public List<NivelEstudios> obtenerNivelesEstudios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<NivelEstudios> nivelEstudios = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_NIVESTUDIOS);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                NivelEstudios nivelEstudio = new NivelEstudios();
                nivelEstudio.setIdNivelEst(resultSet.getInt("id_niv_est"));
                nivelEstudio.setNivelEst(resultSet.getString("nivel_est"));
                nivelEstudios.add(nivelEstudio);
            
            }
            return nivelEstudios;
            
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
    
    public NivelEstudios obtenerNivelEstudio(int idNivelEstudios) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        NivelEstudios nivelEstudio = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_NIVEST_BY_ID);
           preparedStatement.setInt(1, idNivelEstudios);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            nivelEstudio = new NivelEstudios();
            nivelEstudio.setIdNivelEst(resultSet.getInt("id_niv_est"));
            nivelEstudio.setNivelEst(resultSet.getString("nivel_est"));
           }
           return nivelEstudio;
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
    
    public void actualizarNivelEstudios(int idNivelEstudios, NivelEstudios nivelEstudio) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_NIVEST);
            preparedStatement.setString(1, nivelEstudio.getNivelEst());
            preparedStatement.setInt(2, idNivelEstudios);
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
    
    public void eliminarNivelEstudios(int idNivelEstudios) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_NIVEST);
           preparedStatement.setInt(1, idNivelEstudios);
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
