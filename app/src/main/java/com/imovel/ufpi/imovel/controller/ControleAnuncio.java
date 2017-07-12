package com.imovel.ufpi.imovel.controller;

import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.AnuncioAluguel;
import com.imovel.ufpi.imovel.models.AnuncioCompra;
import com.imovel.ufpi.imovel.models.Endereco;
import com.imovel.ufpi.imovel.models.Imovel;
import com.imovel.ufpi.imovel.models.Usuario;

import java.util.ArrayList;

/**
 * Created by josereis on 03/07/17.
 */

public class ControleAnuncio {
    private final int ALUGUEL = 1;
    private long ids = 1;
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
//        end.setLatitude();
//        end.setLongitude();

        // criando um usuario teste
        Usuario usuario = new Usuario();
        usuario.setEndereco(end);
        usuario.setCPF("055.739.763-46");
        usuario.setName("José Reis Ribeiro Santiago");
        usuario.setEmail("jsribeirosantiago4@gmail.com");

        // criando um imovel 1
        Imovel imovel = new Imovel();
        imovel.setNumeroQuartos(3);
        imovel.setNumeroBanheiros(2);
        imovel.setNumeroVagasGaragem(2);
        imovel.setEndereco(end);
        imovel.setArea(95.4);
        imovel.setDescricao("Imovel em otima condição, rescem reformado, bem arejado e em otima localização.");

        // anuncio 1
        Anuncio anuncio = new AnuncioAluguel();
        anuncio.setImovel(imovel);
        anuncio.setAnunciante(usuario);
        ((AnuncioAluguel) anuncio).setValorMensal(1235.00);

        anuncios.add(anuncio);
    }

    public ArrayList<Anuncio> listar(){
        return anuncios;
    }

    public void inserir(Anuncio anuncio) {
        if(anuncio != null) {
            anuncios.add(anuncio);
        }
    }

    public void remover(Anuncio anuncio) {
        if(anuncio != null) {
            anuncios.remove(anuncio);
        }
    }

    public ArrayList<Anuncio> buscarAnuncioUsuario(String cpf) {
        ArrayList<Anuncio> result = new ArrayList<Anuncio>();

        for (Anuncio anuncio: anuncios) {
            if(anuncio.getAnunciante().getCPF().equals(cpf)) {
                result.add(anuncio);
            }
        }

        return result;
    }

    private ArrayList<Anuncio> buscaAlugueis(int quartos, int banheiros, String cidade, String estado) {
        ArrayList<Anuncio> result = new ArrayList<Anuncio>();
        for(Anuncio anuncio: anuncios) {
            if(anuncio instanceof AnuncioAluguel) {
                if(anuncio.getImovel().getEndereco().getCidade().equals(cidade) && anuncio.getImovel().getEndereco().getEstado().equals(estado)) {
                    if(quartos==anuncio.getImovel().getNumeroQuartos() && banheiros==anuncio.getImovel().getNumeroBanheiros()) {
                        result.add(anuncio);
                    }
                }
            }
        }
        return result;
    }

    private ArrayList<Anuncio> buscaComprar(int quartos, int banheiros, String cidade, String estado) {
        ArrayList<Anuncio> result = new ArrayList<Anuncio>();
        for(Anuncio anuncio: anuncios) {
            if(anuncio instanceof AnuncioCompra) {
                if(anuncio.getImovel().getEndereco().getCidade().equals(cidade) && anuncio.getImovel().getEndereco().getEstado().equals(estado)) {
                    if(quartos==anuncio.getImovel().getNumeroQuartos() && banheiros==anuncio.getImovel().getNumeroBanheiros()) {
                        result.add(anuncio);
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<Anuncio> busca(String cidade, String estado, int tipo, int quartos, int banheiros) {
        if(tipo==ALUGUEL) {
            return buscaAlugueis(quartos, banheiros, cidade, estado);
        } else {
            return buscaComprar(quartos, banheiros, cidade, estado);
        }
    }
}
