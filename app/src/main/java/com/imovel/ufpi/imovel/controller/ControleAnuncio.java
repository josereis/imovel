package com.imovel.ufpi.imovel.controller;

import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.AnuncioAluguel;
import com.imovel.ufpi.imovel.models.Endereco;
import com.imovel.ufpi.imovel.models.Imovel;
import com.imovel.ufpi.imovel.models.Usuario;

import java.util.ArrayList;

/**
 * Created by josereis on 03/07/17.
 */

public class ControleAnuncio {
    private ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();

    public ControleAnuncio() {
        // criando endereço
        Endereco end = new Endereco();
        end.setEstado("PI");
        end.setNumero("1004");
        end.setCEP(64410000);
        end.setBairro("Areias");
        end.setCidade("Angical do Piauí");
        end.setRua("Rua Marcelino Sousa");

        // criando um usuario teste
        Usuario usuario = new Usuario();
        usuario.setEndereco(end);
        usuario.setName("José Reis Ribeiro Santiago");
        usuario.setEmail("jsribeirosantiago4@gmail.com");

        // criando um imovel 1
        Imovel imovel = new Imovel();
        imovel.setNumeroQuartos(3);
        imovel.setNumeroBanheiros(2);
        imovel.setEndereco(end);
        imovel.setDescricao("Imovel em otima condição, rescem reformado, bem arejado e em otima localização.");

        // anuncio 1
        Anuncio anuncio = new AnuncioAluguel();
        anuncio.setImovel(imovel);
        anuncio.setAnunciante(usuario);

        anuncios.add(anuncio);
    }

    public ArrayList<Anuncio> listar(){
        return anuncios;
    }
}
