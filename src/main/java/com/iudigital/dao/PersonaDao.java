package com.iudigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.dominio.Persona;
import com.iudigital.util.ConnectionUtil;

public class PersonaDao {

    private static final String GET_PERSONAS = "select personas.id_pers as ID,personas.numero_doc as Num_Doc, personas.nombres_pers as Nombres, personas.apellidos_pers as Apellidos, personas.fechanac_pers as fecha_nacimiento, sexo.sexo as sexo, tipodocumento.tipo_doc as tipo_doc, estadocivil.estado_civil as estado_civil, telefono.telefono as telefono, direccion.direccion as direccion from personas inner join sexo on sexo.id_sexo=personas.Sexo_id_sexo inner join tipodocumento on tipodocumento.id_tipo_doc = personas.TipoDocumento_id_tipo_doc inner join estadocivil on estadocivil.id_est_civil = personas.EstadoCivil_id_est_civil inner join telefono on telefono.id_telefono = personas.Telefono_id_telefono inner join direccion on direccion.id_direccion = personas.Direccion_id_direccion;";

    private static final String CREATE_PERSONA = "insert into personas (numero_doc,nombres_pers,apellidos_pers,fechanac_pers,Sexo_id_sexo,TipoDocumento_id_tipo_doc,EstadoCivil_id_est_civil,Telefono_id_telefono,Direccion_id_direccion) values (?,?,?,?,?,?,?,?,?)";
    private static final String GET_PERSONA_BY_ID = "select * from personas where id_pers = ?";
    private static final String UPDATE_PERSONA = "update personas set numero_doc = ?, nombres_pers = ?, apellidos_pers = ?, fechanac_pers = ?, Sexo_id_sexo = ?, TipoDocumento_id_tipo_doc = ?, EstadoCivil_id_est_civil = ?, Telefono_id_telefono = ?, Direccion_id_direccion = ? WHERE id_pers = ?";
    private static final String DELETE_PERSONA = "delete from personas  where id_pers=?";

    public void crearPersona(Persona persona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_PERSONA);
            
            preparedStatement.setString(1, persona.getNumDocPer());
            preparedStatement.setString(2, persona.getNombresPer());
            preparedStatement.setString(3, persona.getApellidosPer());
            preparedStatement.setString(4, persona.getFechaNacPer());
            preparedStatement.setString(5, persona.getIdSexo());
            preparedStatement.setString(6, persona.getIdtipoDoc());
            preparedStatement.setString(7, persona.getIdEstCiv());
            preparedStatement.setString(8, persona.getIdTelefono());
            preparedStatement.setString(9, persona.getIdDireccion());

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

    public List<Persona> obtenerPersonas() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Persona> personas = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_PERSONAS);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Persona persona = new Persona();
                persona.setIdPersona(resultSet.getString("id"));
                persona.setNumDocPer(resultSet.getString("num_doc"));
                persona.setNombresPer(resultSet.getString("nombres"));
                persona.setApellidosPer(resultSet.getString("apellidos"));
                persona.setFechaNacPer(resultSet.getString("fecha_nacimiento"));
                persona.setIdSexo(resultSet.getString("sexo"));
                persona.setIdtipoDoc(resultSet.getString("tipo_doc"));
                persona.setIdEstCiv(resultSet.getString("estado_civil"));
                persona.setIdTelefono(resultSet.getString("telefono"));
                persona.setIdDireccion(resultSet.getString("direccion"));
               
                personas.add(persona);
            
            }
            return personas;
            
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

    public Persona obtenerPersona(int idPers) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Persona persona = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_PERSONA_BY_ID);
            preparedStatement.setInt(1, idPers);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                persona = new Persona();
                persona.setIdPersona(resultSet.getString("id_pers"));
                persona.setNumDocPer(resultSet.getString("numero_doc"));
                persona.setNombresPer(resultSet.getString("nombres_pers"));
                persona.setApellidosPer(resultSet.getString("apellidos_pers"));
                persona.setFechaNacPer(resultSet.getString("fechanac_pers"));
                persona.setIdSexo(resultSet.getString("Sexo_id_sexo"));
                persona.setIdtipoDoc(resultSet.getString("tipodocumento_id_tipo_doc"));
                persona.setIdEstCiv(resultSet.getString("estadocivil_id_est_civil"));
                persona.setIdTelefono(resultSet.getString("telefono_id_telefono"));
                persona.setIdDireccion(resultSet.getString("direccion_id_direccion"));
            }
            return persona;
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

    public void actualizarPersona(int idPers, Persona persona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_PERSONA);
            preparedStatement.setString(1, persona.getNumDocPer());
            preparedStatement.setString(2, persona.getNombresPer());
            preparedStatement.setString(3, persona.getApellidosPer());
            preparedStatement.setString(4, persona.getFechaNacPer());
            preparedStatement.setString(5, persona.getIdSexo());
            preparedStatement.setString(6, persona.getIdtipoDoc());
            preparedStatement.setString(7, persona.getIdEstCiv());
            preparedStatement.setString(8, persona.getIdTelefono());
            preparedStatement.setString(9, persona.getIdDireccion());
            preparedStatement.setInt(10, idPers);
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

    public void eliminarPersona(int idPers) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_PERSONA);
            preparedStatement.setInt(1, idPers);
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
