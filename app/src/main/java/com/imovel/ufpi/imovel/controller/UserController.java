package com.imovel.ufpi.imovel.controller;

import com.imovel.ufpi.imovel.models.Usuario;

/**
 * Created by josereis on 30/06/17.
 */

public class UserController {
    public Usuario carregaUsuario(String user) {
        Usuario usuario = new Usuario();

        // implementa servico de busca de usuario por user

        if(user.equals("josereis")) {
            usuario.setName("José Reis Ribeiro Santiago");
            usuario.setEmail("josereis@imovel.com.br");
            usuario.setPassword("josereis");
            usuario.setSexo("Masculino");

            // setando as informacoes referentes ao endereco do usuario
            usuario.getEndereco().setRua("Rua Marcelino Sousa");
            usuario.getEndereco().setNumero("1004");
            usuario.getEndereco().setBairro("Areias");
        } else {
            String msg = "ERRO: usuario não cadastrado!";
            System.out.println(msg);

            return null;
        }

        return usuario;
    }
}
