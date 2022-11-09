package com.iudigital.controller;

import java.sql.SQLException;
import java.util.List;

import com.iudigital.dao.TipoDocumentoDao;
import com.iudigital.dominio.TipoDocumento;

public class TipoDocumentoController {

    private TipoDocumentoDao tipoDocumentoDao;
    
    public TipoDocumentoController(){
        tipoDocumentoDao = new TipoDocumentoDao();
    }
    
    public void crearTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        tipoDocumentoDao.crearTipoDocumento(tipoDocumento);
    }
    public List<TipoDocumento> obtnerTipoDocumentos() throws SQLException {
        return tipoDocumentoDao.obtenerTipoDocumentos();
    }
    public TipoDocumento obtenerTipoDocumento(int id) throws SQLException{
        return tipoDocumentoDao.obtenerTipoDocumento(id);
    }
    public void actualizarTipoDocumento(int id, TipoDocumento tipoDocumento) throws SQLException{
        tipoDocumentoDao.actualizarTipoDocumento(id, tipoDocumento);
    }
    public void eliminarTipoDocumento(int id) throws SQLException{
        tipoDocumentoDao.eliminarTipoDocumento(id);
    }
    
}
