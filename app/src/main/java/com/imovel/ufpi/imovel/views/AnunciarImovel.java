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
import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.utils.ClickRecyclerView_Interface;
import com.imovel.ufpi.imovel.utils.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnunciarImovel extends AppCompatActivity {
    private RecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;
    private List<Anuncio> anunciosAtivos = new ArrayList<Anuncio>();

    private void setMRecyclerView() {
        // Aqui é instanciado o Recyclerview
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_anunciarImovel);

        // configurando o gerenciador de layout para ser uma lista
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // adicionando o adapter que irá anexar os objetos à lista
        // criando uma lista vazia, que será preencida pelo proprio usuario
        mAdapter = new RecyclerAdapter(this, anunciosAtivos, (ClickRecyclerView_Interface) this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar_imovel);

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

}
