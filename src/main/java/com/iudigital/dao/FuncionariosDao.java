package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.Funcionarios;
import com.iudigital.util.ConnectionUtil;

public class FuncionariosDao {
    
    private static final String GET_FUNCIONARIOS = "select funcionarios.id_func as id, nivelestudios.nivel_est as nivel_est,institucionestudios.nombre_inst as Institucion , tituloacademico.nombre_titulo as nombre_titulo, personas.id_pers, personas.numero_doc,personas.nombres_pers, personas.apellidos_pers from funcionarios inner join nivelestudios on nivelestudios.id_niv_est = funcionarios.NivelEstudios_id_niv_est inner join institucionestudios on institucionestudios.id_institucion = funcionarios.InstitucionEstudios_id_institucion inner join tituloacademico on tituloacademico.id_titulo = funcionarios.TituloAcademico_id_titulo inner join personas on personas.id_pers = funcionarios.Personas_id_pers";
    private static final String CREATE_FUNCIONARIO = "insert into funcionarios (NivelEstudios_id_niv_est,InstitucionEstudios_id_institucion,TituloAcademico_id_titulo,Personas_id_pers) values (?,?,?,?)";
    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios where id_func = ?";
    private static final String UPDATE_FUNCIONARIO = "update funcionarios set NivelEstudios_id_niv_est = ? InstitucionEstudios_id_institucion = ? TituloAcademico_id_titulo = ? Peronas_id_pers = ? where id_func= ?";
    private static final String DELETE_FUNCIONARIO = "delete from funcionarios  where id_func=?";
    
    public void crearFuncionario(Funcionarios funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            
            preparedStatement.setString(1,funcionario.getIdnivelEst());
            preparedStatement.setString(2,funcionario.getIdInstEst());
            preparedStatement.setString(3,funcionario.getIdTituloAcad());
            preparedStatement.setString(4,funcionario.getIdPersona());
           
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

    public List<Funcionarios> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionarios>funcionarios = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Funcionarios funcionario = new Funcionarios();                

                funcionario.setIdFunc(resultSet.getString("id"));
                funcionario.setIdnivelEst(resultSet.getString("nivel_est"));
                funcionario.setIdInstEst(resultSet.getString("Institucion"));
                funcionario.setIdTituloAcad(resultSet.getString("nombre_titulo"));
                funcionario.setIdPersona(resultSet.getString("id_pers"));
                funcionario.setCedulaPersona(resultSet.getString("numero_doc"));              
                funcionario.setNombresPersona(resultSet.getString("nombres_pers"));              
                funcionario.setApellidosPersona(resultSet.getString("apellidos_pers"));              
               
               funcionarios.add(funcionario);
            
            }
            return funcionarios;
            
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

    public Funcionarios obtenerFuncionario(int idFunc) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionarios funcionario = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, idFunc);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               funcionario = new Funcionarios();
               funcionario.setIdFunc(resultSet.getString("id_func"));
               funcionario.setIdnivelEst(resultSet.getString("NivelEstudios_id_niv_est"));
               funcionario.setIdInstEst(resultSet.getString("InstitucionEstudios_id_institucion"));
               funcionario.setIdTituloAcad(resultSet.getString("TituloAcademico_id_titulo"));
               funcionario.setIdPersona(resultSet.getString("Personas_id_pers"));
            }
            return funcionario;
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

    public void actualizarFuncionario(int idFunc, Funcionarios funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIO);
            preparedStatement.setString(0,funcionario.getIdnivelEst());
            preparedStatement.setString(1,funcionario.getIdInstEst());
            preparedStatement.setString(2,funcionario.getIdTituloAcad());
            preparedStatement.setString(3,funcionario.getIdPersona());            
            preparedStatement.setInt(4, idFunc);
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

    public void eliminarFuncionario(int idFunc) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, idFunc);
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
