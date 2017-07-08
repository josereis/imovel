package com.imovel.ufpi.imovel.models;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by josereis on 01/07/17.
 */

public abstract class Anuncio {
    private long id;
    private Imovel imovel;
    private Usuario anunciante;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Usuario getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Usuario anunciante) {
        this.anunciante = anunciante;
    }

}
