/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros.cliente;

import com.mycompany.dao.DaoProduto;
import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModPais;
import com.mycompany.modelo.ModProduto;
import com.mycompany.visao.cidade.CadCidade;
import com.mycompany.visao.pais.CadPais;
import com.mycompany.visao.pessoa.CadPessoa;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 10156
 */
public class MenuPrincipalCliente extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipalCliente() {
        initComponents();
        
        Formularios.menuPrincipalCliente = this;
        
        setLocationRelativeTo(null);
        
        setExtendedState(MAXIMIZED_BOTH);
        
        if (!BancoDeDadosMySql.conectar()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados. O sistema será finalizado.");
            System.exit(0);
        }
        
        labelUsuarioLogado.setText("");
    }

    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String nome = resultSet.getString(4);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{nome, preco});
            }
        }catch(Exception e){
            
        }
    }
    
    public void listarPorProduto(String pProduto){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorNome(pProduto);
            
            defaultTableModel.setRowCount(0);
            
            while (resultSet.next()){
                String nome = resultSet.getString(4);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{nome, preco});
            }
        }catch(Exception e){
            
        }
    }
    
    public void verificaUsuarioLogado(){
        if(!DadosTemporarios.usuarioLogado.equals("")){
            labelUsuarioLogado.setText(Constantes.PREFIXO_USUARIO_LOGADO + DadosTemporarios.usuarioLogado);
            
            labelEntrar.setText(Constantes.LABEL_SAIR);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelCadastrar = new javax.swing.JLabel();
        labelEntrar = new javax.swing.JLabel();
        labelUsuarioLogado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tfPesquisaProduto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 87, 87));

        labelCadastrar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        labelCadastrar.setText("Cadastrar   |");
        labelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCadastrarMouseClicked(evt);
            }
        });

        labelEntrar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        labelEntrar.setText("Entrar");
        labelEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEntrarMouseClicked(evt);
            }
        });

        labelUsuarioLogado.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        labelUsuarioLogado.setText("Usuário logado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addGap(186, 186, 186)
                .addComponent(labelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCadastrar)
                    .addComponent(labelEntrar)
                    .addComponent(labelUsuarioLogado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 87, 87));

        tfPesquisaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfPesquisaProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPesquisaProduto)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 87, 87));

        tableProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduto.getTableHeader().setReorderingAllowed(false);
        tableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduto);
        if (tableProduto.getColumnModel().getColumnCount() > 0) {
            tableProduto.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(DadosTemporarios.usuarioLogado != null){
            if(tfPesquisaProduto.getText().equals(""))
                listarTodos();
            else
                listarPorProduto(tfPesquisaProduto.getText());
        }else{
            JOptionPane.showMessageDialog(null, "Você ainda não está logado. Por favor, realize o login antes de realizar esta operação!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void labelEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEntrarMouseClicked
        if(labelEntrar.getText().equals(Constantes.LABEL_ENTRAR)){
            if (Formularios.telaLogin == null)
                Formularios.telaLogin = new TelaLogin();

            Formularios.telaLogin.setModal(true);
            Formularios.telaLogin.setVisible(true);
        }else{
            int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        Constantes.PERGUNTA_ENCERRAR_SESSAO);
        
            if(escolha == JOptionPane.YES_OPTION){
                DadosTemporarios.idUsuarioLogado = -1;
                DadosTemporarios.usuarioLogado = null;
                labelEntrar.setText(Constantes.LABEL_ENTRAR);
                labelUsuarioLogado.setText("");
                
                ((DefaultTableModel) tableProduto.getModel()).setNumRows(0);
            }
        }
    }//GEN-LAST:event_labelEntrarMouseClicked

    private void tableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModProduto modProduto = new ModProduto();
                DaoProduto daoProduto = new DaoProduto();
                
                ResultSet resultSet = daoProduto.listarPorNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0)));
                
                resultSet.next();
                
                int id  = resultSet.getInt("ID");
                String categoria = resultSet.getString("CATEGORIA");
                String marca = resultSet.getString("MARCA");
                String descricao = resultSet.getString("DESCRICAO");
                
                System.out.println(categoria);
                System.out.println(marca);
                
                modProduto.setId(id);
                modProduto.setNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0)));
                modProduto.setPreco(Double.parseDouble(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 1))));
                modProduto.setDescricao(descricao);
                
                DadosTemporarios.tempObject = (ModProduto) modProduto;
                DadosTemporarios.categoriaProdutoVenda = categoria;
                DadosTemporarios.marcaProdutoVenda = marca;
                
                if (Formularios.telaVenda == null){
                    Formularios.telaVenda = new TelaVenda();
                    Formularios.telaVenda.setVisible(true);
                }else{
                    int escolha = 
                        JOptionPane.showConfirmDialog(
                            null, 
                            "Existe uma compra em andamento, deseja cancelá-la?");
                    
                    if(escolha == JOptionPane.YES_OPTION){
                        Formularios.telaVenda.dispose();
                        Formularios.telaVenda = null;

                        Formularios.telaVenda = new TelaVenda();
                        Formularios.telaVenda.setVisible(true);
                    }else{
                        Formularios.telaVenda.setVisible(true);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tableProdutoMouseClicked

    private void labelCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastrarMouseClicked
        if (Formularios.cadPessoa == null)
            Formularios.cadPessoa = new CadPessoa();

        Formularios.cadPessoa.setVisible(true);
    }//GEN-LAST:event_labelCadastrarMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCadastrar;
    private javax.swing.JLabel labelEntrar;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JTable tableProduto;
    private javax.swing.JTextField tfPesquisaProduto;
    // End of variables declaration//GEN-END:variables
}
