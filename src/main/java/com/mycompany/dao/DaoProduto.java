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
    
    private String sql; 
    
    public Boolean inserir(int id, int id_categoria, int id_marca, String nome, String descricao, float preco){
        try{
            sql = "INSERT INTO PRODUTO (ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO) VALUES (?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, id_categoria);
            getStatement().setString(3, nome);
            getStatement().setString(4, descricao);
            getStatement().setFloat(5, preco);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int novoId_categoria, int novoId_marca, String novoNome, String novoDescricao, float novoPreco){
        try{
            sql = "UPDATE PRODUTO SET ID_CATEGORIA = ?, ID_MARCA = ?, NOME = ?, DESCRICAO = ?, PRECO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(5, id);
            getStatement().setInt(1, novoId_categoria);
            getStatement().setString(2, novoNome);
            getStatement().setString(3, novoDescricao);
            getStatement().setFloat(4, novoPreco);
            
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
            sql = "SELECT ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO FROM PRODUTO";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO FROM PRODUTO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO FROM PRODUTO WHERE NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCategoria(int id_categoria){
        try{
            sql = "SELECT ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO FROM PRODUTO WHERE ID_CATEGORIA = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id_categoria);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorMarca(int cep){
        try{
            sql = "SELECT ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO FROM PRODUTO WHERE MARCA = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, cep);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
        public ResultSet listarPorDescricao(String descricao){
        try{
            sql = "SELECT ID, ID_CATEGORIA, ID_MARCA, NOME, DESCRICAO, PRECO FROM PRODUTO WHERE NUMERO_RESIDENCIA = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, descricao + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT MAX(ID) + 1 FROM PRODUTO";
            
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