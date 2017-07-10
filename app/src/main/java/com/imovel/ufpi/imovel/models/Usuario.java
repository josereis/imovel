package com.imovel.ufpi.imovel.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by josereis on 30/06/17.
 */

public class Usuario implements Serializable {
    private String CPF;
    private String sexo;
    private String name;
    private String email;
    private List<Anuncio> anuncios;
    private Endereco endereco = new Endereco();

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
