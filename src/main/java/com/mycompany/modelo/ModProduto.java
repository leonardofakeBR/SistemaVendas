/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author jose_
 */
public class ModProduto {
    private int id;
    private int idCategoria;
    private int idMarca;
    private String nome;
    private String descricao;
    private int preco;

    public ModProduto(int id, int idCategoria, String nome, String descricao, int preco) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public ModProduto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ModProduto{" + "id=" + id + ", idCategoria=" + idCategoria + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + '}';
    }

}
