/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Alumno;
import gui.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import logicanegocio.logicadenegocio;
import static logicanegocio.logicadenegocio.listaAlumnos;
//me da error al importar el javax.help
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.UIManager.LookAndFeelInfo;


/**
 *
 * @author rodrigo valdes
 */
public class Menu extends javax.swing.JFrame {
//DAR DE BAJA VALIDACIONES LOOKANDFEEL FILTRO
    /*
    public void FILTRO() {
                var txt = txtSearch.getText().toLowerCase();
                if (txt.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + txt, SearchColumnIndex));
                    } catch (PatternSyntaxException pse) {
                        System.out.println("Bad regex pattern");
                    }
                }

    */
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        refrescarTabla();
        ponLaAyuda();
        this.setResizable(false);
        
        //Crear campo de texto para buscar, un combobox con el nº de filas sel
        
    }
//    //Importar SeaGlassLookAndFeel
//     private void cambiarLookAndFeel(){
//        try { 
//            UIManager.setLookAndFeel(SeaGlassLookAndFeel.class.getCanonicalName());
//            SwingUtilities.updateComponentTreeUI(this);            
//        } catch (Throwable ex) {
//            JOptionPane.showInternalMessageDialog(this, "Error al establecer LookAndFeel","Error",JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    private void refrescarTabla() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"DNI", "Nombre", "Apellido1", "Apellido2", "Teléfono", "Email", "Calle", "Localidad", "Provincia", "CP", "Fecha de Alta", "Fecha última facturación"});
        
        List<Alumno> listaAlumnos = logicadenegocio.getListaAlumnos();
        for(Alumno alumno : listaAlumnos)
        {
        dtm.addRow(alumno.toArrayString());
    }
         jTableAlumnos.setModel(dtm);
        }
               
    private void eliminarElemento() {
           DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"DNI", "Nombre", "Apellido1", "Apellido2", "Teléfono", "Email", "Calle", "Localidad", "Provincia", "CP", "Fecha de Alta", "Fecha última facturación"});
        
        List<Alumno> listaAlumnos = logicadenegocio.getListaAlumnos();
        for(Alumno alumno : listaAlumnos)
        {
        dtm.removeRow(jTableAlumnos.getSelectedRow());
    }
         jTableAlumnos.setModel(dtm);
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
        jTableAlumnos = new javax.swing.JTable();
        jTextFieldBuscar = new javax.swing.JTextField();
        jComboBoxColumnas = new javax.swing.JComboBox<>();
        jButtonBuscar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jComboBoxLookAndFeel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAlumnos = new javax.swing.JMenu();
        jMenuItemAlta = new javax.swing.JMenuItem();
        jMenuItemBaja = new javax.swing.JMenuItem();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAyudaPrin = new javax.swing.JMenuItem();
        jMenuItemAyudaAlta = new javax.swing.JMenuItem();
        jMenuItemAySimple = new javax.swing.JMenuItem();
        jMenuItemAyLaF = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        jScrollPane1.setViewportView(jTableAlumnos);

        jTextFieldBuscar.setText("Filtro");

        jComboBoxColumnas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonBuscar.setText("Buscar");

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jComboBoxLookAndFeel.setFont(new java.awt.Font("Ebrima", 1, 10)); // NOI18N
        jComboBoxLookAndFeel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxLookAndFeel.setToolTipText("Elige apariencia de la app");
        jComboBoxLookAndFeel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLookAndFeelActionPerformed(evt);
            }
        });

        jLabel3.setText("Cambiar Look and Feel");

        jMenuAlumnos.setText("Alumnos");

        jMenuItemAlta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAlta.setText("Darse de alta...");
        jMenuItemAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaActionPerformed(evt);
            }
        });
        jMenuAlumnos.add(jMenuItemAlta);

        jMenuItemBaja.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBaja.setText("Darse de baja...");
        jMenuItemBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBajaActionPerformed(evt);
            }
        });
        jMenuAlumnos.add(jMenuItemBaja);

        jMenuItemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jMenuAlumnos.add(jMenuItemModificar);

        jMenuBar1.add(jMenuAlumnos);

        jMenu1.setText("Ayuda");

        jMenuItemAyudaPrin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAyudaPrin.setText("Mostrar Ayuda Principal");
        jMenuItemAyudaPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAyudaPrinActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAyudaPrin);

        jMenuItemAyudaAlta.setText("Mostrar Ayuda Alta");
        jMenuItemAyudaAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAyudaAltaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAyudaAlta);

        jMenuItemAySimple.setText("Ayuda Simple");
        jMenuItemAySimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAySimpleActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAySimple);

        jMenuItemAyLaF.setText("Ayuda LaF");
        jMenu1.add(jMenuItemAyLaF);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jComboBoxColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBorrar)
                        .addGap(80, 80, 80)
                        .addComponent(jButtonBuscar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonBorrar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaActionPerformed

        EncuestaAlta enalta = new EncuestaAlta(this,true);
        enalta.setVisible(true);
        refrescarTabla();
    }//GEN-LAST:event_jMenuItemAltaActionPerformed

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarActionPerformed
 int alumnoseleccion = jTableAlumnos.getSelectedRow();
 Alumno alumnoseleccionado = logicadenegocio.getListaAlumnos().get(alumnoseleccion);
 EncuestaAlta enalta = new EncuestaAlta(this,true, alumnoseleccionado);
        enalta.setVisible(true);
        enalta.setLocationRelativeTo(null);
        refrescarTabla();
    }//GEN-LAST:event_jMenuItemModificarActionPerformed

 
 

   
 
    
    /* public void eliminarFilas(){  //JTable jTableAlumnos //Sin Uso
      int alumnoseleccion = jTableAlumnos.getSelectedRow();
   DefaultTableModel dtm = (DefaultTableModel) this.jTableAlumnos.getModel();
   int[] rows = jTableAlumnos.getSelectedRows();
   for(int i=0;i<rows.length;i++){
     dtm.removeRow(rows[i]-i);
   }
  }
 */
    private void jMenuItemBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBajaActionPerformed
  DefaultTableModel dtm = (DefaultTableModel) jTableAlumnos.getModel();
//debería coger la fila seleccionada y borrarla
      //Alumno alumnoseleccionado = logicadenegocio.getListaAlumnos().get(alumnoseleccion);
      //EncuestaAlta enalta = new EncuestaAlta(this,true, alumnoseleccionado);
        //enalta.setVisible(true);
        if (jTableAlumnos.getSelectedRowCount()== 1) {
         dtm.removeRow(jTableAlumnos.getSelectedRow());         //borra la fila
         //fireTableRowsDeleted(row, row);    //Notifica a todos los listeners que las filas dentro del rango [firstRow, lastRow], inclusive, han sido eliminadas
         eliminarElemento();//Notifica a todos los listeners que el valor de la tabla ha cambiado (con esto saltan las acciones necesarias como repintar la tabla
      }else {
            if(jTableAlumnos.getSelectedRow() == 0) {
                JOptionPane.showMessageDialog(this, "No hay elementos en la lista para borrar");
            }else {
                JOptionPane.showMessageDialog(this, "Cree un elemento para poder borrarlo");
            }
        }
    }//GEN-LAST:event_jMenuItemBajaActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
    DefaultTableModel dtm = (DefaultTableModel) jTableAlumnos.getModel();
//debería coger la fila seleccionada y borrarla
      //Alumno alumnoseleccionado = logicadenegocio.getListaAlumnos().get(alumnoseleccion);
      //EncuestaAlta enalta = new EncuestaAlta(this,true, alumnoseleccionado);
        //enalta.setVisible(true);
        if (jTableAlumnos.getSelectedRowCount()== 1) {
         dtm.removeRow(jTableAlumnos.getSelectedRow());         //borra la fila
         //fireTableRowsDeleted(row, row);    //Notifica a todos los listeners que las filas dentro del rango [firstRow, lastRow], inclusive, han sido eliminadas
  //Notifica a todos los listeners que el valor de la tabla ha cambiado (con esto saltan las acciones necesarias como repintar la tabla
      }else {
            if(jTableAlumnos.getSelectedRow() == 0) {
                JOptionPane.showMessageDialog(this, "No hay elementos en la lista para borrar");
            }else {
                JOptionPane.showMessageDialog(this, "Cree un elemento para poder borrarlo");
            }
        }
    }//GEN-LAST:event_jButtonBorrarActionPerformed
     private void ponLaAyuda()  {
         try {
             ClassLoader cl = Menu.class.getClassLoader();
      File fichero = new File("help" +File.separator+ "help_set.hs");
URL hsURL = fichero.toURI().toURL();
//no me deja importar el helpset y helpbroker 
HelpSet hs = new HelpSet(getClass().getClassLoader(), hsURL);
HelpBroker hb = hs.createHelpBroker();
hb.enableHelpOnButton(jMenuItemAySimple, "main", hs);
hb.enableHelpOnButton(jMenuItemAyLaF, "Apariencia", hs);
hb.enableHelpOnButton(jMenuItemAyudaAlta, "alta", hs);
hb.enableHelpOnButton(jMenuItemAyudaPrin, "principal", hs);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
    }
    private void jMenuItemAyudaPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAyudaPrinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAyudaPrinActionPerformed

    private void jMenuItemAyudaAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAyudaAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAyudaAltaActionPerformed

    private void jMenuItemAySimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAySimpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAySimpleActionPerformed

    private void jComboBoxLookAndFeelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLookAndFeelActionPerformed
        try {
            LookAndFeelInfo lookAndFeel = UIManager.getInstalledLookAndFeels()[jComboBoxLookAndFeel.getSelectedIndex()];
            UIManager.setLookAndFeel(lookAndFeel.getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Throwable e){
            System.out.println("Error");
        }
    }//GEN-LAST:event_jComboBoxLookAndFeelActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JComboBox<String> jComboBoxColumnas;
    private javax.swing.JComboBox<String> jComboBoxLookAndFeel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuAlumnos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAlta;
    private javax.swing.JMenuItem jMenuItemAyLaF;
    private javax.swing.JMenuItem jMenuItemAySimple;
    private javax.swing.JMenuItem jMenuItemAyudaAlta;
    private javax.swing.JMenuItem jMenuItemAyudaPrin;
    private javax.swing.JMenuItem jMenuItemBaja;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables

   
}
