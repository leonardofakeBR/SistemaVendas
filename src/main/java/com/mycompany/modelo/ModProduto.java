/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;


public class ModProduto {
    private int id;
    private int id_cidade;
    private String nome;
    private int id_categoria;
    private float preco;
    private String descricao;
    
    public ModProduto() {
    }

    public ModProduto(int id, int id_cidade, String nome,int id_categoria, float preco, String descricao) {
        this.id = id;
        this.id_cidade = id_cidade;
        this.nome = nome;
        this.id_categoria = id_categoria;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCep() {
        return id_categoria;
    }

    public void setCep(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", id_cidade=" + id_cidade + ", nome=" + nome + ", id_categoria=" + id_categoria + ", preco=" + preco + ", descricao=" + descricao + '}';
    }
}