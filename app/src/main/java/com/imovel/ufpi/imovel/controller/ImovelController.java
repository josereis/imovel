package com.imovel.ufpi.imovel.controller;

import com.imovel.ufpi.imovel.models.Imovel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josereis on 02/07/17.
 */

public class ImovelController {
    private List<Imovel> imoveis = new ArrayList<Imovel>();

    public Imovel buscar(long id) {
        for(Imovel imovel: imoveis) {
            if(imovel.getId() == id) {
                return imovel;
            }
        }

        return null;
    }

    public ImovelController() {
        criaImoveisTeste();
    }

    public void criaImoveisTeste() {
        Imovel imovel1 = new Imovel(), imovel2 = new Imovel(), imovel3 = new Imovel(), imovel4 = new Imovel();

        // setando dados do imovel1
        imovel1.setId(1);
        imovel1.setArea(96.5);
        imovel1.setDescricao("Descrição qualquer 1");
        // informações de endereco
        imovel1.getEndereco().setCidade("Teresina");
        imovel1.getEndereco().setEstado("PI");
        // dados para pesquisa relacionada ao imovel
        imovel1.setNumeroQuartos(2);
        imovel1.setNumeroBanheiros(2);
        imovel1.setNumeroVagasGaragem(1);

        // setando dados do imovel2
        imovel2.setId(2);
        imovel2.setArea(76);
        imovel2.setDescricao("Descrição qualquer 2");
        // informações de endereco
        imovel2.getEndereco().setCidade("Teresina");
        imovel2.getEndereco().setEstado("PI");
        // dados para pesquisa relacionada ao imovel
        imovel2.setNumeroQuartos(2);
        imovel2.setNumeroBanheiros(1);
        imovel2.setNumeroVagasGaragem(1);

        // setando dados do imovel1
        imovel3.setId(3);
        imovel3.setArea(100);
        imovel3.setDescricao("Descrição qualquer 3");
        // informações de endereco
        imovel3.getEndereco().setCidade("Teresina");
        imovel3.getEndereco().setEstado("PI");
        // dados para pesquisa relacionada ao imovel
        imovel3.setNumeroQuartos(3);
        imovel3.setNumeroBanheiros(2);
        imovel3.setNumeroVagasGaragem(2);

        // setando dados do imovel1
        imovel4.setId(4);
        imovel4.setArea(125.5);
        imovel4.setDescricao("Descrição qualquer 1");
        // informações de endereco
        imovel4.getEndereco().setCidade("Teresina");
        imovel4.getEndereco().setEstado("PI");
        // dados para pesquisa relacionada ao imovel
        imovel4.setNumeroQuartos(3);
        imovel4.setNumeroBanheiros(3);
        imovel4.setNumeroVagasGaragem(2);

        // adicionando imoveis na lista
        imoveis.add(imovel1);
        imoveis.add(imovel2);
        imoveis.add(imovel3);
        imoveis.add(imovel4);
    }
}
