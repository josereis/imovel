package com.imovel.ufpi.imovel.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.controller.ControleAnuncio;
import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.Usuario;
import com.imovel.ufpi.imovel.utils.ClickRecyclerView_Interface;
import com.imovel.ufpi.imovel.utils.RecyclerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaAnunciosActivity extends AppCompatActivity implements ClickRecyclerView_Interface{
    private RecyclerAdapter adapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;
    private List<Anuncio> anuncios = new ArrayList<Anuncio>();

    public void setMRecyclerView() {
        // Aqui é instanciado o Recyclerview
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAnuncios);

        this.mLayoutManager = new LinearLayoutManager(this);
        this.mRecyclerView.setLayoutManager(mLayoutManager);

        this.adapter = new RecyclerAdapter(this, anuncios, this);
        mRecyclerView.setAdapter(adapter);
    }

    public void buscaAnuncios() {
        anuncios = (new ControleAnuncio()).listar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncios);

        anuncios = (new ControleAnuncio()).listar();
        if(anuncios.size() > 0) {

            // tratamento dos casos quando possui uma quantidade de anuncios a ser exibida

        } else {
            String mensagem="Não foi retornado o anuncio!";
            Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_SHORT);
            toast.show();
        }

        setMRecyclerView();
    }

    @Override
    public void onBackPressed() {
        String mensagem="Voltar para tela anterior.";
        Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Método onde é tratado o click em um item da lista
     * @param object
     */
    @Override
    public void onCustomClick(Object object) {

    }


}
