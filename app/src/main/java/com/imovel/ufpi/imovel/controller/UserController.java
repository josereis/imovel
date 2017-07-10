package com.imovel.ufpi.imovel.controller;

import com.imovel.ufpi.imovel.models.Endereco;
import com.imovel.ufpi.imovel.models.Usuario;

/**
 * Created by josereis on 30/06/17.
 */

public class UserController {
    public Usuario carregaUsuario(String user) {
        Usuario usuario = new Usuario();

        // implementa servico de busca de usuario por user
        if(user.equals("josereis")) {
            // criando endereço
            Endereco end = new Endereco();
            end.setEstado("PI");
            end.setNumero("1004");
            end.setCEP(64410000);
            end.setBairro("Areias");
            end.setCidade("Angical do Piauí");
            end.setRua("Rua Marcelino Sousa");

            // criando um usuario teste
            usuario.setEndereco(end);
            usuario.setCPF("055.739.763-46");
            usuario.setName("José Reis Ribeiro Santiago");
            usuario.setEmail("jsribeirosantiago4@gmail.com");
        } else {
            String msg = "ERRO: usuario não cadastrado!";
            System.out.println(msg);

            return null;
        }

        return usuario;
    }
}
