/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarPersonalServicio;
import c3_dominio.Personal;
import c3_dominio.TipoPersonal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class FormGestionarPersonal extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarPersonal
     */
    private String flag = "Guardar";
    private Personal personal;
    private TipoPersonal tipoPersonal;
    private GestionarPersonalServicio gu;
    private List<Personal> personales;
    private List<TipoPersonal> tipoPersonales;

    public FormGestionarPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrar();
        cargarCargos();
        botones(false);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        cboTipoDoc = new javax.swing.JComboBox();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        cboCargo = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        listado = new javax.swing.JTable();
        lblNumRegistro = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador de Unidades");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidad"));

        jLabel1.setText("Nombre : ");

        lblId.setText("id");

        jLabel2.setText("Paterno : ");

        jLabel3.setText("Materno : ");

        jLabel5.setText("Tipo Documento :");

        jLabel6.setText("Numero :");

        jLabel7.setText("Usuario :");

        jLabel8.setText("Contraseña :");

        jLabel9.setText("Cargo :");

        cboTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dni", "otros" }));

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
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass)
                            .addComponent(txtUsuario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cboTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCargo)
                    .addComponent(jLabel9)))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumRegistro)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumRegistro))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiar() {
        lblId.setText("id");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtNumero.setText("");
        txtUsuario.setText("");
        txtPass.setText("");
        txtNombre.requestFocus();
        txtBuscar.setText("");
    }

    private void botones(boolean btn) {
        txtNombre.setEnabled(btn);
        txtPaterno.setEnabled(btn);
        txtMaterno.setEnabled(btn);
        cboTipoDoc.setEnabled(btn);
        txtNumero.setEnabled(btn);
        txtUsuario.setEnabled(btn);
        txtPass.setEnabled(btn);
        cboCargo.setEnabled(btn);
        btnGuardar.setEnabled(btn);
        btnCancelar.setEnabled(btn);
        btnNuevo.setEnabled(!btn);
        btnEliminar.setEnabled(btn);
    }

    private void cargarCargos() {
        gu = new GestionarPersonalServicio();
        try {
            tipoPersonales = gu.listarCargos();
            for (TipoPersonal c : tipoPersonales) {
                cboCargo.addItem(c.getTipoPersonal());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        } 
    }

    private void mostrar() {
        try {
            gu = new GestionarPersonalServicio();
            personales = gu.listarPersonal();
            gu.llenarLista(listado, personales);
            lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private boolean buscarPersonalList(String nombre) {
        boolean flag = false;
        gu = new GestionarPersonalServicio();
        try {
            personales = gu.listarPersonal();
            flag = (gu.buscarPersonalList(personales, nombre)) ? true : false;

        } catch (Exception e) {
        }
        return flag;
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!txtNombre.getText().equals("")) {
            try {
                personal = new Personal();
                gu = new GestionarPersonalServicio();
                personal.setNombre(txtNombre.getText().toLowerCase().trim());
                personal.setApellidoPaterno(txtPaterno.getText().toLowerCase().trim());
                personal.setApellidoMaterno(txtMaterno.getText().toLowerCase().trim());
                personal.setTipoDocumento(flag);
                personal.setNumDocumento(txtNumero.getText().toLowerCase().trim());
                personal.setUsuario(txtUsuario.getText().toLowerCase().trim());
                personal.setPassword(txtPass.getText().toLowerCase().trim());
                personal.setEstado(1);
                tipoPersonales = gu.listarCargos();
                JOptionPane.showMessageDialog(null,gu.obtenerId(tipoPersonales,String.valueOf(cboCargo.getSelectedItem())));
                if (flag.equals("Guardar")) {
//                    if (!buscarPersonalList(txtNombre.getText().toLowerCase().trim())) {
//                        if (gu.insertarPersonal(personal)) {
//                            JOptionPane.showMessageDialog(null, "Guardado correctamente");
//                            mostrar();
//                            limpiar();
//                            botones(false);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "No se pudo guardar");
//                            mostrar();
//                            limpiar();
//                            botones(false);
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(this, "la personal ya existe");
//                        txtNombre.requestFocus();
//                    }
                } else {
                    personal.setIdpersonal(Integer.parseInt(lblId.getText()));
                    if (gu.editarPersonal(personal)) {
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

        flag = "Editar";
        botones(true);
        btnGuardar.setText("Editar");
    }//GEN-LAST:event_listadoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!lblId.getText().equals("id")) {
            int res = JOptionPane.showConfirmDialog(this, "¿Esta Seguro De Eliminar?", "Eliminar", 0, 3);
            if (res == 0) {
                try {
                    gu = new GestionarPersonalServicio();
                    personal = new Personal();
                    personal.setIdpersonal(Integer.parseInt(lblId.getText()));
                    if (gu.eliminarPersonal(personal)) {
                        JOptionPane.showMessageDialog(this, "Eliminado correctamente");
                        mostrar();
                        limpiar();
                        botones(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar", "Aviso", 2);
                        mostrar();
                        limpiar();
                        botones(false);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            } else {
                mostrar();
                limpiar();
                botones(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe de selecionar una Personal para eliminar", "Aviso", 2);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        gu = new GestionarPersonalServicio();
        personal = new Personal();
        try {
            //personal.setPersonal(String.valueOf(evt.getKeyChar()));
            personal.setNombre(txtBuscar.getText());
            personales = gu.buscarNombre(personal);
            gu.llenarLista(listado, personales);
            lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboCargo;
    private javax.swing.JComboBox cboTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNumRegistro;
    private javax.swing.JTable listado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
