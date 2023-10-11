/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.endereco;

import com.mycompany.visao.endereco.*;
import com.mycompany.visao.endereco.*;
import com.mycompany.visao.endereco.*;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModEndereco;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leonardo.35903
 */
public class ListEndereco extends javax.swing.JFrame {

    /**
     * Creates new form CadEndereco
     */
    public ListEndereco() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }

    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEndereco.getModel();
            
            tableEndereco.setModel(defaultTableModel);
            
            DaoEndereco daoEndereco = new DaoEndereco();
            
            ResultSet resultSet = daoEndereco.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome_rua = resultSet.getString(3);
                String numero_rua = resultSet.getString(4);
                String cep = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome_rua, numero_rua, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int pId){
        try{
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_CIDADE");
            defaultTableModel.addColumn("NOME DA RUA");
            defaultTableModel.addColumn("NUMERO DA RESIDENCIA");
            defaultTableModel.addColumn("CEP");

            tableEndereco.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome_rua = resultSet.getString(3);
                String numero_rua = resultSet.getString(4);
                String cep = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome_rua, numero_rua, cep});
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
            defaultTableModel.addColumn("ID_CIDADE");
            defaultTableModel.addColumn("NOME DA RUA");
            defaultTableModel.addColumn("NUMERO DA RESIDENCIA");
            defaultTableModel.addColumn("CEP");

            
            tableEndereco.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEndereco.listarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome_rua = resultSet.getString(3);
                String numero_rua = resultSet.getString(4);
                String cep = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome_rua, numero_rua, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorCidade(int pid_cidade){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_CIDADE");
            defaultTableModel.addColumn("NOME DA RUA");
            defaultTableModel.addColumn("NUMERO DA RESIDENCIA");
            defaultTableModel.addColumn("CEP");

            
            tableEndereco.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEndereco.listarPorCidade(pid_cidade);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome_rua = resultSet.getString(3);
                String numero_rua = resultSet.getString(4);
                String cep = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome_rua, numero_rua, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNumero_rua(int pnumero_rua){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_CIDADE");
            defaultTableModel.addColumn("NOME DA RUA");
            defaultTableModel.addColumn("NUMERO DA RESIDENCIA");
            defaultTableModel.addColumn("CEP");

            
            tableEndereco.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEndereco.listarPorCidade(pnumero_rua);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome_rua = resultSet.getString(3);
                String numero_rua = resultSet.getString(4);
                String cep = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome_rua, numero_rua, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorCep(int pcep){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = new DefaultTableModel();

            defaultTableModel.addColumn("ID");
            defaultTableModel.addColumn("ID_CIDADE");
            defaultTableModel.addColumn("NOME DA RUA");
            defaultTableModel.addColumn("NUMERO DA RESIDENCIA");
            defaultTableModel.addColumn("CEP");

            
            tableEndereco.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEndereco.listarPorCidade(pcep);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id_pais = resultSet.getString(2);
                String nome_rua = resultSet.getString(3);
                String numero_rua = resultSet.getString(4);
                String cep = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, id_pais, nome_rua, numero_rua, cep});
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
        tableEndereco = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "ID_PAIS", "NOME", "UF" }));

        tableEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_CIDADE", "NOME DA RUA", "NUMERO DA RESIDENCIA", "CEP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEnderecoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEndereco);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                listarPorCidade(Integer.parseInt(tfFiltro.getText()));
                break;                
            case 3:
                listarPorNome(tfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEnderecoMouseClicked
        // TODO add your handling code here:
         if (evt.getClickCount() == 2){
             ModEndereco modEndereco = new ModEndereco();

            modEndereco.setId(Integer.parseInt(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 0))));
            modEndereco.setId_cidade(Integer.parseInt(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 1))));
            modEndereco.setNome_rua(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 2)));

             DadosTemporarios.temObject = (ModEndereco) modEndereco;

            CadEndereco cadEndereco = new CadEndereco();
            cadEndereco.setVisible(true);
         }
    }//GEN-LAST:event_tableEnderecoMouseClicked

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
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ListEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableEndereco;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
