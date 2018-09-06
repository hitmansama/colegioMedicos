package colegiomedicos;

import eventos.hCuenta;
import herramientas.Herramientas;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import pojos.Cuenta;
import herramientas.IdiomaESP;
import java.util.Iterator;
import javax.swing.JDialog;

public class jiAdministrarCuentas extends javax.swing.JInternalFrame {

    /**
     * Creates new form jiAdministrarCuentas
     */
    Cuenta cuenta = null;

    public jiAdministrarCuentas(Cuenta _cuenta) {
        initComponents();
        this.setTitle(IdiomaESP.tSupAdminCuenta);
        cuenta = _cuenta;
        cargarTabla();
    }/*private void cargarListaHistoria() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Fecha");
        dtm.addColumn("Hora");
        dtm.addColumn("Enfermedad");
        dtm.addColumn("Seguimmiento");
        dtm.addColumn("aux");
        if (jcbAlumno.getSelectedIndex() == 0) {
            reiniciarContenido();
            return;
        }
        List<Historialclinico> historial = hHistorial.obtenerHistorialPorAlumno((Alumno) jcbAlumno.getSelectedItem());
        if (historial != null) {
            Iterator it = historial.iterator();
            for (Iterator<Historialclinico> iterator = historial.iterator(); iterator.hasNext();) {
                boolean agregar = true;
                Historialclinico next = iterator.next();
                if (jcbFiltroHistorial.getSelectedIndex() == 2) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(next.getFecha());
                    agregar = cal.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH);
                }

                if (jcbFiltroHistorial.getSelectedIndex() == 1) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(next.getFecha());
                    agregar = cal.get(Calendar.WEEK_OF_YEAR) == Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
                }

                if (agregar) {
                    Object[] objetos = new Object[5];
                    objetos[0] = new SimpleDateFormat("dd-MMM-yyyy").format(next.getFecha());
                    objetos[1] = new SimpleDateFormat("hh:mm").format(next.getHora());
                    objetos[2] = next.getEnfermedad() + ": " + next.getDetalle();
                    objetos[3] = next.getRecomendacion().trim().isEmpty() ? "Sin recomendación" : next.getSeguimiento() == 1 ? next.getRecomendacion() + ". Se ha seguido las recomendaciones." : next.getRecomendacion() + ". No se ha seguido las recomendaciones";
                    objetos[4] = next;
//                    dtm.addRow(new String[]{new SimpleDateFormat("dd-MMM-yyyy").format(next.getFecha()), new SimpleDateFormat("hh:mm").format(next.getHora()), next.getEnfermedad() + ": " + next.getDetalle(), next.getRecomendacion().trim().isEmpty() ? "Sin recomendación" : next.getSeguimiento() == 1 ? next.getRecomendacion() + "Se ha seguido las recomendaciones." : next.getRecomendacion() + ". No se ha seguido las recomendaciones"});
                    dtm.addRow(objetos);

                }
            }
            jtHistorial.setModel(dtm);
            jtHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtHistorial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtHistorial.setDefaultEditor(Object.class, null);
            jtHistorial.getTableHeader().setReorderingAllowed(false);
            jtHistorial.removeColumn(jtHistorial.getColumnModel().getColumn(4));
        }

    }*/
    public void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cuenta");
        modelo.addColumn("Propietario");
        modelo.addColumn("Privilegios");
        modelo.addColumn("Objeto");
        List<Cuenta> cuentas = hCuenta.buscarCuentas();
        if (cuentas != null) {
            Iterator it = cuentas.iterator();
            while (it.hasNext()) {
                Cuenta aux = (Cuenta) it.next();
                if (!aux.getTipoCuenta().equals("s") && !aux.getUsuario().equals(cuenta.getUsuario())) {
                    Object[] objetos = new Object[4];
                    objetos[0] = aux.getUsuario();
                    objetos[1] = aux.getNombres() + " " + aux.getApellidos();
                    objetos[2] = aux.getTipoCuenta().equals("n") ? "Usuario" : "Administrador";
                    objetos[3] = aux;
                    modelo.addRow(objetos);
                }
            }
        }
        jTable1.setModel(modelo);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(3));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText(IdiomaESP.btCancelar);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(IdiomaESP.btActualizar);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(IdiomaESP.bNuevo);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       JDialog ventanaEmergente = new jdNuevoUsuario(null, true);
       ventanaEmergente.setVisible(true);
       cargarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow()==-1){
            Herramientas.MensajeAdv(IdiomaESP.mErEditarSinSele,IdiomaESP.tEditarUsuario);
            return;
        }
        Cuenta aux = (Cuenta) jTable1.getModel().getValueAt(jTable1.getSelectedRow(),3);
        if(aux.getTipoCuenta().equals("a") && !cuenta.getTipoCuenta().equals("s")){
            herramientas.Herramientas.MensajeErr(IdiomaESP.mErSinPrivilegios,IdiomaESP.tErrorContra);
        }
        else{
            jdEditarUsuario ven = new jdEditarUsuario(null,true, aux);
            ven.setVisible(true);
            cargarTabla();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
