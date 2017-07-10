package com.imovel.ufpi.imovel.models;

import android.os.Parcel;

/**
 * Created by josereis on 01/07/17.
 */

public class AnuncioAluguel extends Anuncio {
    private double valorMensal;

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public AnuncioAluguel() {

    }

}
