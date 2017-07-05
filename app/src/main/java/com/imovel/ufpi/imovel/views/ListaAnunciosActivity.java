package com.imovel.ufpi.imovel.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.controller.ControleAnuncio;
import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaAnunciosActivity extends AppCompatActivity implements Serializable {
    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncios);


        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario.setName(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }
        ListView listaAnuncios = (ListView) findViewById(R.id.listViewAnuncios);

        this.listarAnuncios(listaAnuncios);
    }

    public void listarAnuncios(ListView listaAnuncios) {
        ControleAnuncio controleAnuncio = new ControleAnuncio();
        ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();

        anuncios = controleAnuncio.listar();
        if(anuncios.size() > 0) {
            ArrayAdapter<Anuncio> adapter = new ArrayAdapter<Anuncio>(this, android.R.layout.simple_list_item_1, anuncios);

            listaAnuncios.setAdapter(adapter);
        }

    }

    @Override
    public void onBackPressed() {

        String mensagem="Voltar para tela anterior.";
        Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_SHORT);
        toast.show();
    }

}
