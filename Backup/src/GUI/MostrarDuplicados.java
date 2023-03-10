/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.TableModels.TableModelFicheros;
import Modelo.TableModels.TableModelBackups;
import Modelo.TableModels.BackUp;
import Modelo.OperacionesFicheros;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author rodrigo valdes
 */
public class MostrarDuplicados extends javax.swing.JDialog {
      private MostrarBackups parent;

    /**
     * Creates new form MostrarDuplicados
     */
    // EL PARENT SERÁ UN JDIALOG, NO UN JFRAME!
    public MostrarDuplicados(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = (MostrarBackups) parent;

        // Creamos un tableModelFicheros con la lista obtenida y lo asignamos al jTable de esta pantalla (podría estar vacía la lista si salta excepción)      
        TableModelFicheros tableModelFicheros = new TableModelFicheros(listaDuplicadosBackupSeleccionado());
        jTable_duplicados.setModel(tableModelFicheros);

        // Asignamos al jTable un objeto para poder ordenar por sus columnas el contenido
        TableRowSorter sorter = new TableRowSorter(tableModelFicheros);
        jTable_duplicados.setRowSorter(sorter);
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
        jTable_duplicados = new javax.swing.JTable();
        jB_volver = new javax.swing.JButton();
        jB_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setForeground(new java.awt.Color(0, 102, 102));

        jTable_duplicados.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jTable_duplicados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_duplicados);

        jB_volver.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jB_volver.setForeground(new java.awt.Color(0, 102, 102));
        jB_volver.setText("Volver");
        jB_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_volverActionPerformed(evt);
            }
        });

        jB_eliminar.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jB_eliminar.setForeground(new java.awt.Color(0, 102, 102));
        jB_eliminar.setText("Eliminar");
        jB_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jB_eliminar)
                .addGap(200, 200, 200)
                .addComponent(jB_volver)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_volver)
                    .addComponent(jB_eliminar))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_volverActionPerformed
        dispose();
    }//GEN-LAST:event_jB_volverActionPerformed

    private void jB_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_eliminarActionPerformed
        int[] filasSeleccionadasJTable = jTable_duplicados.getSelectedRows();

        if (filasSeleccionadasJTable.length == 0) {
            JOptionPane.showMessageDialog(parent, "No hay ningún elemento seleccionado.");
        } else {
            int confirmado = JOptionPane.showConfirmDialog(parent, "Los archivos seleccionados se borrarán definitivamente.\n"
                + "¿Estás seguro de que deseas continuar?", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirmado == JOptionPane.OK_OPTION) {
                // Filas seleccionadas en el tableModel
                int[] filasSeleccionadasTableModel = new int[filasSeleccionadasJTable.length];
                int contador = 0;
                for (int i : filasSeleccionadasJTable) {
                    filasSeleccionadasTableModel[contador] = jTable_duplicados.convertRowIndexToModel(i);
                    contador++;
                }
                // Borramos los ficheros 'físicos'
                TableModelFicheros tableModel = (TableModelFicheros) jTable_duplicados.getModel();
                for (int i : filasSeleccionadasTableModel) {
                    File ficheroABorrar = tableModel.getRow(i);
                    if (ficheroABorrar.exists()) {
                        ficheroABorrar.delete();
                    }
                }
                // Borramos las filas seleccionadas en el TableModel, DEBEN IR ORDENADAS
                Arrays.sort(filasSeleccionadasJTable);
                tableModel.removeRows(filasSeleccionadasTableModel);
                // Actualizamos la jTable
                refrescarTabla();
            }
        }
    }//GEN-LAST:event_jB_eliminarActionPerformed

      public List<File> listaDuplicadosBackupSeleccionado() {
        BackUp backupSeleccionado = backupSeleccionado();
        // De la ruta del directorio padre de todos los ficheros copiados listamos sólo los duplicados
        File directorioPadreBackup = new File(backupSeleccionado.getNombreDirectorioCreado());
        List<File> listaDuplicados = new ArrayList<>();
        try {
            listaDuplicados = OperacionesFicheros.listarDuplicados(directorioPadreBackup);
        } catch (IOException ex) {
            Logger.getLogger(MostrarDuplicados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDuplicados;
    }

    public BackUp backupSeleccionado() {
          int filaSeleccionadaJTableParent = this.parent.getjTable_backups().getSelectedRow();
        int filaSeleccionadaTableModelParent = this.parent.getjTable_backups().convertRowIndexToModel(filaSeleccionadaJTableParent);
        // Sacamos el tableModel del jTable de la pantalla de backups
        TableModelBackups tableModelParent = (TableModelBackups) this.parent.getjTable_backups().getModel();
       BackUp backupSeleccionado = tableModelParent.getRow(filaSeleccionadaTableModelParent);

        return backupSeleccionado;
    }

    public void refrescarTabla() {
        TableModelFicheros model = (TableModelFicheros) jTable_duplicados.getModel();
        model.refrescar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_eliminar;
    private javax.swing.JButton jB_volver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_duplicados;
    // End of variables declaration//GEN-END:variables
}
