package com.imovel.ufpi.imovel.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.AnuncioAluguel;
import com.imovel.ufpi.imovel.models.AnuncioCompra;

public class ExibirAnuncio extends AppCompatActivity {
    private Anuncio anuncio;
    private TextView anunciante, tipoAnuncio, descricao, endereco, valor, quantidadeQuartos, quantidadeBanheiros, quantidadeGaragens, area;
//
//    public void linkTextViews() {
//        area = (TextView) findViewById(R.id.textView_area);
//        valor = (TextView) findViewById(R.id.textView_preco);
//        endereco = (TextView) findViewById(R.id.textView_endereco);
//        descricao = (TextView) findViewById(R.id.textView_decricao);
//        tipoAnuncio = (TextView) findViewById(R.id.textView_aluguel_venda);
//        anunciante = (TextView) findViewById(R.id.textView_nome_anunciante);
//        quantidadeQuartos = (TextView) findViewById(R.id.textView_quantidade_quartos);
//        quantidadeGaragens = (TextView) findViewById(R.id.textView_quantidade_garagens);
//        quantidadeBanheiros = (TextView) findViewById(R.id.textView_quantidade_banheiros);
//
//        tipoValor = (TextView) findViewById(R.id.textView37);
//    }
//
//    public void setaTextViews() {
//        area.setText(""+anuncio.getImovel().getArea());
//        endereco.setText(anuncio.getImovel().toString());
//        descricao.setText(anuncio.getImovel().getDescricao());
//        anunciante.setText(anuncio.getAnunciante().getName());
//        quantidadeQuartos.setText(anuncio.getImovel().getNumeroQuartos());
//        quantidadeBanheiros.setText(anuncio.getImovel().getNumeroBanheiros());
//        quantidadeGaragens.setText(anuncio.getImovel().getNumeroVagasGaragem());
//
//        if(anuncio instanceof AnuncioAluguel) {
//            tipoAnuncio.setText("Aluguel");
//            tipoValor.setText("Valor Mensal (R$):");
//            valor.setText(""+((AnuncioAluguel)anuncio).getValorMensal());
//        } else {
//            tipoAnuncio.setText("Venda");
//            tipoValor.setText("Valor Imovel (R$):");
//            valor.setText(""+((AnuncioCompra)anuncio).getValorImovel());
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_anuncio);

        Bundle dadosAnuncio = getIntent().getExtras();
        if(dadosAnuncio != null) {
            anuncio = (Anuncio) dadosAnuncio.getSerializable("anuncio");

            quantidadeGaragens = (TextView) findViewById(R.id.textView_quantidade_garagens);
            quantidadeQuartos = (TextView) findViewById(R.id.textView_quantidade_quartos);
            quantidadeBanheiros = (TextView) findViewById(R.id.textView_quantidade_banheiros);
            tipoAnuncio = (TextView) findViewById(R.id.textView_aluguel_venda);
            anunciante = (TextView) findViewById(R.id.textView_nome_anunciante);
            descricao = (TextView) findViewById(R.id.textView_decricaoTitle);
            endereco = (TextView) findViewById(R.id.textView_endereco);
            valor = (TextView) findViewById(R.id.textView_preco);
            area = (TextView) findViewById(R.id.textView_area);

            anunciante.setText(anuncio.getAnunciante().getName());
            descricao.setText(anuncio.getImovel().getDescricao());
            endereco.setText(anuncio.getImovel().getEndereco().toString());
            quantidadeQuartos.setText(""+anuncio.getImovel().getNumeroQuartos());
            quantidadeBanheiros.setText(""+anuncio.getImovel().getNumeroBanheiros());
            quantidadeGaragens.setText(""+anuncio.getImovel().getNumeroVagasGaragem());
            area.setText(""+anuncio.getImovel().getArea());
            if(anuncio instanceof AnuncioAluguel) {
                tipoAnuncio.setText("ALUGUEL");
                valor.setText(""+((AnuncioAluguel) anuncio).getValorMensal());
            } else {
                tipoAnuncio.setText("VENDA");
                valor.setText(""+((AnuncioCompra) anuncio).getValorImovel());
            }
        } else {
            /**
             * para tratamento do erro de não se passado nada para a Activity
             */
        }
    }

    public void verMapa() {
        /**
         * Passa as coordenada do imovel para sua exibição no mapa
         */

        //caminho de acesso para latitude: anuncio.getImovel().getEndereco().getLatitude();
        //caminho de acesso para longitude: anuncio.getImovel().getEndereco().getLongitude();
    }

    public void contactar() {
        /**
         * Contacta via email o anunciante do referente imovel
         */
    }
}
