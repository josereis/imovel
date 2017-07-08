package com.imovel.ufpi.imovel.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.models.Usuario;

public class DashboardActivity extends AppCompatActivity {
    private Usuario usuario = new Usuario();
    private Bundle bundleUsuario = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario.setName(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }

        //carrega o bundle de Usuario para passar dados entre as Activities
        bundleUsuario.putString("nomeUsuario", usuario.getName());
        bundleUsuario.putString("emailUsuario", usuario.getEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // adiciona itens ao action_bar se presentes
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //
        int id = item.getItemId();

        switch(id) {
            case R.id.action_anunciar:
                {
                    Toast.makeText(getApplicationContext(), "Cadastrar um novo Anuncio.", Toast.LENGTH_LONG).show();

                    return true;
                }
            case R.id.action_favoritos:
                {
                    Toast.makeText(getApplicationContext(), "Exibe todos os anuncios que forma favoritados.", Toast.LENGTH_LONG).show();

                    return true;
                }
            case R.id.action_contactados:
                {
                    Toast.makeText(getApplicationContext(), "Listas os anunciantes contactados.", Toast.LENGTH_LONG).show();

                    return true;
                }
            case R.id.action_logout:
            {
                Toast.makeText(getApplicationContext(), "Logout de usuario.", Toast.LENGTH_LONG).show();

                return true;
            }
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private int tipoAnuncio(RadioGroup tipoAnuncio) {
        if(tipoAnuncio.getCheckedRadioButtonId() == R.id.Residencia) {
            return 1;
        } else if(tipoAnuncio.getCheckedRadioButtonId() == R.id.Apartamento) {
            return 2;
        } else {
            return 0;
        }
    }

    private int quantidadeQuartos(RadioGroup numeroQuartos) {
        if(numeroQuartos.getCheckedRadioButtonId() == R.id.quarto1) {
            return 1;
        } else if(numeroQuartos.getCheckedRadioButtonId() == R.id.quarto2) {
            return 2;
        } else if(numeroQuartos.getCheckedRadioButtonId() == R.id.quarto3) {
            return 3;
        } else
            return 0;
    }

    private int quantidadeBanheiros(RadioGroup numeroBanheiros) {
        if(numeroBanheiros.getCheckedRadioButtonId() == R.id.banheiro1) {
            return 1;
        } else if(numeroBanheiros.getCheckedRadioButtonId() == R.id.Banheiro2) {
            return 2;
        } else if(numeroBanheiros.getCheckedRadioButtonId() == R.id.Banheiro3) {
            return 3;
        } else
            return 0;
    }

    public void buscarAnuncios(View view) {
        try{
            Intent intent = new Intent(this, ListaAnunciosActivity.class);

            startActivity(intent);
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());

            // ocorreu um erro de autenticacao
            String msgErroAutenticacao = "ERRO: não foi possivel concluir a busca";
            Toast toat1 = Toast.makeText(this, msgErroAutenticacao, Toast.LENGTH_LONG);
            toat1.show();
        }

    }

    @Override
    public void onBackPressed() {
        String mensagem="Usuário " + usuario.getName().toString() + " já logado";
        Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_SHORT);
        toast.show();
    }

}
