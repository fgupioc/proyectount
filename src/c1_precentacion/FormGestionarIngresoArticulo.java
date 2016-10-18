/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarMovimientoServicio;
import c3_dominio.Configuracion;
import c3_dominio.LoginUser;
import c3_dominio.Movimiento;
import c3_dominio.Personal;
import c3_dominio.Producto;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class FormGestionarIngresoArticulo extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarUnidad
     */
    private String flag = "Guardar";
    private boolean rem = false;
    Movimiento movimiento;
    Producto producto;
    public static Producto tempProducto;
    private GestionarMovimientoServicio gu;
    private List<Movimiento> movimientos;
    private List<Movimiento> templist = new ArrayList();
    private final LoginUser user = LoginUser.getInstancia();

    public FormGestionarIngresoArticulo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblPersonal.setText(user.getPersonal().getNombre() + " " + user.getPersonal().getApellidoPaterno() + " " + user.getPersonal().getApellidoMaterno());
        mostrar(templist);
        botones(false);
        lblId.setVisible(false);
        lblIdArticulo.setVisible(false);
        lblindiceselect.setVisible(false);
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
        lblId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumIngreso = new javax.swing.JTextField();
        btnBuscarArticulo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblArticulo = new javax.swing.JLabel();
        testoplano = new javax.swing.JLabel();
        lblCodigoProducto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jspCantidad = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        lblPersonal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMedida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnAddArticulo = new javax.swing.JButton();
        btnRemoveArticulo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        lblIdArticulo = new javax.swing.JLabel();
        lblindiceselect = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listado = new javax.swing.JTable();
        lblNumRegistro = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador de Unidades");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidad"));

        jLabel1.setText("Buscar Producto :");

        lblId.setText("id");

        jLabel2.setText("Num :");

        txtNumIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumIngresoActionPerformed(evt);
            }
        });

        btnBuscarArticulo.setText("...");
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });

        jLabel4.setText("Articulo : ");

        lblArticulo.setText("Producto");

        testoplano.setText("Codigo :");

        lblCodigoProducto.setText("000");

        jLabel6.setText("Cantidad : ");

        jLabel7.setText("Encargado : ");

        lblPersonal.setText("Personal");

        jLabel8.setText("Unidad :");

        jLabel9.setText("Medida :");

        jLabel10.setText("Color :");

        jLabel11.setText("Referencia : ");

        btnAddArticulo.setText("Agregar Producto");
        btnAddArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddArticuloActionPerformed(evt);
            }
        });

        btnRemoveArticulo.setText("Quitar Articulo");
        btnRemoveArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveArticuloActionPerformed(evt);
            }
        });

        jLabel12.setText("Observacion :");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane3.setViewportView(txtObservacion);

        lblIdArticulo.setText("idarticulo");

        lblindiceselect.setText("indiceselect");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarArticulo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(testoplano)
                                        .addGap(3, 3, 3)
                                        .addComponent(lblCodigoProducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblArticulo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(4, 4, 4)
                                        .addComponent(jspCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnRemoveArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPersonal)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane3)
                                                .addComponent(txtReferencia)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblIdArticulo)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblindiceselect))
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMedida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNumIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdArticulo)
                        .addComponent(lblindiceselect)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblPersonal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarArticulo)
                    .addComponent(jLabel4)
                    .addComponent(lblArticulo)
                    .addComponent(testoplano)
                    .addComponent(lblCodigoProducto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jspCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddArticulo)
                    .addComponent(btnRemoveArticulo)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumRegistro)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiar() {
        lblId.setText("id");
        lblIdArticulo.setText("idarticulo");
        lblindiceselect.setText("indiceselect");
        txtReferencia.setText("");
        limpiaradd();
        txtNumIngreso.setText("");
        txtNumIngreso.requestFocus();
        templist = new ArrayList();
        mostrar(templist);

    }

    private void limpiaradd() {
        lblCodigoProducto.setText("000");
        lblArticulo.setText("Producto");
        txtObservacion.setText("");
        txtUnidad.setText("");
        txtMedida.setText("");
        txtColor.setText("");
        jspCantidad.setValue(0);
    }

    private void botones(boolean btn) {
        txtNumIngreso.setEnabled(btn);
        txtReferencia.setEnabled(btn);
        txtObservacion.setEnabled(btn);
        txtUnidad.setEnabled(btn);
        txtMedida.setEnabled(btn);
        txtColor.setEnabled(btn);
        jspCantidad.setEnabled(btn);
        btnCancelar.setEnabled(btn);
        btnNuevo.setEnabled(!btn);
        btnBuscarArticulo.setEnabled(btn);
        btnAddArticulo.setEnabled(btn);
        btnRemoveArticulo.setEnabled(btn);
        btnGuardar.setEnabled(btn);

    }

    private void mostrar(List<Movimiento> movimientos) {
        try {
            gu = new GestionarMovimientoServicio();
            gu.llenarLista(listado, movimientos);
            lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!txtNumIngreso.getText().equals("")) {
            if (templist.size() >= 1) {
                try {
                    gu = new GestionarMovimientoServicio();
                    if (flag.equals("Guardar")) {
                        for (Movimiento dts : templist) {
                            gu.addCantidad(dts);
                            if (gu.insertarIngreso(dts)) {
                                JOptionPane.showMessageDialog(null, "Guardado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo guardar");
                            }
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe agregar almenos un articulo", "Aviso", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un numero de documento", "Aviso", 0);
            txtNumIngreso.requestFocus();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        botones(false);
        btnGuardar.setText("Guardar");
        flag = "Guardar";
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //mostrar();
        limpiar();
        botones(true);
        btnGuardar.setText("Guardar");
        flag = "Guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void listadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoMouseClicked
        int fila = listado.rowAtPoint(evt.getPoint());
        lblIdArticulo.setText(listado.getValueAt(fila, 0).toString());
        jspCantidad.setValue(Integer.parseInt(listado.getValueAt(fila, 1).toString()));
        txtUnidad.setText(listado.getValueAt(fila, 2).toString());
        lblCodigoProducto.setText(listado.getValueAt(fila, 3).toString());
        lblArticulo.setText(listado.getValueAt(fila, 4).toString());
        txtReferencia.setText(listado.getValueAt(fila, 5).toString());
        txtObservacion.setText(listado.getValueAt(fila, 6).toString());
        txtMedida.setText(listado.getValueAt(fila, 7).toString());
        txtColor.setText(listado.getValueAt(fila, 8).toString());
        lblindiceselect.setText(String.valueOf(listado.getSelectedRow()));
        this.rem = true;
    }//GEN-LAST:event_listadoMouseClicked

    private void btnAddArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddArticuloActionPerformed
        if (!lblCodigoProducto.getText().equals("000")) {
            if (Integer.parseInt(jspCantidad.getValue().toString()) >= 1) {
                movimiento = new Movimiento();
                movimiento.setOperacion("ingreso");
                Calendar calendar = Calendar.getInstance();
                Timestamp fecha = new Timestamp(calendar.getTime().getTime());
                movimiento.setFechaRegistro(fecha);
                Configuracion conf = new Configuracion();
                movimiento.setNumIngreso(conf.generarCodigo(txtNumIngreso.getText().toUpperCase().trim()));
                movimiento.setReferencia(txtReferencia.getText().trim());
                movimiento.setCantidad(Integer.parseInt(jspCantidad.getValue().toString()));
                movimiento.setUnidad(txtUnidad.getText().trim());
                movimiento.setMedida(txtMedida.getText().trim());
                movimiento.setColor(txtColor.getText().trim());
                movimiento.setObservacion(txtObservacion.getText().trim());
                movimiento.setPersonal(user.getPersonal());
                movimiento.setProducto(tempProducto);
                templist.add(movimiento);
                mostrar(templist);
                limpiaradd();
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad debe de ser almenos 1");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar almenos un Articulo");
        }
    }//GEN-LAST:event_btnAddArticuloActionPerformed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        FormProductoListado form = new FormProductoListado(null, false, "ingreso");
        form.toFront();
        tempProducto = new Producto();
        form.tempProducto = tempProducto;
        form.setVisible(true);
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void listadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_listadoMousePressed

    private void btnRemoveArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveArticuloActionPerformed
        if (this.rem) {
            templist.remove(Integer.parseInt(lblindiceselect.getText()));
            mostrar(templist);
            limpiaradd();
            this.rem = false;
        } else {
            JOptionPane.showMessageDialog(null, "Debe selecionar un articulo de la lista");
        }
    }//GEN-LAST:event_btnRemoveArticuloActionPerformed

    private void txtNumIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumIngresoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddArticulo;
    private javax.swing.JButton btnBuscarArticulo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRemoveArticulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jspCantidad;
    public static javax.swing.JLabel lblArticulo;
    public static javax.swing.JLabel lblCodigoProducto;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdArticulo;
    private javax.swing.JLabel lblNumRegistro;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JLabel lblindiceselect;
    private javax.swing.JTable listado;
    private javax.swing.JLabel testoplano;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtNumIngreso;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
