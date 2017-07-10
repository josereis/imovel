package com.imovel.ufpi.imovel.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.controller.ControleAnuncio;
import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.Usuario;
import com.imovel.ufpi.imovel.utils.ClickRecyclerView_Interface;
import com.imovel.ufpi.imovel.utils.RecyclerAdapter;
import com.imovel.ufpi.imovel.utils.RecyclerAdapterAnunciar;

import java.util.ArrayList;
import java.util.List;

public class AnunciarImovel extends AppCompatActivity implements ClickRecyclerView_Interface {
    private Usuario usuario = new Usuario();
    private List<Anuncio> anuncios = new ArrayList<Anuncio>();

    private RecyclerAdapterAnunciar adapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;


    public void setMRecyclerView() {
        // Aqui é instanciado o Recyclerview
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_anunciarImovel);

        this.mLayoutManager = new LinearLayoutManager(this);
        this.mRecyclerView.setLayoutManager(mLayoutManager);

        this.adapter = new RecyclerAdapterAnunciar(this, anuncios, this);
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar_imovel);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario = (Usuario) dadosUsuario.getSerializable("usuario");
            anuncios = (new ControleAnuncio()).buscarAnuncioUsuario(usuario.getCPF());
        }

//        // chama função que verifica se ja existem anuncios
        setMRecyclerView();

        FloatingActionButton incluirAnuncio = (FloatingActionButton) findViewById(R.id.incluirAnuncio);
        incluirAnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onCustomClick(Object object) {

    }
}
