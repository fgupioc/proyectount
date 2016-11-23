/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarAreaServicio;
import c2_aplicacion.GestionarMovimientoServicio;
import c3_dominio.Area;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class FormConsultaPorArea extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormGestionarUnidad
     */ 
    Area area;
    private GestionarMovimientoServicio gu;
    private List<Area> areas;

    public FormConsultaPorArea(java.awt.Frame parent, boolean modal) { 
        initComponents();
        cargarArea();
        mostrar("Sin");
        botones(false); 
        lblCodigo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        listado = new javax.swing.JTable();
        lblNumRegistro = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        cboArea = new javax.swing.JComboBox();
        lblCodigo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administrador de Area");

        listado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listado);

        lblNumRegistro.setText("Nº Registros");

        jLabel4.setText("Area :");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Consulta");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        cboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAreaActionPerformed(evt);
            }
        });

        lblCodigo.setText("codigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblCodigo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNumRegistro)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigo)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarArea(){
        GestionarAreaServicio gas = new GestionarAreaServicio();
        try {
            for(Area obj : gas.listar()){
                cboArea.addItem(obj.getDescripcion());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e);
        }
    }
    private void limpiar() { 
    }

    private void botones(boolean btn) {
        
        btnGuardar.setEnabled(btn);
        btnCancelar.setEnabled(btn);
        btnNuevo.setEnabled(!btn);
        cboArea.setEnabled(btn);
    }

    private void mostrar(String value) {
        try {
            gu = new GestionarMovimientoServicio();
            listado.setModel(gu.consultaArea(value));
            ocultar();
            lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
 public void ocultar() {
        listado.getColumnModel().getColumn(0).setMaxWidth(80);
        listado.getColumnModel().getColumn(0).setMinWidth(80);
        listado.getColumnModel().getColumn(0).setPreferredWidth(80);
 
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        GestionarMovimientoServicio gm = new GestionarMovimientoServicio();
       if(!lblCodigo.getText().equals("codigo")){
            try {
            gm.reporteMemo(lblCodigo.getText());
        } catch (Exception ex) {
            Logger.getLogger(FormConsultaPorArea.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        mostrar("");
        limpiar();
        botones(false); 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        mostrar("");
        limpiar();
        botones(true);  
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void listadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoMouseClicked
        int fila = listado.rowAtPoint(evt.getPoint());
        lblCodigo.setText(listado.getValueAt(fila, 0).toString());        
    }//GEN-LAST:event_listadoMouseClicked

    private void cboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAreaActionPerformed
      mostrar(cboArea.getSelectedItem().toString()); 
    }//GEN-LAST:event_cboAreaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboArea;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNumRegistro;
    private javax.swing.JTable listado;
    // End of variables declaration//GEN-END:variables
}
