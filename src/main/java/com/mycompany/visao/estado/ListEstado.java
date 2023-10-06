/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.estado;

import com.mycompany.visao.estado.*;
import com.mycompany.dao.DaoEstado;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModEstado;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leonardo.35903
 */
public class ListEstado extends javax.swing.JFrame {

    /**
     * Creates new form CadEstado
     */
    public ListEstado() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }

    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEstado.getModel();
            
            tableEstado.setModel(defaultTableModel);
            
            DaoEstado daoEstado = new DaoEstado();
            
            ResultSet resultSet = daoEstado.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int pId){
        try{
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_PAIS");
            defaultTableModel.addColumn("NOME");
            defaultTableModel.addColumn("UF");

            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            ResultSet resultSet = daoEstado.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
        public void listarPorNome(String pNome){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_PAIS");
            defaultTableModel.addColumn("NOME");
            defaultTableModel.addColumn("UF");
            
            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.listarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorPais(int pid_pais){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_PAIS");
            defaultTableModel.addColumn("NOME");
            defaultTableModel.addColumn("UF");
            
            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.listarPorPais(pid_pais);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorUf(String pUf){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_PAIS");
            defaultTableModel.addColumn("NOME");
            defaultTableModel.addColumn("UF");
            
            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.listarPorNome(pUf);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEstado = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "ID_PAIS", "NOME", "UF" }));

        tableEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_PAIS", "NOME", "UF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEstadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEstado);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfFiltro))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId(Integer.parseInt(tfFiltro.getText()));
                break;
            case 2:
                listarPorPais(Integer.parseInt(tfFiltro.getText()));
                break;                
            case 3:
                listarPorNome(tfFiltro.getText());
                break;
            case 4:
                listarPorUf(tfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEstadoMouseClicked
        // TODO add your handling code here:
         if (evt.getClickCount() == 2){
             ModEstado modEstado = new ModEstado();

            modEstado.setId(Integer.parseInt(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 0))));
            modEstado.setId_pais(Integer.parseInt(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 1))));
            modEstado.setNome(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 2)));
            modEstado.setUf(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 3)));

             DadosTemporarios.temObject = (ModEstado) modEstado;

            CadEstado cadEstado = new CadEstado();
            cadEstado.setVisible(true);
         }
    }//GEN-LAST:event_tableEstadoMouseClicked

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
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableEstado;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
