/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegiomedicos;

import herramientas.IdiomaESP;
import herramientas.Herramientas;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import eventos.hSocio.*;
import Atxy2k.CustomTextField.RestrictedTextField;
import eventos.hSocio;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class jdNuevoSocio extends javax.swing.JDialog {

    /**
     * Creates new form jdNuevoSocio
     */
    private byte[] imagen;
    Dimension dImagen = null;

    public jdNuevoSocio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle(IdiomaESP.tNuevoSocio);
        Herramientas.VentanaCentroWindows(this);
        this.requestFocusInWindow(true);
        this.requestFocusInWindow();
        jlbImagen.setIcon(new Herramientas().getIcono("/Recursos/User.png", jlbImagen.getWidth(), jlbImagen.getHeight()));
        jdFechaNac.setText("");
        dImagen = new Dimension(jlbImagen.getWidth(), jlbImagen.getHeight());
        jdCreacion.setText("");
    }

    public boolean vacio(JTextField _texto) {

        return _texto.getText().trim().isEmpty();
    }

    public boolean camposLlenos() {

        return (vacio(jtxtCodigo) || vacio(jtxtCedula) || vacio(jtxtNombres) || vacio(jtxtApMat) || vacio(jtxtApPat) || jdFechaNac.getSelectedDate() == null || jcbGrupoSanguineo.getSelectedIndex() == 0 || jcEstadoCivil1.getSelectedIndex() == 0 || (jcEstadoCivil1.getSelectedIndex() == 2 ? vacio(jtxtNombreConyugue) : false)
                || vacio(jtxtTitulo) || vacio(jtxtUniversidadGraduado) || vacio(jtxtLugarGraduacion) || jdFechaGraduacion.getSelectedDate() == null || vacio(jtxtInscripcionSanitaria) || vacio(jtxtRural) || jdFechaRural.getSelectedDate() == null
                || vacio(jtxtResidencia) || vacio(jtxtTelefonoResidencia) || vacio(jtxtCelular) || vacio(jtxtemail)
                || jcbEstado.getSelectedIndex() == 0 || vacio(jtxtLugar) || jdCreacion.getSelectedDate() == null);
    }

    public void vaciarCampos() {
        jtxtCodigo.setText("");
        jtxtApMat.setText("");
        jtxtApPat.setText("");
        jtxtCedula.setText("");
        jtxtCelular.setText("");
        jtxtCiudad.setText("");
        jtxtDireccionConsultorio.setText("");
        jtxtDireccionResidencia.setText("");
        jtxtEspacialidad.setText("");
        jtxtFolio.setText("");
        jtxtInscripcionSanitaria.setText("");
        jtxtLibro.setText("");
        jtxtFolio.setText("");
        jtxtLugar.setText(IdiomaESP.opLugar);
        jtxtLugarGraduacion.setText("");
        jtxtNombreConyugue.setText("");
        jtxtNombres.setText("");
        jtxtPais.setText("");
        jtxtProvincia.setText("");
        jtxtResidencia.setText("");
        jtxtRural.setText("");
        jtxtTelefonoConsultorio.setText("");
        jtxtTelefonoResidencia.setText("");
        jtxtTitulo.setText("");
        jtxtUniversidadEspecialidad.setText("");
        jtxtUniversidadGraduado.setText("");
        jtxtemail.setText("");
        jcEstadoCivil1.setSelectedIndex(0);
        jcbEstado.setSelectedIndex(0);
        jcbGrupoSanguineo.setSelectedIndex(0);
        jdCreacion.setSelectedDate(null);
        jdCreacion.setText("");
        jdFechaEspecialidad.setSelectedDate(null);
        jdFechaEspecialidad.setText("");
        jdFechaGraduacion.setSelectedDate(null);
        jdFechaGraduacion.setText("");
        jdFechaNac.setSelectedDate(null);
        jdFechaNac.setText("");
        jdFechaRural.setSelectedDate(null);
        jdFechaRural.setText("");
        imagen = null;
        jlbImagen.setIcon(new Herramientas().getIcono("/Recursos/User.png", dImagen.width, dImagen.height));
        jtxtCodigo.requestFocus();
    }

    public void guardar() {
        if(hSocio.codigoDublicado(jtxtCodigo.getText())){
            Herramientas.MensajeErr(IdiomaESP.mErCodigoDupSocio,IdiomaESP.tGuardarSocio);
            return;
        }
        if(hSocio.cedulaDublicado(jtxtCedula.getText())){
            Herramientas.MensajeErr(IdiomaESP.mErCedulaDupSocio,IdiomaESP.tGuardarSocio);
            return;
        }
        datosPersonales datos = new datosPersonales();
        datosEstudios estudios = new datosEstudios();
        datosContacto contacto = new datosContacto();

        datos.setApellidosMaternos(jtxtApMat.getText());
        datos.setApellidosPaternos(jtxtApPat.getText());
        datos.setCedula(jtxtCedula.getText());
        datos.setCiudad(jtxtCiudad.getText());
        datos.setCodigo(jtxtCodigo.getText());
        datos.setConyuge(jtxtNombreConyugue.getText());
        datos.setEstadoCivil(jcEstadoCivil1.getSelectedItem().toString());
        datos.setFechaNacimiento(jdFechaNac.getSelectedDate().getTime());
        datos.setGrupoSanguineo(jcbGrupoSanguineo.getSelectedItem().toString());
        datos.setNombres(jtxtNombres.getText());
        datos.setPais(jtxtPais.getText());
        datos.setProvincia(jtxtProvincia.getText());

        estudios.setUniversidadGraduacion(jtxtUniversidadGraduado.getText());
        estudios.setTituloGraduacion(jtxtTitulo.getText());
        estudios.setFechaGraduacion(jdFechaGraduacion.getSelectedDate().getTime());
        estudios.setLugarGraduacion(jtxtLugarGraduacion.getText());
        estudios.setLibro(jtxtLibro.getText());
        estudios.setFolio(jtxtFolio.getText());
        estudios.setInscripcionSanitaria(jtxtInscripcionSanitaria.getText());
        estudios.setUniversidadEspecialidad(jtxtUniversidadEspecialidad.getText());
        estudios.setTituloEspecialidad(jtxtEspacialidad.getText());
        estudios.setFechaEspecialidad(jdFechaEspecialidad.getSelectedDate()!=null?jdFechaEspecialidad.getSelectedDate().getTime():null);
        estudios.setMedicaturaRural(jtxtRural.getText());
        estudios.setFechaRural(jdFechaRural.getSelectedDate().getTime());

        contacto.setCelular(jtxtCelular.getText());
        contacto.setConsultorio(jtxtDireccionConsultorio.getText());
        contacto.setDireccion(jtxtDireccionResidencia.getText());
        contacto.setEmail(jtxtemail.getText());
        contacto.setResidencia(jtxtResidencia.getText());
        contacto.setTelefono(jtxtTelefonoResidencia.getText());
        contacto.setTelfonoConsultorio(jtxtTelefonoConsultorio.getText());

        if (hSocio.guardarSocioNuevo(datos, estudios, contacto, jcbEstado.getSelectedIndex() == 1 ? "a" : "i", jtxtLugar.getText(), jdCreacion.getSelectedDate().getTime(), imagen)) {
            Herramientas.MensajeInfo(IdiomaESP.mGuardarNuevoSocio, IdiomaESP.tGuardarSocio);
            vaciarCampos();
        } else {
            Herramientas.MensajeErr(IdiomaESP.mErGuardarNuevoSocio, IdiomaESP.tGuardarSocio);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtxtCodigo = new javax.swing.JTextField();
        jtxtCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtNombres = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtApPat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtApMat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jdFechaNac = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();
        jtxtPais = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtProvincia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtxtCiudad = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jlbImagen = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jcbGrupoSanguineo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jtxtNombreConyugue = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jcEstadoCivil1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtUniversidadGraduado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtxtInscripcionSanitaria = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtxtLibro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxtFolio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtxtLugarGraduacion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jdFechaGraduacion = new datechooser.beans.DateChooserCombo();
        jLabel20 = new javax.swing.JLabel();
        jtxtEspacialidad = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtxtUniversidadEspecialidad = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jdFechaEspecialidad = new datechooser.beans.DateChooserCombo();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jtxtRural = new javax.swing.JTextField();
        jdFechaRural = new datechooser.beans.DateChooserCombo();
        jLabel26 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jtxtTitulo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jtxtResidencia = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jtxtDireccionResidencia = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jtxtTelefonoResidencia = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jtxtDireccionConsultorio = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jtxtTelefonoConsultorio = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jtxtemail = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jtxtCelular = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jdCreacion = new datechooser.beans.DateChooserCombo();
        jLabel37 = new javax.swing.JLabel();
        jtxtLugar = new javax.swing.JTextField();
        RestrictedTextField rdLugar = new RestrictedTextField(jtxtLugar);
        rdLugar.setLimit(45);
        rdLugar.setOnlyText(true);
        jtxtLugar.setText(IdiomaESP.opLugar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(IdiomaESP.tDatosPersonales));

        RestrictedTextField rtCodigo = new RestrictedTextField(jtxtCodigo);
        rtCodigo.setAcceptSpace(false);
        rtCodigo.setLimit(5);
        rtCodigo.setOnlyNums(true);

        RestrictedTextField rtCedula = new RestrictedTextField(jtxtCedula);
        rtCedula.setLimit(11);
        rtCedula.setOnlyNums(true);
        rtCedula.setAcceptSpace(false);

        jLabel3.setText(Herramientas.obligatorio(IdiomaESP.lCodigo));

        jLabel4.setText(Herramientas.obligatorio(IdiomaESP.lCedula));

        jLabel5.setText(Herramientas.obligatorio(IdiomaESP.lNombres));

        RestrictedTextField rdNombres = new RestrictedTextField(jtxtNombres);
        rdNombres.setLimit(100);
        rdNombres.setOnlyText(true);
        rdNombres.setAcceptSpace(true);

        jLabel6.setText(Herramientas.obligatorio(IdiomaESP.lbApelPat));

        RestrictedTextField rdApPat = new RestrictedTextField(jtxtApPat);
        rdApPat.setLimit(45);
        rdApPat.setOnlyText(true);

        jLabel7.setText(Herramientas.obligatorio(IdiomaESP.lbApelMat));

        RestrictedTextField rdApMat = new RestrictedTextField(jtxtApMat);
        rdApMat.setLimit(45);
        rdApMat.setOnlyText(true);

        jLabel8.setText(Herramientas.obligatorio(IdiomaESP.lbfechaNac));

        jdFechaNac.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    jdFechaNac.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

    jLabel9.setText(IdiomaESP.lbPais);

    RestrictedTextField rdPais = new RestrictedTextField(jtxtPais);
    rdPais.setOnlyText(true);
    rdPais.setLimit(45);

    jLabel10.setText(IdiomaESP.lbProv);

    RestrictedTextField rdProvincia = new RestrictedTextField(jtxtProvincia);
    rdProvincia.setOnlyText(true);
    rdProvincia.setLimit(45);

    jLabel11.setText(IdiomaESP.lbCiudad);

    RestrictedTextField rdCiudad = new RestrictedTextField(jtxtCiudad);
    rdCiudad.setOnlyText(true);
    rdCiudad.setLimit(45);

    jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

    jlbImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlbImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jButton1.setText(IdiomaESP.btBuscar);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jButton2.setText(IdiomaESP.btCancelar);
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jLabel12.setText(Herramientas.obligatorio(IdiomaESP.lbSangre));

    jcbGrupoSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-"+IdiomaESP.lbOpcSeleccionar+"-",
        "A+","A-","B+","B-","AB+","AB-","O+","O-"}));

jLabel13.setText(IdiomaESP.lbNombreConyuge);

jLabel35.setText(Herramientas.obligatorio(IdiomaESP.lbEstadoCiv));

jcEstadoCivil1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-"+IdiomaESP.lbOpcSeleccionar+"-",
IdiomaESP.lbOpcSoltero,IdiomaESP.lbOpcCasado,IdiomaESP.lbOpcDivorciado,IdiomaESP.lbOpcViudo }));
jcEstadoCivil1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcEstadoCivil1ActionPerformed(evt);
    }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3)
                .addComponent(jLabel4)
                .addComponent(jLabel5)
                .addComponent(jLabel6)
                .addComponent(jLabel7)
                .addComponent(jLabel8)
                .addComponent(jLabel9)
                .addComponent(jLabel10)
                .addComponent(jLabel11)
                .addComponent(jLabel12)
                .addComponent(jLabel13)
                .addComponent(jLabel35))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jtxtPais, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtxtCodigo)
                        .addComponent(jtxtCedula)
                        .addComponent(jtxtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(jtxtApPat, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(jtxtApMat, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addComponent(jtxtProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addComponent(jtxtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addComponent(jcbGrupoSanguineo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtxtNombreConyugue, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addComponent(jcEstadoCivil1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jlbImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jtxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcbGrupoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcEstadoCivil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel35))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jtxtNombreConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2)))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(IdiomaESP.tDatosEducacion));

    jLabel2.setText(Herramientas.obligatorio(IdiomaESP.lbUniversidad));

    RestrictedTextField rdunigrad = new RestrictedTextField(jtxtUniversidadGraduado);
    rdunigrad.setAcceptSpace(true);
    rdunigrad.setOnlyText(true);
    rdunigrad.setLimit(150);

    jLabel14.setText(Herramientas.obligatorio(IdiomaESP.lbInsSanitaria));

    RestrictedTextField rdInsSan = new RestrictedTextField(jtxtInscripcionSanitaria);
    rdInsSan.setOnlyAlphaNumeric(true);
    rdInsSan.setLimit(20);

    jLabel15.setText(IdiomaESP.lbLibro);

    RestrictedTextField rdLibro = new RestrictedTextField(jtxtLibro);
    rdLibro.setLimit(45);
    rdLibro.setOnlyAlphaNumeric(true);

    jLabel16.setText(IdiomaESP.lbFolio);

    RestrictedTextField rdFolio = new RestrictedTextField(jtxtFolio);
    rdFolio.setLimit(45);
    rdFolio.setOnlyAlphaNumeric(true);

    jLabel18.setText(Herramientas.obligatorio(IdiomaESP.lbLugarGrad));

    RestrictedTextField rdLugarGrad = new RestrictedTextField(jtxtLugarGraduacion);
    rdLugarGrad.setOnlyText(true);
    rdLugarGrad.setLimit(150);

    jLabel19.setText(Herramientas.obligatorio(IdiomaESP.lbFechaGrad));

    jdFechaGraduacion.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
    jdFechaGraduacion.setText("");

    jLabel20.setText(IdiomaESP.lbEspcialidad);

    RestrictedTextField rdEspecialidad = new RestrictedTextField(jtxtEspacialidad);
    rdEspecialidad.setLimit(100);
    rdEspecialidad.setOnlyText(true);
    rdEspecialidad.setAcceptSpace(true);

    jLabel21.setText(IdiomaESP.lbUniversidad);

    RestrictedTextField rdUEspe = new RestrictedTextField(jtxtUniversidadEspecialidad);
    rdUEspe.setLimit(100);
    rdUEspe.setAcceptSpace(true);
    rdUEspe.setOnlyText(true);

    jLabel22.setText(IdiomaESP.lbFechaGrad);

    jdFechaEspecialidad.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
    jdFechaEspecialidad.setText("");

    jLabel17.setText(IdiomaESP.tGraduacion);

    jLabel23.setText(IdiomaESP.tEspecialidad);

    jLabel24.setText(Herramientas.obligatorio(IdiomaESP.lbRural));

    jLabel25.setText(Herramientas.obligatorio(IdiomaESP.lbFechaGrad));

    RestrictedTextField rdRural = new RestrictedTextField(jtxtRural);
    rdRural.setLimit(100);
    rdRural.setAcceptSpace(true);
    rdRural.setOnlyText(true);

    jdFechaRural.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
    jdFechaRural.setText("");

    jLabel26.setText(IdiomaESP.tRural);

    jLabel34.setText(Herramientas.obligatorio(IdiomaESP.lbTitulo));

    RestrictedTextField rdTitulo = new RestrictedTextField(jtxtTitulo);
    rdTitulo.setAcceptSpace(true);
    rdTitulo.setOnlyText(true);
    rdTitulo.setLimit(45);
    jtxtTitulo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jtxtTituloActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel17)
                .addComponent(jLabel23)
                .addComponent(jLabel26)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel18)
                        .addComponent(jLabel19)
                        .addComponent(jLabel20)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)
                        .addComponent(jLabel24)
                        .addComponent(jLabel25)
                        .addComponent(jLabel34))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdFechaRural, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdFechaEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtUniversidadEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtEspacialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtInscripcionSanitaria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtUniversidadGraduado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtLugarGraduacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdFechaGraduacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtRural, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel17)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(jtxtUniversidadGraduado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel34))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtInscripcionSanitaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel15))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel16))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtLugarGraduacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel18))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel19)
                .addComponent(jdFechaGraduacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel23)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel20)
                .addComponent(jtxtEspacialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtUniversidadEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel21))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jdFechaEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel22))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel26)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel24)
                .addComponent(jtxtRural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel25)
                .addComponent(jdFechaRural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jButton3.setText(IdiomaESP.btGuardar);
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    jButton4.setText(IdiomaESP.btCancelar);
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(56, 56, 56)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(45, 45, 45)
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(45, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(IdiomaESP.tDatosContacto));

    jLabel27.setText(Herramientas.obligatorio(IdiomaESP.lbResidencia));

    RestrictedTextField rdResidencia = new RestrictedTextField(jtxtResidencia);
    rdResidencia.setLimit(45);
    rdResidencia.setOnlyText(true);

    jLabel28.setText(IdiomaESP.lbDireccion);

    RestrictedTextField rdDirResidencia = new RestrictedTextField(jtxtDireccionResidencia);
    rdDirResidencia.setLimit(100);
    rdDirResidencia.setAcceptSpace(true);
    rdDirResidencia.setOnlyAlphaNumeric(true);

    jLabel29.setText(Herramientas.obligatorio(IdiomaESP.lbTelfono));

    RestrictedTextField rdtelres = new RestrictedTextField(jtxtTelefonoResidencia);
    rdtelres.setLimit(15);
    rdtelres.setAcceptCharacters("-0123456789-");
    rdtelres.setOnlyCustomCharacters(true);

    jLabel30.setText(IdiomaESP.lbDireccionConsul);

    RestrictedTextField rdDirCon = new RestrictedTextField(jtxtDireccionConsultorio);
    rdDirCon.setLimit(120);
    rdDirCon.setAcceptSpace(true);
    rdDirCon.setOnlyAlphaNumeric(true);

    jLabel31.setText(IdiomaESP.lbTelfono);

    RestrictedTextField rdTelCon = new RestrictedTextField(jtxtTelefonoConsultorio);
    rdTelCon.setLimit(15);
    rdTelCon.setAcceptCharacters("0123456789--");
    rdTelCon.setOnlyCustomCharacters(true);

    jLabel32.setText(Herramientas.obligatorio(IdiomaESP.lbCorreo));

    RestrictedTextField rdemail = new RestrictedTextField(jtxtemail);
    rdemail.setLimit(100);

    jLabel33.setText(Herramientas.obligatorio(IdiomaESP.lbCelular));

    RestrictedTextField rdCelular = new RestrictedTextField(jtxtCelular);
    rdCelular.setLimit(15);
    rdCelular.setAcceptCharacters("0123456789--");
    rdCelular.setOnlyCustomCharacters(true);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel28)
                .addComponent(jLabel29)
                .addComponent(jLabel27)
                .addComponent(jLabel30)
                .addComponent(jLabel31)
                .addComponent(jLabel32)
                .addComponent(jLabel33))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jtxtResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtTelefonoResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDireccionResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDireccionConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTelefonoConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel27)
                .addComponent(jtxtResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtDireccionResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel28))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtTelefonoResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel29))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtDireccionConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel30))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtTelefonoConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel31))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel32))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel33))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(IdiomaESP.tEstadoSocio));

    jLabel1.setText(Herramientas.obligatorio(IdiomaESP.tEstadoSocio));

    jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-"+IdiomaESP.lbOpcSeleccionar+"-",
        IdiomaESP.lbOpActivo,IdiomaESP.lbOpInactivo}));

javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
jPanel5.setLayout(jPanel5Layout);
jPanel5Layout.setHorizontalGroup(
jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel5Layout.createSequentialGroup()
    .addContainerGap()
    .addComponent(jLabel1)
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(IdiomaESP.tFechaAfi));

    jLabel36.setText(Herramientas.obligatorio(IdiomaESP.lbFechaGrad));

    jdCreacion.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

    jLabel37.setText(Herramientas.obligatorio(IdiomaESP.lbLugar));

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel37)
                .addComponent(jLabel36))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jdCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(jtxtLugar))
            .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel37)
                .addComponent(jtxtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jdCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel36))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String url = "";
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                imagen = Herramientas.toByte(jfc.getSelectedFile());
                jlbImagen.setIcon(new ImageIcon(new ImageIcon(imagen).getImage().getScaledInstance(dImagen.width, dImagen.height, Image.SCALE_AREA_AVERAGING)));
            } catch (IOException ex) {
                Logger.getLogger(jdNuevoSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        imagen = null;
        jlbImagen.setIcon(new Herramientas().getIcono("/Recursos/User.png", dImagen.width, dImagen.height));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!camposLlenos()) {
            guardar();
        } else {
            herramientas.Herramientas.MensajeAdv(IdiomaESP.mErCamposObligatorios);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jcEstadoCivil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEstadoCivil1ActionPerformed

        jLabel13.setText(jcEstadoCivil1.getSelectedIndex() == 2 ? Herramientas.obligatorio(IdiomaESP.lbNombreConyuge) : IdiomaESP.lbNombreConyuge);
    }//GEN-LAST:event_jcEstadoCivil1ActionPerformed

    private void jtxtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTituloActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       vaciarCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdNuevoSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdNuevoSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdNuevoSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdNuevoSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdNuevoSocio dialog = new jdNuevoSocio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcEstadoCivil1;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JComboBox<String> jcbGrupoSanguineo;
    private datechooser.beans.DateChooserCombo jdCreacion;
    private datechooser.beans.DateChooserCombo jdFechaEspecialidad;
    private datechooser.beans.DateChooserCombo jdFechaGraduacion;
    private datechooser.beans.DateChooserCombo jdFechaNac;
    private datechooser.beans.DateChooserCombo jdFechaRural;
    private javax.swing.JLabel jlbImagen;
    private javax.swing.JTextField jtxtApMat;
    private javax.swing.JTextField jtxtApPat;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtCelular;
    private javax.swing.JTextField jtxtCiudad;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtDireccionConsultorio;
    private javax.swing.JTextField jtxtDireccionResidencia;
    private javax.swing.JTextField jtxtEspacialidad;
    private javax.swing.JTextField jtxtFolio;
    private javax.swing.JTextField jtxtInscripcionSanitaria;
    private javax.swing.JTextField jtxtLibro;
    private javax.swing.JTextField jtxtLugar;
    private javax.swing.JTextField jtxtLugarGraduacion;
    private javax.swing.JTextField jtxtNombreConyugue;
    private javax.swing.JTextField jtxtNombres;
    private javax.swing.JTextField jtxtPais;
    private javax.swing.JTextField jtxtProvincia;
    private javax.swing.JTextField jtxtResidencia;
    private javax.swing.JTextField jtxtRural;
    private javax.swing.JTextField jtxtTelefonoConsultorio;
    private javax.swing.JTextField jtxtTelefonoResidencia;
    private javax.swing.JTextField jtxtTitulo;
    private javax.swing.JTextField jtxtUniversidadEspecialidad;
    private javax.swing.JTextField jtxtUniversidadGraduado;
    private javax.swing.JTextField jtxtemail;
    // End of variables declaration//GEN-END:variables
}
