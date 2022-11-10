
package com.iudigital.view;

import com.iudigital.controller.DireccionController;
import com.iudigital.controller.EstadoCivilController;
import com.iudigital.controller.FuncionarioController;
import com.iudigital.controller.GrupoFamiliarController;
import com.iudigital.controller.InstitucionEstudioController;
import com.iudigital.controller.NivelEstudiosController;
import com.iudigital.controller.PersonaController;
import com.iudigital.controller.RolController;
import com.iudigital.controller.SexoController;
import com.iudigital.controller.TelefonoController;
import com.iudigital.controller.TipoDocumentoController;
import com.iudigital.controller.TituloAcademicoController;
import com.iudigital.dominio.Direccion;
import com.iudigital.dominio.EstadoCivil;
import com.iudigital.dominio.Funcionarios;
import com.iudigital.dominio.GrupoFamiliar;
import com.iudigital.dominio.InstitucionEstudios;
import com.iudigital.dominio.NivelEstudios;
import com.iudigital.dominio.Persona;
import com.iudigital.dominio.Rol;
import com.iudigital.dominio.Sexo;
import com.iudigital.dominio.Telefono;
import com.iudigital.dominio.TipoDocumento;
import com.iudigital.dominio.TituloAcademico;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Main1 extends javax.swing.JFrame {

    private final RolController rolController;
    private final SexoController sexoController;
    private final DireccionController direccionController;
    private final EstadoCivilController estadoCivilController;
    private final FuncionarioController funcionarioController;
    private final GrupoFamiliarController grupoFamiliarController;
    private final InstitucionEstudioController institucionEstudioController;
    private final NivelEstudiosController nivelEstudiosController;
    private final PersonaController personaController;
    private final TelefonoController telefonoController;
    private final TipoDocumentoController tipoDocumentoController;
    private final TituloAcademicoController tituloAcademicoController;
    


    private final String[] COLUMNSROL = {"ID","ROL"};
    private final String[] COLUMNSSEXO = {"ID","SEXO"};
    private final String[] COLUMNSDIR = {"ID","DIRECCION"};
    private final String[] COLUMNSESTADO = {"ID","ESTADO CIVIL"};
    private final String[] COLUMNSINST = {"ID","INSTITUCION DE ESTUDIOS"};
    private final String[] COLUMNSNIV = {"ID","NIVEL DE ESTUDIOS"};
    private final String[] COLUMNSTELEFONO = {"ID","TELEFONO"};
    private final String[] COLUMNSTIPO= {"ID","TIPO DE DOCUMENTO"};
    private final String[] COLUMNSTITULO= {"ID","TITULO ACADEMICO"};
    private final String[] COLUMNSPERSONA= {"ID","DOCUMENTO","TIPO DOCUMENTO","NOMBRES","APELLIDOS","FECHA NACIMIENTO","SEXO","ESTADO CIVIL","TELEFONO","DIRECCION"};
    private final String[] COLUMNSFUNCIONARIO= {"ID","NIVEL ESTUDIOS","INSTITUCION DE ESTUDIOS","TITULO","ID PERSONA","CEDULA","NOMBRES","APELLIDOS"};
    private final String SELECCIONE = "-- SELECCIONE --";
    
    public Main1() {
        initComponents();
        txtIdRol.setEditable(false);
        txtIdSexo.setEditable(false);
        txtIdDir.setEditable(false);
        txtIdEstado.setEditable(false);
        txtIdInstitucion.setEditable(false);
        txtIdInstitucion.setEditable(false);
        txtIdNivel.setEditable(false);
        txtIdTelefono.setEditable(false);
        txtIdTipo.setEditable(false);
        txtIdTitulo.setEditable(false);
        txtIdNivelEst.setEditable(false);
        txtIdInst.setEditable(false);
        txtIdTituloAcad.setEditable(false);
        txtIdPers.setEditable(false);
        txtIdPersona.setEditable(false);
        txtIdFunc.setEditable(false);
        
        
               
        
        
        rolController = new RolController();
        sexoController = new SexoController();
        direccionController = new DireccionController();
        estadoCivilController = new EstadoCivilController();
        funcionarioController = new FuncionarioController();
        grupoFamiliarController = new GrupoFamiliarController();
        institucionEstudioController = new InstitucionEstudioController();
        nivelEstudiosController = new NivelEstudiosController();
        personaController = new PersonaController();
        telefonoController = new TelefonoController();
        tipoDocumentoController = new TipoDocumentoController();
        tituloAcademicoController = new TituloAcademicoController();
        
        
        listRoles();
        listSexos();
        listNivelEstudios();
        listInstituciones();
        listTitulos();
        listEstados();
        listDirecciones();
        listTelefonos();
        listTipoDoc();
        listPersonas();
        listFuncionarios();
        addListener();  
        
    }




     private void listFuncionarios() {
       
        cbxFuncionarios.removeAllItems();      
        tblFuncionario.removeAll();
        Funcionarios func1 = new Funcionarios();
        func1.setApellidosPersona("");
        func1.setNombresPersona("");
        func1.setCedulaPersona(SELECCIONE);

        cbxFuncionarios.addItem(func1);


        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSFUNCIONARIO) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblFuncionario.setModel(defaultTableModel);
        try {
            List<Funcionarios> funcionarios = funcionarioController.obtnerFuncionarios();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionarios funcionario : funcionarios) {
                
                defaultTableModel.setValueAt(funcionario.getIdFunc(), row, 0);
                defaultTableModel.setValueAt(funcionario.getIdnivelEst(), row, 1);
                defaultTableModel.setValueAt(funcionario.getIdInstEst(), row, 2);
                defaultTableModel.setValueAt(funcionario.getIdTituloAcad(), row, 3);
                defaultTableModel.setValueAt(funcionario.getIdPersona(), row, 4);
                defaultTableModel.setValueAt(funcionario.getCedulaPersona(), row, 5);
                defaultTableModel.setValueAt(funcionario.getNombresPersona(), row, 6);
                defaultTableModel.setValueAt(funcionario.getApellidosPersona(), row, 7);
                
                
                
                row++;

                cbxFuncionarios.addItem(funcionario);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void listPersonas() {
       
        cbxPersonas.removeAllItems();
        cbxPersonas1.removeAllItems();
        Persona per1 = new Persona();
        per1.setNombresPer("");        
        per1.setApellidosPer("");        
        per1.setNumDocPer(SELECCIONE);        
        cbxPersonas.addItem(per1);
        cbxPersonas1.addItem(per1);        
        
               
        tblPersona.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSPERSONA) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblPersona.setModel(defaultTableModel);
        try {
            List<Persona> personas = personaController.obtnerPersonas();
            if (personas.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(personas.size());
            int row = 0;
            for (Persona persona : personas) {
                
                defaultTableModel.setValueAt(persona.getIdPersona(), row, 0);
                defaultTableModel.setValueAt(persona.getNumDocPer(), row, 1);
                defaultTableModel.setValueAt(persona.getIdtipoDoc(), row, 2);
                defaultTableModel.setValueAt(persona.getNombresPer(), row, 3);
                defaultTableModel.setValueAt(persona.getApellidosPer(), row, 4);
                defaultTableModel.setValueAt(persona.getFechaNacPer(), row, 5);
                defaultTableModel.setValueAt(persona.getIdSexo(), row, 6);
                defaultTableModel.setValueAt(persona.getIdEstCiv(), row, 7);
                defaultTableModel.setValueAt(persona.getIdTelefono(), row, 8);
                defaultTableModel.setValueAt(persona.getIdDireccion(), row, 9);
                
                row++;

                cbxPersonas.addItem(persona);
                cbxPersonas1.addItem(persona);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void listTipoDoc() {

        cbxTipoDoc.removeAllItems();
        TipoDocumento tipo1 = new TipoDocumento();
        tipo1.setTipoDoc(SELECCIONE);        
        cbxTipoDoc.addItem(tipo1);
        tblTipos.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSTIPO) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblTipos.setModel(defaultTableModel);
        try {
            List<TipoDocumento> tipos = tipoDocumentoController.obtnerTipoDocumentos();
            if (tipos.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(tipos.size());
            int row = 0;
            for (TipoDocumento tipo : tipos) {
                
                defaultTableModel.setValueAt(tipo.getIdTipoDoc(), row, 0);
                defaultTableModel.setValueAt(tipo.getTipoDoc(), row, 1);
                
                row++;

                cbxTipoDoc.addItem(tipo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void listTelefonos() {

        cbxTelefonos.removeAllItems();
        Telefono tel1 = new Telefono();
        tel1.setTelefono(SELECCIONE);        
        cbxTelefonos.addItem(tel1);
        tblTelefonos.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSTELEFONO) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblTelefonos.setModel(defaultTableModel);
        try {
            List<Telefono> tels = telefonoController.obtnerTelefonos();
            if (tels.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(tels.size());
            int row = 0;
            for (Telefono tel : tels) {
                
                defaultTableModel.setValueAt(tel.getIdTelefono(), row, 0);
                defaultTableModel.setValueAt(tel.getTelefono(), row, 1);
                
                row++;

                cbxTelefonos.addItem(tel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void listDirecciones() {

        cbxDireccion.removeAllItems();
        Direccion dir1 = new Direccion();
        dir1.setDireccion(SELECCIONE);        
        cbxDireccion.addItem(dir1);
        tblDir.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSDIR) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblDir.setModel(defaultTableModel);
        try {
            List<Direccion> dirs = direccionController.obtnerDirecciones();
            if (dirs.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(dirs.size());
            int row = 0;
            for (Direccion dir : dirs) {
                
                defaultTableModel.setValueAt(dir.getIdDireccion(), row, 0);
                defaultTableModel.setValueAt(dir.getDireccion(), row, 1);
                
                row++;

                cbxDireccion.addItem(dir);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void listEstados() {

        cbxEstadoCiv.removeAllItems();
        EstadoCivil estado1 = new EstadoCivil();
        estado1.setEstado(SELECCIONE);        
        cbxEstadoCiv.addItem(estado1);
        tblEstados.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSESTADO) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblEstados.setModel(defaultTableModel);
        try {
            List<EstadoCivil> estados = estadoCivilController.obtnerEstadosCiviles();
            if (estados.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(estados.size());
            int row = 0;
            for (EstadoCivil estado : estados) {
                
                defaultTableModel.setValueAt(estado.getIdEstado(), row, 0);
                defaultTableModel.setValueAt(estado.getEstado(), row, 1);
                
                row++;

                cbxEstadoCiv.addItem(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     private void listTitulos() {

        cbxTitulo.removeAllItems();
        TituloAcademico titulo1 = new TituloAcademico();
        titulo1.setTitulo(SELECCIONE);        
        cbxTitulo.addItem(titulo1);
        tblTitulos.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSTITULO) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblTitulos.setModel(defaultTableModel);
        try {
            List<TituloAcademico> titulos = tituloAcademicoController.obtnerTitulosAcademicos();
            if (titulos.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(titulos.size());
            int row = 0;
            for (TituloAcademico titulo : titulos) {
                
                defaultTableModel.setValueAt(titulo.getIdTitulo(), row, 0);
                defaultTableModel.setValueAt(titulo.getTitulo(), row, 1);
                
                row++;

                cbxTitulo.addItem(titulo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void listRoles() {

        cbxRoles.removeAllItems();
        Rol rol1 = new Rol();
        rol1.setNombreRol(SELECCIONE);        
        cbxRoles.addItem(rol1);
        tblRoles.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSROL) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblRoles.setModel(defaultTableModel);
        try {
            List<Rol> roles = rolController.obtnerRoles();
            if (roles.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(roles.size());
            int row = 0;
            for (Rol rol : roles) {
                
                defaultTableModel.setValueAt(rol.getIdRol(), row, 0);
                defaultTableModel.setValueAt(rol.getNombreRol(), row, 1);
                
                row++;

                cbxRoles.addItem(rol);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void listNivelEstudios() {

        cbxNivelEst.removeAllItems();
        NivelEstudios nivel1 = new NivelEstudios();
        nivel1.setNivelEst(SELECCIONE);        
        cbxNivelEst.addItem(nivel1);
        tblNivel.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSNIV) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblNivel.setModel(defaultTableModel);
        try {
            List<NivelEstudios> niveles = nivelEstudiosController.obtnerNivelEstudios();
            if (niveles.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(niveles.size());
            int row = 0;
            for (NivelEstudios niv : niveles) {
                
                defaultTableModel.setValueAt(niv.getIdNivelEst(), row, 0);
                defaultTableModel.setValueAt(niv.getNivelEst(), row, 1);
                
                row++;

                cbxNivelEst.addItem(niv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


     private void listSexos() {

        cbxSexos.removeAllItems();
        Sexo sexo1 = new Sexo();
        sexo1.setSexo(SELECCIONE);        
        cbxSexos.addItem(sexo1);
        tblSexos.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSSEXO) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblSexos.setModel(defaultTableModel);
        try {
            List<Sexo> sexos = sexoController.obtnerSexos();
            if (sexos.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(sexos.size());
            int row = 0;
            for (Sexo sexo : sexos) {                
                defaultTableModel.setValueAt(sexo.getIdSexo(), row, 0);
                defaultTableModel.setValueAt(sexo.getSexo(), row, 1);
                
                row++;

                cbxSexos.addItem(sexo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
      private void listInstituciones() {

        cbxInstituciones.removeAllItems();
        InstitucionEstudios inst1 = new InstitucionEstudios();
        inst1.setInstitucion(SELECCIONE);        
        cbxInstituciones.addItem(inst1);
        tblInstitucion.removeAll();
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNSINST) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblInstitucion.setModel(defaultTableModel);
        try {
            List<InstitucionEstudios> instituciones = institucionEstudioController.obtnerInstitucionesEstudios();
            if (instituciones.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(instituciones.size());
            int row = 0;
            for (InstitucionEstudios inst : instituciones) {                
                defaultTableModel.setValueAt(inst.getIdInstitucion(), row, 0);
                defaultTableModel.setValueAt(inst.getInstitucion(), row, 1);
                
                row++;

                cbxInstituciones.addItem(inst);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // listar por id funciones
    public void obtenerFuncionario(FuncionarioController funcionarioController, int id) {

        try {
           Funcionarios funcionario = funcionarioController.obtenerFuncionario(id);
           //String nivelEstudio = funcionario.getIdFunc().toString();
           
           txtIdNivelEst.setText(String.valueOf(funcionario.getIdnivelEst()));
           txtIdInst.setText(String.valueOf(funcionario.getIdInstEst()));
           txtIdTituloAcad.setText(String.valueOf(funcionario.getIdTituloAcad()));
           txtIdPers.setText(String.valueOf(funcionario.getIdPersona()));
           txtIdFunc.setText(String.valueOf(funcionario.getIdFunc()));
          

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    

     
     
     
     private void addListener() {
        cbxRoles.addItemListener(event -> {
            Rol selectedRol = (Rol) event.getItem();
            if (selectedRol.getNombreRol().equals(SELECCIONE)) {
                txtIdRoles.setText("");
                

            } else {
                txtIdRoles.setText(String.valueOf(selectedRol.getIdRol()));
                
                
            }
            System.out.println("selectedRol = " + selectedRol);
        });
        
        cbxSexos.addItemListener(event -> {
            Sexo selectedSexo = (Sexo) event.getItem();
            if (selectedSexo.getSexo().equals(SELECCIONE)) {
                txtSexo.setText("");
                

            } else {
                txtIdSexo.setText(String.valueOf(selectedSexo.getIdSexo()));
                txtSexo.setText(selectedSexo.getSexo());
                
            }
            System.out.println("selectedSexo = " + selectedSexo);
        });
        cbxPersonas1.addItemListener(event -> {
            Persona selectedPer = (Persona) event.getItem();            
            if (selectedPer.getNumDocPer().equals(SELECCIONE)) {
                txtIdPers1.setText("");
                

            } else {
                txtIdPers1.setText(String.valueOf(selectedPer.getIdPersona()));
                
                
            }
            System.out.println("selectedRol = " + selectedPer);
        });
        cbxFuncionarios.addItemListener(event -> {
            Funcionarios selectedFunc = (Funcionarios) event.getItem();            
            if (selectedFunc.getCedulaPersona().equals(SELECCIONE)) {
                txtIdFuncionario.setText("");
                

            } else {
                txtIdFuncionario.setText(String.valueOf(selectedFunc.getIdFunc()));
                
                
            }
            System.out.println("selectedRol = " + selectedFunc);
        });

        //TODO:

        cbxNivelEst.addItemListener(event -> {
            NivelEstudios selectedNivel = (NivelEstudios) event.getItem();            
            if (selectedNivel.getNivelEst().equals(SELECCIONE)) {
                txtIdNivelEst.setText("");
                

            } else {
                txtIdNivelEst.setText(String.valueOf(selectedNivel.getIdNivelEst()));
                
                
            }
            System.out.println("selectedRol = " + selectedNivel);
        });
        cbxInstituciones.addItemListener(event -> {
            InstitucionEstudios selectedInst = (InstitucionEstudios) event.getItem();            
            if (selectedInst.getInstitucion().equals(SELECCIONE)) {
                txtIdInst.setText("");
                

            } else {
                txtIdInst.setText(String.valueOf(selectedInst.getIdInstitucion()));
                
                
            }
            System.out.println("selectedRol = " + selectedInst);
        });
        cbxTitulo.addItemListener(event -> {
            TituloAcademico selectedTitulo = (TituloAcademico) event.getItem();            
            if (selectedTitulo.getTitulo().equals(SELECCIONE)) {
                txtIdTituloAcad.setText("");
                

            } else {
                txtIdTituloAcad.setText(String.valueOf(selectedTitulo.getIdTitulo()));
                
                
            }
            System.out.println("selectedRol = " + selectedTitulo);
        });
        cbxPersonas.addItemListener(event -> {
            Persona selectedPersona = (Persona) event.getItem();            
            if (selectedPersona.getNumDocPer().equals(SELECCIONE)) {
                txtIdPers.setText("");
                

            } else {
                txtIdPers.setText(String.valueOf(selectedPersona.getIdPersona()));
                
                
            }
            System.out.println("selectedRol = " + selectedPersona);
        });
       
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JPFuncionarios = new javax.swing.JTabbedPane();
        JPPersonas = new javax.swing.JPanel();
        lblSexo = new javax.swing.JLabel();
        cbxSexos = new javax.swing.JComboBox<>();
        lblEstadoCiv = new javax.swing.JLabel();
        cbxEstadoCiv = new javax.swing.JComboBox<>();
        lblDireccion = new javax.swing.JLabel();
        cbxDireccion = new javax.swing.JComboBox<>();
        lblTel = new javax.swing.JLabel();
        cbxTelefonos = new javax.swing.JComboBox<>();
        lblTipoDoc = new javax.swing.JLabel();
        cbxTipoDoc = new javax.swing.JComboBox<>();
        lblNumeroDoc = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        lblNumeroDoc1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblNumeroDoc2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblNumeroDoc3 = new javax.swing.JLabel();
        jDateFechaNac = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPersona = new javax.swing.JTable();
        btnCrearPersona = new javax.swing.JButton();
        btnBorrarPersona = new javax.swing.JButton();
        btnActualizarPersona = new javax.swing.JButton();
        lblNumeroDoc4 = new javax.swing.JLabel();
        txtIdPersona = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cbxNivelEst = new javax.swing.JComboBox<>();
        lblNivelEst = new javax.swing.JLabel();
        lblInstituciones = new javax.swing.JLabel();
        cbxInstituciones = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        cbxTitulo = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        txtIdFunc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxPersonas = new javax.swing.JComboBox<>();
        btnCrearFuncionario = new javax.swing.JButton();
        txtIdNivelEst = new javax.swing.JTextField();
        txtIdInst = new javax.swing.JTextField();
        txtIdTituloAcad = new javax.swing.JTextField();
        txtIdPers = new javax.swing.JTextField();
        btnActualizarFuncionario = new javax.swing.JButton();
        btnBorrarFuncionario = new javax.swing.JButton();
        JPGrupoFamiliar = new javax.swing.JPanel();
        cbxRoles = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblGrupoFamiliar = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbxPersonas1 = new javax.swing.JComboBox<>();
        txtIdPers1 = new javax.swing.JTextField();
        btnAddPerGrup = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        txtIdFuncionario = new javax.swing.JTextField();
        txtIdRoles = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdGrupo = new javax.swing.JTextField();
        JPSexos = new javax.swing.JPanel();
        txtIdSexo = new javax.swing.JTextField();
        lblIdSexo = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        lblNombreSexo = new javax.swing.JLabel();
        btnEditarSexo = new javax.swing.JButton();
        btnCrearSexo = new javax.swing.JButton();
        btnBorrarSexo = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblSexos = new javax.swing.JTable();
        JPRoles = new javax.swing.JPanel();
        txtIdRol = new javax.swing.JTextField();
        txtNombreRol = new javax.swing.JTextField();
        lblIdRol = new javax.swing.JLabel();
        lblNombreRol = new javax.swing.JLabel();
        btnCrearRol = new javax.swing.JButton();
        btnEditarRol = new javax.swing.JButton();
        btnBorrarRol = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        JPNivel = new javax.swing.JPanel();
        lblIdNivel = new javax.swing.JLabel();
        txtIdNivel = new javax.swing.JTextField();
        lblNivel = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        btnBorrarNivel = new javax.swing.JButton();
        btnEditarNivel = new javax.swing.JButton();
        btnCrearNivel = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNivel = new javax.swing.JTable();
        JPInstitucion = new javax.swing.JPanel();
        lblIdInstitucion = new javax.swing.JLabel();
        txtIdInstitucion = new javax.swing.JTextField();
        lblInstitucion = new javax.swing.JLabel();
        txtInstitucion = new javax.swing.JTextField();
        btnBorrarInstitucion = new javax.swing.JButton();
        btnEditarInstitucion = new javax.swing.JButton();
        btnCrearInstitucion = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblInstitucion = new javax.swing.JTable();
        JPTitulo = new javax.swing.JPanel();
        lblIdTitulo = new javax.swing.JLabel();
        txtIdTitulo = new javax.swing.JTextField();
        lblNombreTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnBorrarTitulo = new javax.swing.JButton();
        btnEditarTitulo = new javax.swing.JButton();
        btnCrearTitulo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTitulos = new javax.swing.JTable();
        JPEstado = new javax.swing.JPanel();
        lblIdEstado = new javax.swing.JLabel();
        txtIdEstado = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnBorrarEstado = new javax.swing.JButton();
        btnEditarEstado = new javax.swing.JButton();
        btnCrearEstado = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblEstados = new javax.swing.JTable();
        JPDireccion = new javax.swing.JPanel();
        lblIdDir = new javax.swing.JLabel();
        txtIdDir = new javax.swing.JTextField();
        lblDir = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        btnBorrarDir = new javax.swing.JButton();
        btnEditarDir = new javax.swing.JButton();
        btnCrearDir = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDir = new javax.swing.JTable();
        JPTelefono = new javax.swing.JPanel();
        lblIdTelefono = new javax.swing.JLabel();
        txtIdTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnBorrarTelefono = new javax.swing.JButton();
        btnEditarTelefono = new javax.swing.JButton();
        btnCrearTelefono = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        JPTipo = new javax.swing.JPanel();
        lblIdTipo = new javax.swing.JLabel();
        txtIdTipo = new javax.swing.JTextField();
        lblNombreTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        btnBorrarTipo = new javax.swing.JButton();
        btnEditarTipo = new javax.swing.JButton();
        btnCrearTipo = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTipos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Gestor de Funcionarios");

        lblSexo.setText("SEXO");

        cbxSexos.setToolTipText("");
        cbxSexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexosActionPerformed(evt);
            }
        });

        lblEstadoCiv.setText("ESTADO CIVIL");

        cbxEstadoCiv.setToolTipText("");
        cbxEstadoCiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoCivActionPerformed(evt);
            }
        });

        lblDireccion.setText("DIRECCION");

        cbxDireccion.setToolTipText("");
        cbxDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDireccionActionPerformed(evt);
            }
        });

        lblTel.setText("TELEFONO");

        cbxTelefonos.setToolTipText("");
        cbxTelefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTelefonosActionPerformed(evt);
            }
        });

        lblTipoDoc.setText("TIPO DE DOCUMENTO");

        cbxTipoDoc.setToolTipText("");
        cbxTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoDocActionPerformed(evt);
            }
        });

        lblNumeroDoc.setText("NUMERO DE DOCUMENTO");

        txtNumDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDocActionPerformed(evt);
            }
        });

        lblNumeroDoc1.setText("NOMBRES");

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        lblNumeroDoc2.setText("APELLIDOS");

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        lblNumeroDoc3.setText("FECHA DE NACIMIENTO");

        jDateFechaNac.setDateFormatString("y MMM d");

        tblPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPersonaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblPersona);

        btnCrearPersona.setText("Crear");
        btnCrearPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPersonaActionPerformed(evt);
            }
        });

        btnBorrarPersona.setText("Borrar");

        btnActualizarPersona.setText("Actualizar");

        lblNumeroDoc4.setText("ID PERSONA");

        txtIdPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPPersonasLayout = new javax.swing.GroupLayout(JPPersonas);
        JPPersonas.setLayout(JPPersonasLayout);
        JPPersonasLayout.setHorizontalGroup(
            JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPersonasLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSexo)
                    .addComponent(cbxSexos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroDoc4)
                    .addComponent(txtIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPPersonasLayout.createSequentialGroup()
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoCiv)
                            .addComponent(cbxEstadoCiv, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(cbxDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTel)
                            .addComponent(cbxTelefonos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipoDoc)
                            .addComponent(cbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPPersonasLayout.createSequentialGroup()
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumeroDoc1)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumeroDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateFechaNac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPPersonasLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblNumeroDoc3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnCrearPersona)))
                .addGap(6, 6, 6)
                .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPPersonasLayout.createSequentialGroup()
                        .addComponent(btnActualizarPersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarPersona))
                    .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNumeroDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        JPPersonasLayout.setVerticalGroup(
            JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPersonasLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPPersonasLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxSexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPPersonasLayout.createSequentialGroup()
                        .addComponent(lblEstadoCiv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxEstadoCiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPPersonasLayout.createSequentialGroup()
                        .addComponent(lblDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPPersonasLayout.createSequentialGroup()
                        .addComponent(lblTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTelefonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPPersonasLayout.createSequentialGroup()
                            .addComponent(lblTipoDoc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JPPersonasLayout.createSequentialGroup()
                            .addComponent(lblNumeroDoc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(JPPersonasLayout.createSequentialGroup()
                            .addComponent(lblNumeroDoc1)
                            .addGap(27, 27, 27))
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPPersonasLayout.createSequentialGroup()
                        .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroDoc3)
                            .addComponent(lblNumeroDoc2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCrearPersona)
                        .addComponent(btnActualizarPersona)
                        .addComponent(btnBorrarPersona))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(JPPersonasLayout.createSequentialGroup()
                            .addComponent(lblNumeroDoc4)
                            .addGap(27, 27, 27))
                        .addComponent(txtIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Persona", JPPersonas);

        lblNivelEst.setText("Nivel de Estudios");

        lblInstituciones.setText("Institucion de Estudios");

        cbxInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxInstitucionesActionPerformed(evt);
            }
        });

        lblTitulo.setText("Titulo Academico");

        cbxTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTituloActionPerformed(evt);
            }
        });

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFuncionarioMousePressed(evt);
            }
        });
        jScrollPane11.setViewportView(tblFuncionario);

        jLabel3.setText("Personas");

        jLabel4.setText("ID Funcionario");

        btnCrearFuncionario.setText("Crear");
        btnCrearFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFuncionarioActionPerformed(evt);
            }
        });

        btnActualizarFuncionario.setText("Actualizar");

        btnBorrarFuncionario.setText("Borrar");
        btnBorrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(46, 46, 46)
                        .addComponent(cbxTitulo, 0, 179, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInstituciones)
                            .addComponent(lblNivelEst))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxNivelEst, 0, 179, Short.MAX_VALUE)
                            .addComponent(cbxInstituciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdNivelEst, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdInst, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdTituloAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdPers, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnCrearFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarFuncionario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivelEst)
                    .addComponent(cbxNivelEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdNivelEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstituciones)
                    .addComponent(cbxInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCrearFuncionario)
                        .addComponent(txtIdTituloAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizarFuncionario)
                        .addComponent(btnBorrarFuncionario))
                    .addComponent(lblTitulo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Funcionarios", jPanel1);

        cbxRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolesActionPerformed(evt);
            }
        });

        jLabel2.setText("ROL");

        tblGrupoFamiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblGrupoFamiliar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblGrupoFamiliarMousePressed(evt);
            }
        });
        jScrollPane12.setViewportView(tblGrupoFamiliar);

        jLabel5.setText("PERSONAS");

        btnAddPerGrup.setText("Añadir ");
        btnAddPerGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPerGrupActionPerformed(evt);
            }
        });

        jButton5.setText("Actualizar");

        jButton6.setText("Borrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("FUNCIONARIO");

        jLabel7.setText("ID GRUPO FAMILIAR");

        javax.swing.GroupLayout JPGrupoFamiliarLayout = new javax.swing.GroupLayout(JPGrupoFamiliar);
        JPGrupoFamiliar.setLayout(JPGrupoFamiliarLayout);
        JPGrupoFamiliarLayout.setHorizontalGroup(
            JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPGrupoFamiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPGrupoFamiliarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddPerGrup)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addGroup(JPGrupoFamiliarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbxPersonas1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdPers1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPGrupoFamiliarLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        JPGrupoFamiliarLayout.setVerticalGroup(
            JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPGrupoFamiliarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxPersonas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddPerGrup)
                        .addComponent(jButton5)
                        .addComponent(jButton6))
                    .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(456, Short.MAX_VALUE))
            .addGroup(JPGrupoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPGrupoFamiliarLayout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );

        JPFuncionarios.addTab("Grupo Familiar", JPGrupoFamiliar);

        txtIdSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdSexoActionPerformed(evt);
            }
        });

        lblIdSexo.setText("ID");

        txtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoActionPerformed(evt);
            }
        });

        lblNombreSexo.setText("SEXO");

        btnEditarSexo.setText("Editar");

        btnCrearSexo.setText("Crear");
        btnCrearSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSexoActionPerformed(evt);
            }
        });

        btnBorrarSexo.setText("Borrar");

        tblSexos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSexos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSexosMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblSexos);

        javax.swing.GroupLayout JPSexosLayout = new javax.swing.GroupLayout(JPSexos);
        JPSexos.setLayout(JPSexosLayout);
        JPSexosLayout.setHorizontalGroup(
            JPSexosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPSexosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPSexosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPSexosLayout.createSequentialGroup()
                        .addComponent(btnCrearSexo)
                        .addGap(56, 56, 56)
                        .addComponent(btnEditarSexo)
                        .addGap(49, 49, 49)
                        .addComponent(btnBorrarSexo))
                    .addGroup(JPSexosLayout.createSequentialGroup()
                        .addComponent(lblIdSexo)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblNombreSexo)
                        .addGap(33, 33, 33)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        JPSexosLayout.setVerticalGroup(
            JPSexosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPSexosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPSexosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPSexosLayout.createSequentialGroup()
                        .addGroup(JPSexosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdSexo)
                            .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreSexo))
                        .addGap(18, 18, 18)
                        .addGroup(JPSexosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearSexo)
                            .addComponent(btnEditarSexo)
                            .addComponent(btnBorrarSexo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Sexos", JPSexos);

        txtIdRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRolActionPerformed(evt);
            }
        });

        txtNombreRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRolActionPerformed(evt);
            }
        });

        lblIdRol.setText("ID");

        lblNombreRol.setText("ROL");

        btnCrearRol.setText("Crear");
        btnCrearRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRolActionPerformed(evt);
            }
        });

        btnEditarRol.setText("Editar");
        btnEditarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarRolActionPerformed(evt);
            }
        });

        btnBorrarRol.setText("Borrar");
        btnBorrarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarRolActionPerformed(evt);
            }
        });

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRoles);

        javax.swing.GroupLayout JPRolesLayout = new javax.swing.GroupLayout(JPRoles);
        JPRoles.setLayout(JPRolesLayout);
        JPRolesLayout.setHorizontalGroup(
            JPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPRolesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPRolesLayout.createSequentialGroup()
                        .addComponent(btnCrearRol)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditarRol)
                        .addGap(44, 44, 44)
                        .addComponent(btnBorrarRol))
                    .addGroup(JPRolesLayout.createSequentialGroup()
                        .addComponent(lblIdRol)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblNombreRol)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPRolesLayout.setVerticalGroup(
            JPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPRolesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPRolesLayout.createSequentialGroup()
                        .addGroup(JPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdRol)
                            .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreRol))
                        .addGap(18, 18, 18)
                        .addGroup(JPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearRol)
                            .addComponent(btnEditarRol)
                            .addComponent(btnBorrarRol)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Roles", JPRoles);

        lblIdNivel.setText("ID");

        txtIdNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNivelActionPerformed(evt);
            }
        });

        lblNivel.setText("NIVEL DE ESTUDIO");

        txtNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNivelActionPerformed(evt);
            }
        });

        btnBorrarNivel.setText("Borrar");
        btnBorrarNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarNivelActionPerformed(evt);
            }
        });

        btnEditarNivel.setText("Editar");
        btnEditarNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNivelActionPerformed(evt);
            }
        });

        btnCrearNivel.setText("Crear");
        btnCrearNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearNivelActionPerformed(evt);
            }
        });

        tblNivel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNivelMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblNivel);

        javax.swing.GroupLayout JPNivelLayout = new javax.swing.GroupLayout(JPNivel);
        JPNivel.setLayout(JPNivelLayout);
        JPNivelLayout.setHorizontalGroup(
            JPNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNivelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPNivelLayout.createSequentialGroup()
                        .addComponent(btnCrearNivel)
                        .addGap(85, 85, 85)
                        .addComponent(btnEditarNivel))
                    .addGroup(JPNivelLayout.createSequentialGroup()
                        .addComponent(lblIdNivel)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblNivel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarNivel))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPNivelLayout.setVerticalGroup(
            JPNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNivelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNivelLayout.createSequentialGroup()
                        .addGroup(JPNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdNivel)
                            .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNivel))
                        .addGap(18, 18, 18)
                        .addGroup(JPNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearNivel)
                            .addComponent(btnEditarNivel)
                            .addComponent(btnBorrarNivel)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Nivel Estudios", JPNivel);

        lblIdInstitucion.setText("ID");

        txtIdInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdInstitucionActionPerformed(evt);
            }
        });

        lblInstitucion.setText("INSTITUCION DE ESTUDIO");

        txtInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInstitucionActionPerformed(evt);
            }
        });

        btnBorrarInstitucion.setText("Borrar");
        btnBorrarInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarInstitucionActionPerformed(evt);
            }
        });

        btnEditarInstitucion.setText("Editar");
        btnEditarInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarInstitucionActionPerformed(evt);
            }
        });

        btnCrearInstitucion.setText("Crear");
        btnCrearInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearInstitucionActionPerformed(evt);
            }
        });

        tblInstitucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblInstitucion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblInstitucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInstitucionMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblInstitucion);

        javax.swing.GroupLayout JPInstitucionLayout = new javax.swing.GroupLayout(JPInstitucion);
        JPInstitucion.setLayout(JPInstitucionLayout);
        JPInstitucionLayout.setHorizontalGroup(
            JPInstitucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInstitucionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPInstitucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInstitucionLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnCrearInstitucion)
                        .addGap(85, 85, 85)
                        .addComponent(btnEditarInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(btnBorrarInstitucion)
                        .addGap(46, 46, 46))
                    .addGroup(JPInstitucionLayout.createSequentialGroup()
                        .addComponent(lblIdInstitucion)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInstitucion)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPInstitucionLayout.setVerticalGroup(
            JPInstitucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInstitucionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPInstitucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInstitucionLayout.createSequentialGroup()
                        .addGroup(JPInstitucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdInstitucion)
                            .addComponent(txtInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInstitucion))
                        .addGap(18, 18, 18)
                        .addGroup(JPInstitucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearInstitucion)
                            .addComponent(btnEditarInstitucion)
                            .addComponent(btnBorrarInstitucion)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Institucion de Estudios", JPInstitucion);

        lblIdTitulo.setText("ID");

        txtIdTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTituloActionPerformed(evt);
            }
        });

        lblNombreTitulo.setText("TITULO ACADEMICO");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        btnBorrarTitulo.setText("Borrar");
        btnBorrarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTituloActionPerformed(evt);
            }
        });

        btnEditarTitulo.setText("Editar");
        btnEditarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTituloActionPerformed(evt);
            }
        });

        btnCrearTitulo.setText("Crear");
        btnCrearTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTituloActionPerformed(evt);
            }
        });

        tblTitulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTitulos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTitulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTitulosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTitulos);

        javax.swing.GroupLayout JPTituloLayout = new javax.swing.GroupLayout(JPTitulo);
        JPTitulo.setLayout(JPTituloLayout);
        JPTituloLayout.setHorizontalGroup(
            JPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTituloLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTituloLayout.createSequentialGroup()
                        .addComponent(lblIdTitulo)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombreTitulo))
                    .addGroup(JPTituloLayout.createSequentialGroup()
                        .addComponent(btnCrearTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(btnEditarTitulo)))
                .addGap(26, 26, 26)
                .addGroup(JPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTituloLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnBorrarTitulo)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPTituloLayout.createSequentialGroup()
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPTituloLayout.setVerticalGroup(
            JPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTituloLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTituloLayout.createSequentialGroup()
                        .addGroup(JPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdTitulo)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreTitulo))
                        .addGap(18, 18, 18)
                        .addGroup(JPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearTitulo)
                            .addComponent(btnEditarTitulo)
                            .addComponent(btnBorrarTitulo)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Titulo Academico", JPTitulo);

        lblIdEstado.setText("ID");

        txtIdEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEstadoActionPerformed(evt);
            }
        });

        lblEstado.setText("ESTADO CIVIL");

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        btnBorrarEstado.setText("Borrar");
        btnBorrarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarEstadoActionPerformed(evt);
            }
        });

        btnEditarEstado.setText("Editar");
        btnEditarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEstadoActionPerformed(evt);
            }
        });

        btnCrearEstado.setText("Crear");
        btnCrearEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEstadoActionPerformed(evt);
            }
        });

        tblEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEstados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblEstadosMouseEntered(evt);
            }
        });
        jScrollPane8.setViewportView(tblEstados);

        javax.swing.GroupLayout JPEstadoLayout = new javax.swing.GroupLayout(JPEstado);
        JPEstado.setLayout(JPEstadoLayout);
        JPEstadoLayout.setHorizontalGroup(
            JPEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPEstadoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPEstadoLayout.createSequentialGroup()
                        .addComponent(lblIdEstado)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE))
                    .addGroup(JPEstadoLayout.createSequentialGroup()
                        .addComponent(btnCrearEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarEstado)
                        .addGap(26, 26, 26)))
                .addGroup(JPEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPEstadoLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnBorrarEstado)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPEstadoLayout.createSequentialGroup()
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPEstadoLayout.setVerticalGroup(
            JPEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPEstadoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPEstadoLayout.createSequentialGroup()
                        .addGroup(JPEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdEstado)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstado))
                        .addGap(18, 18, 18)
                        .addGroup(JPEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearEstado)
                            .addComponent(btnEditarEstado)
                            .addComponent(btnBorrarEstado)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Estado Civil", JPEstado);

        lblIdDir.setText("ID");

        txtIdDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDirActionPerformed(evt);
            }
        });

        lblDir.setText("DIRECCION");

        txtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirActionPerformed(evt);
            }
        });

        btnBorrarDir.setText("Borrar");
        btnBorrarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDirActionPerformed(evt);
            }
        });

        btnEditarDir.setText("Editar");
        btnEditarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDirActionPerformed(evt);
            }
        });

        btnCrearDir.setText("Crear");
        btnCrearDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDirActionPerformed(evt);
            }
        });

        tblDir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDirMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblDir);

        javax.swing.GroupLayout JPDireccionLayout = new javax.swing.GroupLayout(JPDireccion);
        JPDireccion.setLayout(JPDireccionLayout);
        JPDireccionLayout.setHorizontalGroup(
            JPDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPDireccionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPDireccionLayout.createSequentialGroup()
                        .addComponent(lblIdDir)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdDir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblDir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE))
                    .addGroup(JPDireccionLayout.createSequentialGroup()
                        .addComponent(btnCrearDir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarDir)
                        .addGap(26, 26, 26)))
                .addGroup(JPDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPDireccionLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnBorrarDir)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPDireccionLayout.createSequentialGroup()
                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPDireccionLayout.setVerticalGroup(
            JPDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPDireccionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPDireccionLayout.createSequentialGroup()
                        .addGroup(JPDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdDir)
                            .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDir))
                        .addGap(18, 18, 18)
                        .addGroup(JPDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearDir)
                            .addComponent(btnEditarDir)
                            .addComponent(btnBorrarDir)))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Direccion", JPDireccion);

        lblIdTelefono.setText("ID");

        txtIdTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTelefonoActionPerformed(evt);
            }
        });

        lblTelefono.setText("TELEFONO");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        btnBorrarTelefono.setText("Borrar");
        btnBorrarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTelefonoActionPerformed(evt);
            }
        });

        btnEditarTelefono.setText("Editar");
        btnEditarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTelefonoActionPerformed(evt);
            }
        });

        btnCrearTelefono.setText("Crear");
        btnCrearTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTelefonoActionPerformed(evt);
            }
        });

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTelefonos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblTelefonos);

        javax.swing.GroupLayout JPTelefonoLayout = new javax.swing.GroupLayout(JPTelefono);
        JPTelefono.setLayout(JPTelefonoLayout);
        JPTelefonoLayout.setHorizontalGroup(
            JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTelefonoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPTelefonoLayout.createSequentialGroup()
                        .addComponent(btnCrearTelefono)
                        .addGap(85, 85, 85)
                        .addComponent(btnEditarTelefono))
                    .addGroup(JPTelefonoLayout.createSequentialGroup()
                        .addComponent(lblIdTelefono)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblTelefono)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarTelefono))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPTelefonoLayout.setVerticalGroup(
            JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTelefonoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTelefonoLayout.createSequentialGroup()
                        .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono))
                        .addGap(18, 18, 18)
                        .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearTelefono)
                            .addComponent(btnEditarTelefono)
                            .addComponent(btnBorrarTelefono)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Telefonos", JPTelefono);

        lblIdTipo.setText("ID");

        txtIdTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTipoActionPerformed(evt);
            }
        });

        lblNombreTipo.setText("TIPO DOCUMENTO");

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        btnBorrarTipo.setText("Borrar");
        btnBorrarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTipoActionPerformed(evt);
            }
        });

        btnEditarTipo.setText("Editar");
        btnEditarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTipoActionPerformed(evt);
            }
        });

        btnCrearTipo.setText("Crear");
        btnCrearTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTipoActionPerformed(evt);
            }
        });

        tblTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTipos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiposMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTipos);

        javax.swing.GroupLayout JPTipoLayout = new javax.swing.GroupLayout(JPTipo);
        JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(
            JPTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTipoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPTipoLayout.createSequentialGroup()
                        .addComponent(btnCrearTipo)
                        .addGap(85, 85, 85)
                        .addComponent(btnEditarTipo))
                    .addGroup(JPTipoLayout.createSequentialGroup()
                        .addComponent(lblIdTipo)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblNombreTipo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarTipo))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        JPTipoLayout.setVerticalGroup(
            JPTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTipoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTipoLayout.createSequentialGroup()
                        .addGroup(JPTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdTipo)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreTipo))
                        .addGap(18, 18, 18)
                        .addGroup(JPTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearTipo)
                            .addComponent(btnEditarTipo)
                            .addComponent(btnBorrarTipo)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        JPFuncionarios.addTab("Tipo Documento", JPTipo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPFuncionarios)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPFuncionarios)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRolActionPerformed

    private void txtNombreRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRolActionPerformed

    private void tblRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesMouseClicked
        int rowRolSelected = tblRoles.rowAtPoint(evt.getPoint());
        
        txtIdRol.setText(tblRoles.getValueAt(rowRolSelected, 0).toString());
        txtNombreRol.setText(tblRoles.getValueAt(rowRolSelected, 1).toString());
    }//GEN-LAST:event_tblRolesMouseClicked

    private void cbxRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolesActionPerformed

    private void btnCrearRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRolActionPerformed
        
        if(txtNombreRol.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite Rol");
           txtNombreRol.requestFocus();
           return;
        }
        
        Rol rol = new Rol();
        rol.setNombreRol(txtNombreRol.getText().trim());
        
        try{
            rolController.crearRol(rol);
            txtNombreRol.setText("");
            listRoles();
            JOptionPane.showMessageDialog(null, "Rol creado con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Rol no pudo ser creado");
        }
        
    }//GEN-LAST:event_btnCrearRolActionPerformed

    private void btnEditarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarRolActionPerformed
        
        if(txtIdRol.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Seleccione un rol de la lista");
            txtIdRol.requestFocus();
            return;
        }
        
        if (txtNombreRol.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite rol");
            txtNombreRol.requestFocus();
            return;
        }
        
        Rol rol = new Rol();
        rol.setNombreRol(txtNombreRol.getText().trim());
        

        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el rol", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(opt == 0){
            try{
                rolController.actualizarRol(Integer.parseInt(txtIdRol.getText()), rol);
                txtIdRol.setText("");
                txtNombreRol.setText("");
                listRoles();
                JOptionPane.showMessageDialog(null, "Se ha Actualizado el rol con éxito");
            }catch(SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fué posible crear el rol");
            }
        }
        
        
        
    }//GEN-LAST:event_btnEditarRolActionPerformed

    private void btnBorrarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarRolActionPerformed
         if (txtIdRol.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar un rol de la Lista");
            txtIdRol.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "Está seguro de borrar rol", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {
            try {
                rolController.eliminarRol(Integer.parseInt(txtIdRol.getText()));
                txtIdRol.setText("");
                txtNombreRol.setText("");                
                listRoles();
                JOptionPane.showMessageDialog(null, "Se eliminó rol correctamente");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo Eliminar rol");
            }
        }
    }//GEN-LAST:event_btnBorrarRolActionPerformed

    private void txtIdTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTituloActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnBorrarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarTituloActionPerformed

    private void btnEditarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarTituloActionPerformed

    private void btnCrearTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTituloActionPerformed
        
         if(txtTitulo.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite el Titulo Academico");
           txtTitulo.requestFocus();
           return;
        }
        
        TituloAcademico titulo = new TituloAcademico();
        titulo.setTitulo(txtTitulo.getText().trim());
        
        try{
            tituloAcademicoController.crearTituloAcademico(titulo);
            txtTitulo.setText("");
            listTitulos();
            JOptionPane.showMessageDialog(null, "Titulo Academico creado con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Titulo Academico no pudo ser creado");
        }
    }//GEN-LAST:event_btnCrearTituloActionPerformed

    private void tblTitulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTitulosMouseClicked
        int rowInstSelected = tblTitulos.rowAtPoint(evt.getPoint());
        
        txtIdTitulo.setText(tblTitulos.getValueAt(rowInstSelected, 0).toString());
        txtTitulo.setText(tblTitulos.getValueAt(rowInstSelected, 1).toString());
    }//GEN-LAST:event_tblTitulosMouseClicked

    private void txtIdTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTipoActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void btnBorrarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarTipoActionPerformed

    private void btnEditarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarTipoActionPerformed

    private void btnCrearTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTipoActionPerformed
       
        if(txtTipo.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite el Tipo de Documento");
           txtTipo.requestFocus();
           return;
        }
        
        TipoDocumento tipo = new TipoDocumento();
        tipo.setTipoDoc(txtTipo.getText().trim());
        
        try{
            tipoDocumentoController.crearTipoDocumento(tipo);
            txtTipo.setText("");
            listTipoDoc();
            JOptionPane.showMessageDialog(null, "Tipo de Documento creado con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tipo de Documento no pudo ser creado");
        }
    }//GEN-LAST:event_btnCrearTipoActionPerformed

    private void tblTiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiposMouseClicked
        int rowSelected = tblTipos.rowAtPoint(evt.getPoint());
        
        txtIdTipo.setText(tblTipos.getValueAt(rowSelected, 0).toString());
        txtTipo.setText(tblTipos.getValueAt(rowSelected, 1).toString());
    }//GEN-LAST:event_tblTiposMouseClicked

    private void txtIdTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTelefonoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnBorrarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarTelefonoActionPerformed

    private void btnEditarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarTelefonoActionPerformed

    private void btnCrearTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTelefonoActionPerformed
       
        if(txtTelefono.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite el Telefono");
           txtTelefono.requestFocus();
           return;
        }
        
        Telefono tel = new Telefono();
        tel.setTelefono(txtTelefono.getText().trim());
        
        try{
            telefonoController.crearTelefono(tel);
            txtTelefono.setText("");
            listTelefonos();
            JOptionPane.showMessageDialog(null, "Telefono creado con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Telefono no pudo ser creado");
        }
    }//GEN-LAST:event_btnCrearTelefonoActionPerformed

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
       int rowSelected = tblTelefonos.rowAtPoint(evt.getPoint());
        
        txtIdTelefono.setText(tblTelefonos.getValueAt(rowSelected, 0).toString());
        txtTelefono.setText(tblTelefonos.getValueAt(rowSelected, 1).toString());
    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void txtIdNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNivelActionPerformed

    private void txtNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNivelActionPerformed

    private void btnBorrarNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarNivelActionPerformed

    private void btnEditarNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarNivelActionPerformed

    private void btnCrearNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearNivelActionPerformed
        
        if(txtNivel.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite Nivel de Estudios");
           txtNivel.requestFocus();
           return;
        }
        
        NivelEstudios nivel = new NivelEstudios();
        nivel.setNivelEst(txtNivel.getText().trim());
        
        try{
            nivelEstudiosController.crearNivelEstudio(nivel);
            txtNivel.setText("");
            listNivelEstudios();
            JOptionPane.showMessageDialog(null, "Nivel de Estudios creado con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nivel de Estudios no pudo ser creado");
        }
    }//GEN-LAST:event_btnCrearNivelActionPerformed

    private void tblNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNivelMouseClicked
        int rowNivelSelected = tblNivel.rowAtPoint(evt.getPoint());
        
        txtIdNivel.setText(tblNivel.getValueAt(rowNivelSelected, 0).toString());
        txtNivel.setText(tblNivel.getValueAt(rowNivelSelected, 1).toString());
    }//GEN-LAST:event_tblNivelMouseClicked

    private void txtIdInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdInstitucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdInstitucionActionPerformed

    private void txtInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInstitucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInstitucionActionPerformed

    private void btnBorrarInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarInstitucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarInstitucionActionPerformed

    private void btnEditarInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarInstitucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarInstitucionActionPerformed

    private void btnCrearInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearInstitucionActionPerformed
       
        if(txtInstitucion.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite la Institucion de Estudios");
           txtInstitucion.requestFocus();
           return;
        }
        
        InstitucionEstudios inst = new InstitucionEstudios();
        inst.setInstitucion(txtInstitucion.getText().trim());
        
        try{
            institucionEstudioController.crearInstitucionEstudios(inst);
            txtInstitucion.setText("");
            listInstituciones();
            JOptionPane.showMessageDialog(null, "Institucion de Estudios creada con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Institucion de Estudios no pudo ser creada");
        }
    }//GEN-LAST:event_btnCrearInstitucionActionPerformed

    private void tblInstitucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInstitucionMouseClicked
        int rowInstSelected = tblInstitucion.rowAtPoint(evt.getPoint());
        
        txtIdInstitucion.setText(tblInstitucion.getValueAt(rowInstSelected, 0).toString());
        txtInstitucion.setText(tblInstitucion.getValueAt(rowInstSelected, 1).toString());
    }//GEN-LAST:event_tblInstitucionMouseClicked

    private void txtIdEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEstadoActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void btnBorrarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarEstadoActionPerformed

    private void btnEditarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarEstadoActionPerformed

    private void btnCrearEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEstadoActionPerformed
       
        if(txtEstado.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite el Estado Civil");
           txtEstado.requestFocus();
           return;
        }
        
        EstadoCivil estado = new EstadoCivil();
        estado.setEstado(txtEstado.getText().trim());
        
        try{
            estadoCivilController.crearEstadoCivil(estado);
            txtEstado.setText("");
            listEstados();
            JOptionPane.showMessageDialog(null, "Estado Civil creado con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Estado Civil no pudo ser creado");
        }
    }//GEN-LAST:event_btnCrearEstadoActionPerformed

    private void tblEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosMouseClicked
        int rowInstSelected = tblEstados.rowAtPoint(evt.getPoint());
        
        txtIdEstado.setText(tblEstados.getValueAt(rowInstSelected, 0).toString());
        txtEstado.setText(tblEstados.getValueAt(rowInstSelected, 1).toString());
    }//GEN-LAST:event_tblEstadosMouseClicked

    private void txtIdDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDirActionPerformed

    private void txtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirActionPerformed

    private void btnBorrarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarDirActionPerformed

    private void btnEditarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarDirActionPerformed

    private void btnCrearDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDirActionPerformed
        
        if(txtDir.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite Direccion");
           txtDir.requestFocus();
           return;
        }
        
        Direccion dir = new Direccion();
        dir.setDireccion(txtDir.getText().trim());
        
        try{
            direccionController.crearDireccion(dir);
            txtDir.setText("");
            listDirecciones();
            JOptionPane.showMessageDialog(null, "Direccion creada con exito");
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Direccion no pudo ser creada");
        }
    }//GEN-LAST:event_btnCrearDirActionPerformed

    private void tblDirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDirMouseClicked
       int rowSelected = tblDir.rowAtPoint(evt.getPoint());
        
        txtIdDir.setText(tblDir.getValueAt(rowSelected, 0).toString());
        txtDir.setText(tblDir.getValueAt(rowSelected, 1).toString());
    }//GEN-LAST:event_tblDirMouseClicked

    private void cbxSexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexosActionPerformed
       
    }//GEN-LAST:event_cbxSexosActionPerformed

    private void btnCrearSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSexoActionPerformed
       
        if(txtSexo.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite Sexo");
           txtSexo.requestFocus();
           return;
        }
        
        Sexo sex = new Sexo();
        sex.setSexo(txtSexo.getText().trim());
        
        try{
            sexoController.crearSexo(sex);
            txtSexo.setText("");
            listSexos();
            JOptionPane.showMessageDialog(null, "Sexo creado con exito");
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sexo no pudo ser creado");
        }
        
        
    }//GEN-LAST:event_btnCrearSexoActionPerformed

    private void tblSexosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSexosMouseClicked
        int rowSexSelected = tblSexos.rowAtPoint(evt.getPoint());
        
        txtIdSexo.setText(tblSexos.getValueAt(rowSexSelected, 0).toString());
        txtSexo.setText(tblSexos.getValueAt(rowSexSelected, 1).toString());
        
    }//GEN-LAST:event_tblSexosMouseClicked

    private void cbxInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxInstitucionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxInstitucionesActionPerformed

    private void cbxTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTituloActionPerformed

    private void cbxEstadoCivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoCivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoCivActionPerformed

    private void tblEstadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEstadosMouseEntered

    private void cbxDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDireccionActionPerformed

    private void cbxTelefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTelefonosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTelefonosActionPerformed

    private void cbxTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoDocActionPerformed

    private void txtNumDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDocActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnCrearPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPersonaActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateFechaNac.getDate());

        if(txtNumDoc.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite el Numero de documeto");
           txtSexo.requestFocus();
           return;
        }
        if(txtNombres.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite los nombres");
           txtSexo.requestFocus();
           return;
        }
        if(txtApellidos.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Digite los apellidos");
           txtSexo.requestFocus();
           return;
        }
        
        
        Persona per = new Persona();
        // per.setIdSexo(cbxSexos.getText().trim());
        
        try{
            personaController.crearPersona(per);
            txtSexo.setText("");
            listPersonas();
            JOptionPane.showMessageDialog(null, "Sexo creado con exito");
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sexo no pudo ser creado");
        }    }//GEN-LAST:event_btnCrearPersonaActionPerformed

    private void tblPersonaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonaMousePressed
        int rowSelected = tblPersona.rowAtPoint(evt.getPoint()); 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateFechaNac.getDate());
        Sexo sex = new Sexo();
        sex.setSexo(tblPersona.getValueAt(rowSelected, 6).toString());
        System.out.println(sex.getSexo());
        cbxSexos.getSelectedItem();
        cbxSexos.setSelectedItem(sex.getSexo());
        // cbxDireccion.
        // cbxTelefonos.
        // cbxTipoDoc
        txtIdPersona.setText(tblPersona.getValueAt(rowSelected,0).toString());        
        txtNumDoc.setText(tblPersona.getValueAt(rowSelected, 1).toString());
        txtNombres.setText(tblPersona.getValueAt(rowSelected, 2).toString());
        txtApellidos.setText(tblPersona.getValueAt(rowSelected, 3).toString());
        
        
        
        
    }//GEN-LAST:event_tblPersonaMousePressed

    private void tblFuncionarioMousePressed(java.awt.event.MouseEvent evt){//GEN-FIRST:event_tblFuncionarioMousePressed
       int rowRolSelected = tblFuncionario.rowAtPoint(evt.getPoint());
       int idFuncionario = 0; 
       if(idFuncionario == 0){
        idFuncionario = Integer.parseInt(tblFuncionario.getValueAt(rowRolSelected,0).toString());
       }       
        obtenerFuncionario(funcionarioController, idFuncionario);
    }//GEN-LAST:event_tblFuncionarioMousePressed

    private void btnCrearFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearFuncionarioActionPerformed
         
        if(txtIdNivelEst.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Seleccione el nivel de estudios");
           txtIdNivelEst.requestFocus();
           return;
        }
        if(txtIdInst.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Seleccione la institucion educativa");
           txtIdInst.requestFocus();
           return;
        }
        if(txtIdTituloAcad.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Seleccione el titulo academico");
           txtIdTituloAcad.requestFocus();
           return;
        }
        if(txtIdPers.getText().trim().length()==0){
           JOptionPane.showMessageDialog(null, "Seleccione una persona ");
           txtIdPers.requestFocus();
           return;
        }
        
        Funcionarios funcionario = new Funcionarios();
        funcionario.setIdnivelEst(txtIdNivelEst.getText().trim());
        funcionario.setIdInstEst(txtIdInst.getText().trim());
        funcionario.setIdTituloAcad(txtIdTituloAcad.getText().trim());
        funcionario.setIdPersona(txtIdPers.getText().trim());

        
        try{
            funcionarioController.crearFuncionario(funcionario);
            txtIdNivelEst.setText("");
            txtIdInst.setText("");
            txtIdTituloAcad.setText("");
            txtIdPers.setText("");
            listFuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionarios creado con exito");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Funcionarios no pudo ser creado");
        }
        
    }//GEN-LAST:event_btnCrearFuncionarioActionPerformed

    private void tblGrupoFamiliarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGrupoFamiliarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGrupoFamiliarMousePressed

    private void btnAddPerGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPerGrupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPerGrupActionPerformed

    private void txtIdPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPersonaActionPerformed

    private void btnBorrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarFuncionarioActionPerformed
        if (txtIdFunc.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar un funcionario de la lista");
            txtIdFunc.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "Está seguro de borrar el funcionario", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {
            try {
            funcionarioController.eliminarFuncionario(Integer.parseInt(txtIdFunc.getText()));
            txtIdNivelEst.setText("");
            txtIdInst.setText("");
            txtIdTituloAcad.setText("");
            txtIdPers.setText("");
                listFuncionarios();
                JOptionPane.showMessageDialog(null, "Se eliminó carro correctamente");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo Eliminar el funcionario");
            }
        }
      
    }//GEN-LAST:event_btnBorrarFuncionarioActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed
    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPDireccion;
    private javax.swing.JPanel JPEstado;
    private javax.swing.JTabbedPane JPFuncionarios;
    private javax.swing.JPanel JPGrupoFamiliar;
    private javax.swing.JPanel JPInstitucion;
    private javax.swing.JPanel JPNivel;
    private javax.swing.JPanel JPPersonas;
    private javax.swing.JPanel JPRoles;
    private javax.swing.JPanel JPSexos;
    private javax.swing.JPanel JPTelefono;
    private javax.swing.JPanel JPTipo;
    private javax.swing.JPanel JPTitulo;
    private javax.swing.JButton btnActualizarFuncionario;
    private javax.swing.JButton btnActualizarPersona;
    private javax.swing.JButton btnAddPerGrup;
    private javax.swing.JButton btnBorrarDir;
    private javax.swing.JButton btnBorrarEstado;
    private javax.swing.JButton btnBorrarFuncionario;
    private javax.swing.JButton btnBorrarInstitucion;
    private javax.swing.JButton btnBorrarNivel;
    private javax.swing.JButton btnBorrarPersona;
    private javax.swing.JButton btnBorrarRol;
    private javax.swing.JButton btnBorrarSexo;
    private javax.swing.JButton btnBorrarTelefono;
    private javax.swing.JButton btnBorrarTipo;
    private javax.swing.JButton btnBorrarTitulo;
    private javax.swing.JButton btnCrearDir;
    private javax.swing.JButton btnCrearEstado;
    private javax.swing.JButton btnCrearFuncionario;
    private javax.swing.JButton btnCrearInstitucion;
    private javax.swing.JButton btnCrearNivel;
    private javax.swing.JButton btnCrearPersona;
    private javax.swing.JButton btnCrearRol;
    private javax.swing.JButton btnCrearSexo;
    private javax.swing.JButton btnCrearTelefono;
    private javax.swing.JButton btnCrearTipo;
    private javax.swing.JButton btnCrearTitulo;
    private javax.swing.JButton btnEditarDir;
    private javax.swing.JButton btnEditarEstado;
    private javax.swing.JButton btnEditarInstitucion;
    private javax.swing.JButton btnEditarNivel;
    private javax.swing.JButton btnEditarRol;
    private javax.swing.JButton btnEditarSexo;
    private javax.swing.JButton btnEditarTelefono;
    private javax.swing.JButton btnEditarTipo;
    private javax.swing.JButton btnEditarTitulo;
    private javax.swing.JComboBox<Direccion> cbxDireccion;
    private javax.swing.JComboBox<EstadoCivil> cbxEstadoCiv;
    private javax.swing.JComboBox<Funcionarios> cbxFuncionarios;
    private javax.swing.JComboBox<InstitucionEstudios> cbxInstituciones;
    private javax.swing.JComboBox<NivelEstudios> cbxNivelEst;
    private javax.swing.JComboBox<Persona> cbxPersonas;
    private javax.swing.JComboBox<Persona> cbxPersonas1;
    private javax.swing.JComboBox<Rol> cbxRoles;
    private javax.swing.JComboBox<Sexo> cbxSexos;
    private javax.swing.JComboBox<Telefono> cbxTelefonos;
    private javax.swing.JComboBox<TipoDocumento> cbxTipoDoc;
    private javax.swing.JComboBox<TituloAcademico> cbxTitulo;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoCiv;
    private javax.swing.JLabel lblIdDir;
    private javax.swing.JLabel lblIdEstado;
    private javax.swing.JLabel lblIdInstitucion;
    private javax.swing.JLabel lblIdNivel;
    private javax.swing.JLabel lblIdRol;
    private javax.swing.JLabel lblIdSexo;
    private javax.swing.JLabel lblIdTelefono;
    private javax.swing.JLabel lblIdTipo;
    private javax.swing.JLabel lblIdTitulo;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblInstituciones;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNivelEst;
    private javax.swing.JLabel lblNombreRol;
    private javax.swing.JLabel lblNombreSexo;
    private javax.swing.JLabel lblNombreTipo;
    private javax.swing.JLabel lblNombreTitulo;
    private javax.swing.JLabel lblNumeroDoc;
    private javax.swing.JLabel lblNumeroDoc1;
    private javax.swing.JLabel lblNumeroDoc2;
    private javax.swing.JLabel lblNumeroDoc3;
    private javax.swing.JLabel lblNumeroDoc4;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoDoc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDir;
    private javax.swing.JTable tblEstados;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTable tblGrupoFamiliar;
    private javax.swing.JTable tblInstitucion;
    private javax.swing.JTable tblNivel;
    private javax.swing.JTable tblPersona;
    private javax.swing.JTable tblRoles;
    private javax.swing.JTable tblSexos;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTable tblTipos;
    private javax.swing.JTable tblTitulos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdDir;
    private javax.swing.JTextField txtIdEstado;
    private javax.swing.JTextField txtIdFunc;
    private javax.swing.JTextField txtIdFuncionario;
    private javax.swing.JTextField txtIdGrupo;
    private javax.swing.JTextField txtIdInst;
    private javax.swing.JTextField txtIdInstitucion;
    private javax.swing.JTextField txtIdNivel;
    private javax.swing.JTextField txtIdNivelEst;
    private javax.swing.JTextField txtIdPers;
    private javax.swing.JTextField txtIdPers1;
    private javax.swing.JTextField txtIdPersona;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtIdRoles;
    private javax.swing.JTextField txtIdSexo;
    private javax.swing.JTextField txtIdTelefono;
    private javax.swing.JTextField txtIdTipo;
    private javax.swing.JTextField txtIdTitulo;
    private javax.swing.JTextField txtIdTituloAcad;
    private javax.swing.JTextField txtInstitucion;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombreRol;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumDoc;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
