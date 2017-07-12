package com.imovel.ufpi.imovel.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.controller.ControleAnuncio;
import com.imovel.ufpi.imovel.models.Anuncio;
import com.imovel.ufpi.imovel.models.AnuncioAluguel;
import com.imovel.ufpi.imovel.models.AnuncioCompra;
import com.imovel.ufpi.imovel.models.Imovel;
import com.imovel.ufpi.imovel.models.Usuario;

public class ConfirmaAnuncioActivity extends AppCompatActivity {
    private Imovel imovel;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_anuncio);

        //pega dados do usuario corrente da aplicacao
        Bundle dados = getIntent().getExtras();
        if (dados != null){
            imovel = (Imovel) dados.getSerializable("imovel");
            usuario = (Usuario) dados.getSerializable("usuario");
        }
    }

    private int tipoAnuncio(RadioGroup tipoAnuncio) {
        if(tipoAnuncio.getCheckedRadioButtonId() == R.id.radioButton_venda) {
            return 2;
        } else if(tipoAnuncio.getCheckedRadioButtonId() == R.id.radioButton_aluguel) {
            return 1;
        } else {
            return 0;
        }
    }

    private void inserirAnuncio(Anuncio anuncio) {
        ControleAnuncio controleAnuncio = new ControleAnuncio();
        controleAnuncio.inserir(anuncio);
    }

    public void cadastrarAnuncio(View view) {
        EditText editTextValor = (EditText) findViewById(R.id.editText_valor);
        RadioGroup radioGroupTipoAnuncio = (RadioGroup) findViewById(R.id.radioGroup_tipo_anuncio);

        try {
            Anuncio anuncio;
            if(tipoAnuncio(radioGroupTipoAnuncio) == 1) {
                anuncio = new AnuncioAluguel();
                ((AnuncioAluguel)anuncio).setValorMensal(Double.parseDouble(editTextValor.getText().toString()));
            } else {
                anuncio = new AnuncioCompra();
                ((AnuncioCompra) anuncio).setValorImovel(Double.parseDouble(editTextValor.getText().toString()));
            }
            anuncio.setImovel(imovel);
            anuncio.setAnunciante(usuario);

            // insere anuncio na base de dados
            inserirAnuncio(anuncio);

            Bundle bundle = new Bundle();
            bundle.putSerializable("usuario", usuario);

            Intent intent = new Intent(this, AnunciarImovel.class);
            intent.putExtras(bundle);
            startActivity(intent);

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());

            // ocorreu um erro de autenticacao
            String msgErroAutenticacao = "ERRO: não foi possivel concluir a o cadastro.";
            Toast toat = Toast.makeText(this, msgErroAutenticacao, Toast.LENGTH_LONG);
            toat.show();
        }
    }
}
