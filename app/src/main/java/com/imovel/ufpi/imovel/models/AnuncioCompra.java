package com.imovel.ufpi.imovel.models;

import android.os.Parcel;

/**
 * Created by josereis on 01/07/17.
 */

public class AnuncioCompra extends Anuncio {
    private double valorImovel;

    public double getValorImovel() {
        return valorImovel;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public AnuncioCompra() {

    }

}
