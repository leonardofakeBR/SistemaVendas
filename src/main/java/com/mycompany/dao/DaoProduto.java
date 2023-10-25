/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getConexao;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getStatement;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setStatement;
import java.sql.ResultSet;

/**
 *
 * @author jose_
 */
public class DaoProduto extends BancoDeDadosMySql{
    
    String sql;
    
    public Boolean inserir(int id, int idCategoria, int idMarca, String nome, String descricao, int preco){
        try{
            sql = "INSERT INTO PRODUTO (ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO) VALUES (?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idCategoria);
            getStatement().setInt(3,idMarca);
            getStatement().setString(4, nome);
            getStatement().setString(5, descricao);
            getStatement().setInt(6, preco);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int novoIdCategoria, int novoIdMarca, String novoNome, String novoDescricao, int novoPreco){
        try{
            sql = "UPDATE PRODUTO SET ID_CATEGORIA = ?, ID_MARCA = ?, NOME = ?, DESCRICAO = ?, PRECO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, novoIdCategoria);
            getStatement().setInt(3,novoIdMarca);
            getStatement().setString(4, novoNome);
            getStatement().setString(5, novoDescricao);
            getStatement().setInt(6, novoPreco);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM PRODUTO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarTodos(){
        try{
            sql = 
                " SELECT                            " +
                "   PR.ID,                          " +
                "   CA.NOME AS CATEGORIA,             " +
                "   MA.NOME AS MARCA,               " +
                "   PR.NOME AS PRODUTO,             " +
                "   PR.DESCRICAO AS DESCRICAO,                  " +
                "   PR.PRECO AS PRECO " +
                " FROM                              " +
                "   PRODUTO PR                     " +
                " JOIN CATEGORIA CA ON                " +
                "   CA.ID = PR.ID_CATEGORIA           " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = 
                " SELECT                            " +
                "   PR.ID,                          " +
                "   CA.NOME AS CATEGORIA,             " +
                "   MA.NOME AS MARCA,               " +
                "   PR.NOME AS PRODUTO,             " +
                "   PR.DESCRICAO AS DESCRICAO,                  " +
                "   PR.PRECO AS PRECO " +
                " FROM                              " +
                "   PRODUTO PR                     " +
                " JOIN CATEGORIA CA ON                " +
                "   CA.ID = PR.ID_CATEGORIA           " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNomeRua(String nomeRua){
        try{
            sql = 
                " SELECT                            " +
                "   PR.ID,                          " +
                "   CA.NOME AS CATEGORIA,             " +
                "   MA.NOME AS MARCA,               " +
                "   PR.NOME AS PRODUTO,             " +
                "   PR.DESCRICAO AS DESCRICAO,                  " +
                "   PR.PRECO AS PRECO " +
                " FROM                              " +
                "   PRODUTO PR                     " +
                " JOIN CATEGORIA CA ON                " +
                "   CA.ID = PR.ID_CATEGORIA           " +
                " WHERE                             " +
                "   PR.NOME LIKE ?              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nomeRua + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCep(String cep){
        try{
            sql = 
               " SELECT                            " +
                "   PR.ID,                          " +
                "   CA.NOME AS CATEGORIA,             " +
                "   MA.NOME AS MARCA,               " +
                "   PR.NOME AS PRODUTO,             " +
                "   PR.DESCRICAO AS DESCRICAO,                  " +
                "   PR.PRECO AS PRECO " +
                " FROM                              " +
                "   PRODUTO PR                     " +
                " JOIN CATEGORIA CA ON                " +
                "   CA.ID = PR.ID_CATEGORIA           " +
                " WHERE                             " +
                "   PR.DESCRICAO LIKE ?                   " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cep + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorPreco(String numerpResidencia){
        try{
            sql = 
                " SELECT                            " +
                "   PR.ID,                          " +
                "   CA.NOME AS CATEGORIA,             " +
                "   MA.NOME AS MARCA,               " +
                "   PR.NOME AS PRODUTO,             " +
                "   PR.DESCRICAO AS DESCRICAO,                  " +
                "   PR.PRECO AS PRECO " +
                " FROM                              " +
                "   PRODUTO PR                     " +
                " JOIN CATEGORIA CA ON                " +
                "   CA.ID = PR.ID_CATEGORIA           " +
                " WHERE                             " +
                "   PR.PRECO LIKE ?     " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, numerpResidencia + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCategoria(String categoria){
        try{
            sql = 
                " SELECT                            " +
                "   PR.ID,                          " +
                "   CA.NOME AS CATEGORIA,             " +
                "   MA.NOME AS MARCA,               " +
                "   PR.NOME AS PRODUTO,             " +
                "   PR.DESCRICAO AS DESCRICAO,                  " +
                "   PR.PRECO AS PRECO " +
                " FROM                              " +
                "   PRODUTO PR                     " +
                " JOIN CATEGORIA CA ON                " +
                "   CA.ID = PR.ID_CATEGORIA           " +
                " WHERE                             " +
                "   CA.NOME LIKE ?                 " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, categoria + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM PRODUTO";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}
