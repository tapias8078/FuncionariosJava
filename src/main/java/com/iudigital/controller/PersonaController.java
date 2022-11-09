package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.PersonaDao;
import com.iudigital.dominio.Persona;

public class PersonaController {
    
    private PersonaDao personaDao;
    
    public PersonaController(){
        personaDao = new PersonaDao();
    }
    
    public void crearPersona(Persona persona) throws SQLException{
        personaDao.crearPersona(persona);
    }
    public List<Persona> obtnerPersonas() throws SQLException {
        return personaDao.obtenerPersonas();
    }
    public Persona obtenerPersona(int id) throws SQLException{
        return personaDao.obtenerPersona(id);
    }
    public void actualizarPersona(int id, Persona persona) throws SQLException{
        personaDao.actualizarPersona(id, persona);
    }
    public void eliminarPersona(int id) throws SQLException{
        personaDao.eliminarPersona(id);
    }
    
}
