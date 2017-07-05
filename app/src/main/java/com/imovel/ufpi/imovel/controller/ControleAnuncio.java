package com.imovel.ufpi.imovel.controller;

import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.AnuncioAluguel;
import com.imovel.ufpi.imovel.models.Imovel;

import java.util.ArrayList;

/**
 * Created by josereis on 03/07/17.
 */

public class ControleAnuncio {
    private ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();

    public ControleAnuncio() {
        // imovel 1
        Imovel imovel = new Imovel();

        imovel.setNumeroQuartos(3);
        imovel.setNumeroBanheiros(2);
        imovel.setDescricao("imovel 1");
        imovel.getEndereco().setEstado("PI");
        imovel.getEndereco().setCidade("Teresina");

        // anuncio 1
        Anuncio anuncio = new AnuncioAluguel();

        anuncio.setImovel(imovel);
        anuncio.setDescricao("Primeiro Anuncio Teste");

        anuncios.add(anuncio);
    }

    public ArrayList<Anuncio> listar(){
        return anuncios;
    }

    public ArrayList<Anuncio> buscar(int tipo, int quartos, int banheiros, String cidade, String estado) {
        ArrayList<Anuncio> result = new ArrayList<Anuncio>();

        if(tipo == 1) { // criar constante 1 para alugel
            for(Anuncio anuncio: anuncios) {
                if(anuncio instanceof AnuncioAluguel) {
                    if(anuncio.getImovel().getEndereco().getCidade().equals(cidade) && anuncio.getImovel().getEndereco().getEstado().equals(estado)
                            && quartos == anuncio.getImovel().getNumeroQuartos() && banheiros == anuncio.getImovel().getNumeroBanheiros()) {
                        result.add(anuncio);
                    }
                }
            }
        }

        return result;
    }
}
