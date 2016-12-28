/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarProductoServicio;
import c3_dominio.Producto;
import java.util.List;
import javax.swing.JOptionPane;
 

/**
 *
 * @author Franz
 */
public class FormConsultaPorProducto extends javax.swing.JInternalFrame  {

    /**
     * Creates new form FormGestionarUnidad
     */
    private String flag = "principal";
    Producto producto;
    public Producto tempProducto;
    private GestionarProductoServicio gu;
    private List<Producto> productos;
    private String tipoForm;

    public FormConsultaPorProducto(java.awt.Frame parent, boolean modal,String value) {       
        initComponents();
        mostrar("principal");
        tempProducto = new Producto(); 
        tipoForm = "consulta";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        listado = new javax.swing.JTable();
        lblNumRegistro = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rbtPrincipal = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Productos de Almacen");

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

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel7.setText("Almacen :");

        buttonGroup1.add(rbtPrincipal);
        rbtPrincipal.setSelected(true);
        rbtPrincipal.setText("Principal");
        rbtPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtPrincipalMousePressed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Sotano");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton2MousePressed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Nombre" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumRegistro)
                        .addGap(338, 338, 338)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rbtPrincipal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButton2))
                                .addComponent(txtBuscar)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbtPrincipal)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtBuscar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumRegistro)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiar() {
        txtBuscar.setText("");

    }

    private void mostrar(String location) {
        try {
            gu = new GestionarProductoServicio();
            productos = gu.listar();
            productos = gu.listLocation(productos, location);
            gu.llenarLista(listado, productos);
            
            lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
     

    private void listadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoMouseClicked

    }//GEN-LAST:event_listadoMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        gu = new GestionarProductoServicio();
        try {
            //unidad.setUnidad(String.valueOf(evt.getKeyChar()));   
            if (jComboBox1.getSelectedItem().equals("Codigo")) {
                productos = gu.searchItems(flag, txtBuscar.getText(), jComboBox1.getSelectedItem().toString());
                gu.llenarLista(listado, productos);
                lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));
            } else {
                productos = gu.searchItems(flag, txtBuscar.getText(), jComboBox1.getSelectedItem().toString());
                gu.llenarLista(listado, productos);
                lblNumRegistro.setText("Nº Registros : " + String.valueOf(listado.getRowCount()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void listadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoMousePressed
         if (evt.getClickCount() == 2) {
            int fila = listado.getSelectedRow(); 
            if(listado.getRowCount()>0){
                tempProducto.setCodigo(listado.getValueAt(fila, 1).toString());  
                tempProducto.setCantidad(Integer.parseInt(listado.getValueAt(fila, 4).toString()));  
            }           
             
            if (tipoForm.equals("consulta")) { 
               FormConsultaProductoMovimiento form = new FormConsultaProductoMovimiento(null,true,tempProducto.getCodigo(),tempProducto.getCantidad());  
                FormPrincipal.escritorio.add(form); 
                form.toFront();
                form.show();
            } else {
                JOptionPane.showMessageDialog(null, "no es un formulairo");
            }  
        }
    }//GEN-LAST:event_listadoMousePressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbtPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtPrincipalMousePressed
        mostrar("principal");
        this.flag = "principal";
    }//GEN-LAST:event_rbtPrincipalMousePressed

    private void jRadioButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MousePressed
        mostrar("sotano");
        this.flag = "sotano";
    }//GEN-LAST:event_jRadioButton2MousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNumRegistro;
    private javax.swing.JTable listado;
    private javax.swing.JRadioButton rbtPrincipal;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
