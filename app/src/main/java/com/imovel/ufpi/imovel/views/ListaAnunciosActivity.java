package com.imovel.ufpi.imovel.views;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncios);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            int tipo = dadosUsuario.getInt("tipo");
            int quartos = dadosUsuario.getInt("quartos");
            int banheiros = dadosUsuario.getInt("banheiros");
            String cidade = dadosUsuario.getString("cidade");
            String estado = dadosUsuario.getString("estado");

            anuncios = (new ControleAnuncio()).busca(cidade, estado, tipo, quartos, banheiros);
            if(anuncios.size() > 0) {
                // tratamento dos casos quando possui uma quantidade de anuncios a ser exibida
                setMRecyclerView();
            } else {
                String mensagem="Não foi retornado o anuncio!";
                Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {
        try{
            Intent intent = new Intent(this, DashboardActivity.class);

            startActivity(intent);
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());

            // ocorreu um erro de autenticacao
            String msgErroAutenticacao = "ERRO: não foi possivel voltar a tela anterior";
            Toast toat1 = Toast.makeText(this, msgErroAutenticacao, Toast.LENGTH_LONG);
            toat1.show();
        }

    }

    /**
     * Método onde é tratado o click em um item da lista
     *
     * @param object
     */
    @Override
    public void onCustomClick(Object object) {
        Anuncio anuncio = (Anuncio) object;

        // verifica se o anuncio referente ao item da lista está sendo passado corretamente
        if(anuncio != null) {
            // cria um bundle para enviar informacoes do anuncio
            Bundle bundle = new Bundle();
            bundle.putSerializable("anuncio", anuncio);

            // codigo de tratamento da activite
            Intent intent = new Intent(this, ExibirAnuncio.class);

            intent.putExtras(bundle);

            startActivity(intent);
        } else {
            String mensagem = "ERRO: Não passou o Anuncio.";
            Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}
