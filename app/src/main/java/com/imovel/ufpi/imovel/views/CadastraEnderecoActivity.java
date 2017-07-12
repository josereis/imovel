package com.imovel.ufpi.imovel.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.models.Endereco;
import com.imovel.ufpi.imovel.models.Imovel;
import com.imovel.ufpi.imovel.models.Usuario;

public class CadastraEnderecoActivity extends AppCompatActivity {
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_endereco);

        //pega dados do usuario corrente da aplicacao
        Bundle dados = getIntent().getExtras();
        if (dados != null){
            usuario = (Usuario) dados.getSerializable("usuario");
        }
    }

    public void confirmarDadosImovel(View view) {
        EditText editTextCep = (EditText) findViewById(R.id.editText_cep);
        EditText editTextRua = (EditText) findViewById(R.id.editText_rua);
        EditText editTextNumero = (EditText) findViewById(R.id.editText_numero);
        EditText editTextBairro = (EditText) findViewById(R.id.editText_bairro);
        EditText editTextCidade = (EditText) findViewById(R.id.editText_cidade);
        EditText editTextEstado = (EditText) findViewById(R.id.editText_estado);

        EditText editTextArea = (EditText) findViewById(R.id.editText_area);
        EditText editTextQuartos = (EditText) findViewById(R.id.editText_quartos);
        EditText editTextGaragem = (EditText) findViewById(R.id.editText_garagem);
        EditText editTextBanheiro = (EditText) findViewById(R.id.editText_banheiros);
        EditText editTextDescricao = (EditText) findViewById(R.id.editText_descricao);

        try{
            // criando endereco do imovel
            Endereco end = new Endereco();
            end.setRua(editTextRua.getText().toString());
            end.setNumero(editTextNumero.getText().toString());
            end.setBairro(editTextBairro.getText().toString());
            end.setCidade(editTextCidade.getText().toString());
            end.setEstado(editTextEstado.getText().toString());
            end.setCEP(Integer.parseInt(editTextCep.getText().toString()));

            // criando imovel
            Imovel imovel = new Imovel();
            imovel.setEndereco(end);
            imovel.setDescricao(editTextDescricao.getText().toString());
            imovel.setArea(Double.parseDouble(editTextArea.getText().toString()));
            imovel.setNumeroQuartos(Integer.parseInt(editTextQuartos.getText().toString()));
            imovel.setNumeroBanheiros(Integer.parseInt(editTextBanheiro.getText().toString()));
            imovel.setNumeroVagasGaragem(Integer.parseInt(editTextGaragem.getText().toString()));

            Bundle bundle = new Bundle();
            bundle.putSerializable("imovel", imovel);
            bundle.putSerializable("usuario", usuario);

            Intent intent = new Intent(this, ConfirmaAnuncioActivity.class);
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

    @Override
    public void onBackPressed() {
        Bundle dadosUsuario = new Bundle();
        dadosUsuario.putSerializable("usuario", usuario);

        Intent intent = new Intent(this, AnunciarImovel.class);
        intent.putExtras(dadosUsuario);
        startActivity(intent);
    }
}
