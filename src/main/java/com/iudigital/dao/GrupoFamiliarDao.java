package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.GrupoFamiliar;
import com.iudigital.util.ConnectionUtil;

public class GrupoFamiliarDao {

    private static final String GET_GRUPOSFAMILIARES = "";
    private static final String CREATE_GRUPOFAMILIAR = "SELECT grupofamiliar.id_grup as id, rol.nombre_rol as rol, personas.numero_doc as persona_doc, funcionarios.id_func as funcionario_id from grupofamiliar inner join rol on rol.idRol = grupofamiliar.Rol_idRol inner join personas on personas.id_pers = grupofamiliar.Personas_id_pers inner join funcionarios on funcionarios.id_func = grupofamiliar.Funcionarios_id_func;";
    private static final String GET_GRUPOFAMILIAR_BY_ID = "select * from grupoFamiliar where id_grup = ?";
    private static final String UPDATE_GRUPOFAMILIAR = "update grupoFamiliar set Rol_idRol = ? Personas_id_pers = ? Funcionarios_id_func = ? Peronas_id_pers = ? where id_grup = ?";
    private static final String DELETE_GRUPOFAMILIAR = "delete from grupoFamiliar  where id_grup=?";
    
    public void crearGrupoFamiliar(GrupoFamiliar grupoFamiliar) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_GRUPOFAMILIAR);
            
            preparedStatement.setInt(1,grupoFamiliar.getIdRol());
            preparedStatement.setInt(2,grupoFamiliar.getIdPer());
            preparedStatement.setInt(3,grupoFamiliar.getIdFuncionario());
            
           
            preparedStatement.executeUpdate();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public List<GrupoFamiliar> obtenerGruposFamiliares() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GrupoFamiliar>gruposFamiliares = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_GRUPOSFAMILIARES);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                GrupoFamiliar grupoFamiliar = new GrupoFamiliar();

                grupoFamiliar.setIdGrupo(resultSet.getInt("id"));
                grupoFamiliar.setIdRol(resultSet.getInt("rol"));
                grupoFamiliar.setIdPer(resultSet.getInt("persona_doc"));
                grupoFamiliar.setIdFuncionario(resultSet.getInt("funcionario_id"));           
               
               
               
               gruposFamiliares.add(grupoFamiliar);
            
            }
            return gruposFamiliares;
            
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

    public GrupoFamiliar obtenerGrupoFamiliar(int idGrupo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        GrupoFamiliar grupoFamiliar = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_GRUPOFAMILIAR_BY_ID);
            preparedStatement.setInt(1, idGrupo);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               grupoFamiliar = new GrupoFamiliar();

               grupoFamiliar.setIdGrupo(resultSet.getInt("id_grupo"));
                grupoFamiliar.setIdRol(resultSet.getInt("Rol_idRol"));
                grupoFamiliar.setIdPer(resultSet.getInt("Personas_id_pers"));
                grupoFamiliar.setIdFuncionario(resultSet.getInt("Funcionarios_id_func"));                  
            }
            return grupoFamiliar;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (resultSet != null) {
                connection.close();
            }
        }

    }

    public void actualizarGrupoFamiliar(int idGrupo, GrupoFamiliar grupoFamiliar) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_GRUPOFAMILIAR);
            preparedStatement.setInt(0,grupoFamiliar.getIdRol());
            preparedStatement.setInt(1,grupoFamiliar.getIdPer());
            preparedStatement.setInt(2,grupoFamiliar.getIdFuncionario());
                     
            preparedStatement.setInt(4, idGrupo);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void eliminarGrupoFamiliar(int idGrupo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_GRUPOFAMILIAR);
            preparedStatement.setInt(1, idGrupo);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }
    
}