/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author jose_
 */
public class ModPessoa {
    private int id;
    private int idEndereco;
    private int idEstadoCivil;
    private String nome;
    private String sobrenome;
    private String genero;
    private String telefone;
    private String email;

    public ModPessoa(int id, int idEndereco, int idEstadoCivil, String nome, String sobrenome, String genero, String telefone, String email) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.idEstadoCivil = idEstadoCivil;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
    }

    public ModPessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNomeRua() {
        return nome;
    }

    public void setNomeRua(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return sobrenome;
    }

    public void setCep(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumeroResidencia() {
        return genero;
    }

    public void setNumeroResidencia(String genero) {
        this.genero = genero;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ModEndereco{" + "id=" + id + ", idEndereco=" + idEndereco + ", nome=" + nome + ", sobrenome=" + sobrenome + 
                ", genero=" + genero + ", telefone=" + telefone + ", email=" + email + ", idEstadoCivil=" + idEstadoCivil + '}';
    }
}
