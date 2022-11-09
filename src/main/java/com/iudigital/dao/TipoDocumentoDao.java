package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.TipoDocumento;
import com.iudigital.util.ConnectionUtil;

public class TipoDocumentoDao {

    private static final String GET_TIPODOCUMENTOS = "select * from TipoDocumento";
    private static final String CREATE_TIPODOCUMENTO = "insert into tipoDocumento (tipo_doc) values (?)";
    private static final String GET_TIPODOCUMENTO_BY_ID = "select * from tipoDocumento where id_tipo_doc = ?";
    private static final String UPDATE_TIPODOCUMENTO = "update tipoDocumento set tipo_doc = ? where id_tipo_doc= ?";
    private static final String DELETE_TIPODOCUMENTO = "delete from tipoDocumento  where id_tipo_doc=?";
    
    public void crearTipoDocumento(TipoDocumento tipoDocumento) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
        connection= ConnectionUtil.getConnection();
        preparedStatement= connection.prepareCall(CREATE_TIPODOCUMENTO);        
        preparedStatement.setString(1,tipoDocumento.getTipoDoc());
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
    
    public List<TipoDocumento> obtenerTipoDocumentos() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<TipoDocumento> tipoDocumentos = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TIPODOCUMENTOS);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setIdTipoDoc(resultSet.getInt("id_tipo_doc"));
                tipoDocumento.setTipoDoc(resultSet.getString("tipo_doc"));
                tipoDocumentos.add(tipoDocumento);
            
            }
            return tipoDocumentos;
            
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
    
    public TipoDocumento obtenerTipoDocumento(int idTipoDocumento) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TipoDocumento tipoDocumento = null;
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_TIPODOCUMENTO_BY_ID);
           preparedStatement.setInt(1, idTipoDocumento);
           resultSet= preparedStatement.executeQuery(); 
           if(resultSet.next()){
            tipoDocumento = new TipoDocumento();
            tipoDocumento.setIdTipoDoc(resultSet.getInt("id_tipo_doc"));
            tipoDocumento.setTipoDoc(resultSet.getString("tipo_doc"));
           }
           return tipoDocumento;
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
    
    public void actualizarTipoDocumento(int idTipoDocumento, TipoDocumento tipoDocumento) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_TIPODOCUMENTO);
            preparedStatement.setString(1, tipoDocumento.getTipoDoc());
            preparedStatement.setInt(2, idTipoDocumento);
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
    
    public void eliminarTipoDocumento(int idTipoDocumento) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(DELETE_TIPODOCUMENTO);
           preparedStatement.setInt(1, idTipoDocumento);
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
