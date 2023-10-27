/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.produto;

import com.mycompany.visao.produto.*;
import com.mycompany.dao.DaoCategoria;
import com.mycompany.dao.DaoProduto;
import com.mycompany.dao.DaoEstado;
import com.mycompany.dao.DaoMarca;
import com.mycompany.dao.DaoProduto;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModProduto;
import com.mycompany.modelo.ModEstado;
import com.mycompany.visao.categoria.ListCategoria;
import com.mycompany.visao.categoria.ListCategoria;
import com.mycompany.visao.estado.ListEstado;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jose_
 */
public class CadProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadProduto
     */
    public CadProduto() {
        initComponents();
        
        carregarCategorias();
        carregarMarcas();
        
        if(!existeDadosTemporarios()){
            DaoProduto daoProduto = new DaoProduto();

            int id = daoProduto.buscarProximoId(); 
            if (id > 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdCategoria();
        recuperaIdMarca();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfIdCategoria.setVisible(false);
        
        tfIdMarca.setVisible(false);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModProduto){
            int id = ((ModProduto) DadosTemporarios.tempObject).getId();
            int idCategoria = ((ModProduto) DadosTemporarios.tempObject).getIdCategoria();
            String nome = ((ModProduto) DadosTemporarios.tempObject).getNome();
            String descricao = ((ModProduto) DadosTemporarios.tempObject).getDescricao();
            Double preco = ((ModProduto) DadosTemporarios.tempObject).getPreco();
            
            tfId.setText(String.valueOf(id));
            tfIdCategoria.setText(String.valueOf(idCategoria));
            tfNome.setText(nome);
            taDescricao.setText(descricao);
            tfPreco.setText(String.valueOf(preco));
            
            jcbCategoria.setSelectedIndex(idCategoria - 1);
        
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }

    private void inserir(){
        DaoProduto daoProduto = new DaoProduto();
        
        if (daoProduto.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCategoria.getText()),Integer.parseInt(tfIdMarca.getText()), tfNome.getText(), taDescricao.getText(), Double.parseDouble(tfPreco.getText()))){
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoProduto.buscarProximoId()));
            tfNome.setText("");
            tfPreco.setText("");
            taDescricao.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o Produto!");
        }
    }
    
    private void alterar(){
        DaoProduto daoProduto = new DaoProduto();
        
        if (daoProduto.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCategoria.getText()), Integer.parseInt(tfIdMarca.getText()), tfNome.getText(), taDescricao.getText(), Double.parseDouble(tfPreco.getText()))){
            JOptionPane.showMessageDialog(null, "Produto alterada com sucesso!");
            
            tfNome.setText("");
            tfPreco.setText("");
            taDescricao.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Produto!");
        }
        
        ((ListEstado) Formularios.listEstado).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoProduto daoProduto = new DaoProduto();
        
        if (daoProduto.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            
            tfNome.setText("");
            tfPreco.setText("");
            taDescricao.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Produto!");
        }
        
        ((ListCategoria) Formularios.listCategoria).listarTodos();
        
        dispose();
    }
    
    private void carregarCategorias(){
        try{
            DaoCategoria daoCategoria = new DaoCategoria();

            ResultSet resultSet = daoCategoria.listarTodos();

            while(resultSet.next())
                jcbCategoria.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdCategoria(){
        try{
            DaoCategoria daoCategoria = new DaoCategoria();
            ResultSet resultSet = daoCategoria.listarPorNome(jcbCategoria.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCategoria.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
        private void carregarMarcas(){
        try{
            DaoMarca daoMarca = new DaoMarca();

            ResultSet resultSet = daoMarca.listarTodos();

            while(resultSet.next())
                jcbMarca.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdMarca(){
        try{
            DaoMarca daoMarca = new DaoMarca();
            ResultSet resultSet = daoMarca.listarPorNome(jcbMarca.getSelectedItem().toString());
            
            resultSet.next();
            tfIdMarca.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfIdCategoria = new javax.swing.JTextField();
        jcbMarca = new javax.swing.JComboBox<>();
        tfIdMarca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de endereço");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Categoria");

        jcbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoriaItemStateChanged(evt);
            }
        });
        jcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome");

        jLabel4.setText("Descrição");

        jLabel5.setText("Preço");

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jcbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMarcaItemStateChanged(evt);
            }
        });
        jcbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMarcaActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfNome)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAcao)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExcluir))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
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

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT)
            inserir();
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoriaItemStateChanged
        recuperaIdCategoria();
    }//GEN-LAST:event_jcbCategoriaItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadProduto = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o Produto?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCategoriaActionPerformed

    private void jcbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMarcaActionPerformed

    private void jcbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMarcaItemStateChanged
        // TODO add your handling code here:
        recuperaIdMarca();
    }//GEN-LAST:event_jcbMarcaItemStateChanged

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
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JComboBox<String> jcbMarca;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCategoria;
    private javax.swing.JTextField tfIdMarca;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
