/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

/**
 *
 * @author Franz
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        miArchivo = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jmiSalidaProducto = new javax.swing.JMenu();
        jmiIngresoArticulos = new javax.swing.JMenuItem();
        jmiSalidaArticulo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        miProductos = new javax.swing.JMenuItem();
        miAlmacen = new javax.swing.JMenuItem();
        miCategoria = new javax.swing.JMenuItem();
        miMarca = new javax.swing.JMenuItem();
        miUnidad = new javax.swing.JMenuItem();
        miUnidad1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        miPersonal = new javax.swing.JMenuItem();
        miCargos = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miAutorizante = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miArea = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(0, 255, 255));

        miArchivo.setMnemonic('f');
        miArchivo.setText("Archivo");
        miArchivo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N

        exitMenuItem.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        miArchivo.add(exitMenuItem);

        menuBar.add(miArchivo);

        jmiSalidaProducto.setText("Movimiento");
        jmiSalidaProducto.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N

        jmiIngresoArticulos.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jmiIngresoArticulos.setText("Ingreso (PECOSA)");
        jmiIngresoArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIngresoArticulosActionPerformed(evt);
            }
        });
        jmiSalidaProducto.add(jmiIngresoArticulos);

        jmiSalidaArticulo.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jmiSalidaArticulo.setText("Salida (MEMO)");
        jmiSalidaArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalidaArticuloActionPerformed(evt);
            }
        });
        jmiSalidaProducto.add(jmiSalidaArticulo);

        menuBar.add(jmiSalidaProducto);

        jMenu2.setText("Mantenimiento");
        jMenu2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N

        jMenu6.setText("Productos");
        jMenu6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        miProductos.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miProductos.setText("Producto");
        miProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProductosActionPerformed(evt);
            }
        });
        jMenu6.add(miProductos);

        miAlmacen.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miAlmacen.setText("Almacen");
        miAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlmacenActionPerformed(evt);
            }
        });
        jMenu6.add(miAlmacen);

        miCategoria.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miCategoria.setText("Categoria");
        miCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriaActionPerformed(evt);
            }
        });
        jMenu6.add(miCategoria);

        miMarca.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miMarca.setText("Marca");
        miMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMarcaActionPerformed(evt);
            }
        });
        jMenu6.add(miMarca);

        miUnidad.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miUnidad.setText("Unidad");
        miUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUnidadActionPerformed(evt);
            }
        });
        jMenu6.add(miUnidad);

        miUnidad1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miUnidad1.setText("Tipo Producto");
        miUnidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUnidad1ActionPerformed(evt);
            }
        });
        jMenu6.add(miUnidad1);

        jMenu2.add(jMenu6);

        jMenu5.setText("Personal");
        jMenu5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        miPersonal.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miPersonal.setText("Personal");
        miPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPersonalActionPerformed(evt);
            }
        });
        jMenu5.add(miPersonal);

        miCargos.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miCargos.setText("Cargos");
        miCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCargosActionPerformed(evt);
            }
        });
        jMenu5.add(miCargos);

        jMenu2.add(jMenu5);

        jMenu7.setText("Autorizante");
        jMenu7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        miAutorizante.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miAutorizante.setText("Autorizante");
        miAutorizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAutorizanteActionPerformed(evt);
            }
        });
        jMenu7.add(miAutorizante);

        jMenu2.add(jMenu7);

        jMenu8.setText("Area");
        jMenu8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        miArea.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        miArea.setText("Area");
        miArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAreaActionPerformed(evt);
            }
        });
        jMenu8.add(miArea);

        jMenu2.add(jMenu8);

        menuBar.add(jMenu2);

        jMenu3.setText("Consultas");
        jMenu3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem1.setText("Area");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem2.setText("Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        menuBar.add(jMenu3);

        jMenu4.setText("Reportes");
        jMenu4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        menuBar.add(jMenu4);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jmiSalidaArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalidaArticuloActionPerformed
        FormGestionarSalidaArticulo form = new FormGestionarSalidaArticulo(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jmiSalidaArticuloActionPerformed

    private void miPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPersonalActionPerformed
        FormGestionarPersonal form = new FormGestionarPersonal(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miPersonalActionPerformed

    private void miCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCargosActionPerformed
        FormGestionarTipoPersonal form = new FormGestionarTipoPersonal(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miCargosActionPerformed

    private void jmiIngresoArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIngresoArticulosActionPerformed
        FormGestionarIngresoArticulo form = new FormGestionarIngresoArticulo(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_jmiIngresoArticulosActionPerformed

    private void miProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProductosActionPerformed
        FormGestionarProducto form = new FormGestionarProducto(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miProductosActionPerformed

    private void miAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlmacenActionPerformed
        FormGestionarAlmacen form = new FormGestionarAlmacen(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miAlmacenActionPerformed

    private void miCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriaActionPerformed
        FormGestionarCategoria form = new FormGestionarCategoria(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miCategoriaActionPerformed

    private void miMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMarcaActionPerformed
        FormGestionarMarca form = new FormGestionarMarca(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miMarcaActionPerformed

    private void miUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUnidadActionPerformed
        FormGestionarUnidad form = new FormGestionarUnidad(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miUnidadActionPerformed

    private void miAutorizanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAutorizanteActionPerformed
        FormGestionarAutorizante form = new FormGestionarAutorizante(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miAutorizanteActionPerformed

    private void miAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAreaActionPerformed
        FormGestionarArea form = new FormGestionarArea(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miAreaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         FormConsultaPorArea form = new FormConsultaPorArea(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         FormConsultaPorProducto form = new FormConsultaPorProducto(this, true,"");
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void miUnidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUnidad1ActionPerformed
      FormGestionarTipoProducto form = new FormGestionarTipoProducto(this, true);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_miUnidad1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmiIngresoArticulos;
    private javax.swing.JMenuItem jmiSalidaArticulo;
    private javax.swing.JMenu jmiSalidaProducto;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miAlmacen;
    private javax.swing.JMenu miArchivo;
    private javax.swing.JMenuItem miArea;
    private javax.swing.JMenuItem miAutorizante;
    private javax.swing.JMenuItem miCargos;
    private javax.swing.JMenuItem miCategoria;
    private javax.swing.JMenuItem miMarca;
    private javax.swing.JMenuItem miPersonal;
    private javax.swing.JMenuItem miProductos;
    private javax.swing.JMenuItem miUnidad;
    private javax.swing.JMenuItem miUnidad1;
    // End of variables declaration//GEN-END:variables

}
