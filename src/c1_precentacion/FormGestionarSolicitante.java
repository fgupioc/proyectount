/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarSolicitanteServicio;
import c3_dominio.Solicitante;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class FormGestionarSolicitante extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormGestionarUnidad
     */
    private String flag = "Guardar";
    Solicitante solicitante;
    private GestionarSolicitanteServicio gu;
    private List<Solicitante> solicitantes;
    public Solicitante tempSolicitante;

    public FormGestionarSolicitante(java.awt.Frame parent, boolean modal) { 
        initComponents();
        mostrar();
        botones(false);
        tempSolicitante = new Solicitante();
        lblId.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listado = new javax.swing.JTable();
        lblNumRegistro = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administrador de Solicitante");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitante"));

        jLabel1.setText("Nombre : ");

        lblId.setText("id");

        jLabel2.setText("Paterno :");

        jLabel3.setText("Materno :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtMaterno))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listadoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listado);

        lblNumRegistro.setText("Nº Registros");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jLabel4.setText("Buscar Nombre: ");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumRegistro)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)
                            .addComponent(btnEliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiar() {
        lblId.setText("id");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtNombre.requestFocus();
        txtBuscar.setText("");
    }

    private void botones(boolean btn) {
        txtNombre.setEnabled(btn);
        txtPaterno.setEnabled(btn);
        txtMaterno.setEnabled(btn);
        btnGuardar.setEnabled(btn);
        btnCancelar.setEnabled(btn);
        btnNuevo.setEnabled(!btn);
        btnEliminar.setEnabled(btn);
    }

    private void mostrar() {
        try {
            gu = new GestionarSolicitanteServicio();
            solicitantes = gu.listar();
            gu.llenarLista(listado, solicitantes);
            lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    } 
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!txtNombre.getText().equals("")) {
            try {
                solicitante = new Solicitante();
                gu = new GestionarSolicitanteServicio();
                solicitante.setNombre(txtNombre.getText().toLowerCase().trim());
                solicitante.setPaterno(txtPaterno.getText().toLowerCase().trim());
                solicitante.setMaterno(txtMaterno.getText().toLowerCase().trim());
                solicitante.setEstado(1);

                if (flag.equals("Guardar")) {
                    if (gu.insertar(solicitante)) {
                        JOptionPane.showMessageDialog(null, "Guardado correctamente");
                        mostrar();
                        limpiar();
                        botones(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar");
                        mostrar();
                        limpiar();
                        botones(false);
                    }
                } else {
                    solicitante.setIdsolicitante(Integer.parseInt(lblId.getText()));
                    if (gu.editar(solicitante)) {
                        JOptionPane.showMessageDialog(null, "Se Actualizo correctamente");
                        mostrar();
                        limpiar();
                        botones(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "no se pudo actualizar");
                        mostrar();
                        limpiar();
                        botones(false);
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe llenar el nombre", "Aviso", 0);
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        mostrar();
        limpiar();
        botones(false);
        btnGuardar.setText("Guardar");
        flag = "Guardar";
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        mostrar();
        limpiar();
        botones(true);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void listadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoMouseClicked
        int fila = listado.rowAtPoint(evt.getPoint());
        lblId.setText(listado.getValueAt(fila, 0).toString());
        txtNombre.setText(listado.getValueAt(fila, 1).toString());
        txtPaterno.setText(listado.getValueAt(fila, 2).toString());
        txtMaterno.setText(listado.getValueAt(fila, 3).toString());

        flag = "Editar";
        botones(true);
        btnGuardar.setText("Editar");
    }//GEN-LAST:event_listadoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!lblId.getText().equals("id")) {
            int res = JOptionPane.showConfirmDialog(this, "¿Esta Seguro De Eliminar?", "Eliminar", 0, 3);
            if (res == 0) {
                try {
                    gu = new GestionarSolicitanteServicio();
                    solicitante = new Solicitante();
                    solicitante.setIdsolicitante(Integer.parseInt(lblId.getText()));
                    if (gu.eliminar(solicitante)) {
                        JOptionPane.showMessageDialog(this, "Eliminado correctamente");
                        mostrar();
                        limpiar();
                        botones(false);
                        btnGuardar.setText("Guardar");
                        flag = "Guardar";
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar", "Aviso", 2);
                        mostrar();
                        limpiar();
                        botones(false);
                        btnGuardar.setText("Guardar");
                        flag = "Guardar";
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            } else {
                mostrar();
                limpiar();
                botones(false);
                btnGuardar.setText("Guardar");
                flag = "Guardar";
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe de selecionar una Unidad para eliminar", "Aviso", 2);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        gu = new GestionarSolicitanteServicio();
        solicitante = new Solicitante();
        try { 
            solicitante.setNombre(txtBuscar.getText());
            solicitantes = gu.buscarNombre(solicitante);
            gu.llenarLista(listado, solicitantes);
            lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void listadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoMousePressed
       if(evt.getClickCount() == 2){  
           int fila = listado.getSelectedRow();
           tempSolicitante.setIdsolicitante(Integer.parseInt(listado.getValueAt(fila, 0).toString()));
           tempSolicitante.setNombre(listado.getValueAt(fila, 1).toString());
           tempSolicitante.setPaterno(listado.getValueAt(fila, 2).toString());
           tempSolicitante.setMaterno(listado.getValueAt(fila, 3).toString());
           FormGestionarSalidaArticulo.lblSolicitante.setText(listado.getValueAt(fila, 1).toString()+" "+listado.getValueAt(fila, 2).toString()+" "+listado.getValueAt(fila, 3).toString());
           FormGestionarSalidaArticulo.tempSolicitante = tempSolicitante;
           this.setVisible(false);
       }
    }//GEN-LAST:event_listadoMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNumRegistro;
    private javax.swing.JTable listado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
