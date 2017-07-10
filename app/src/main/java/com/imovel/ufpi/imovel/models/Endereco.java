package com.imovel.ufpi.imovel.models;

import java.io.Serializable;

/**
 * Created by josereis on 30/06/17.
 */

public class Endereco implements Serializable {
    private int CEP;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private double latitude;
    private double longitude;

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String toString() {
        return (this.rua + ", " + this.numero + ", " + this.bairro + ", " + this.cidade + "-" + this.estado + ".");
    }
}
