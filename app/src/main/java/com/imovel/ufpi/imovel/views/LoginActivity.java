package com.imovel.ufpi.imovel.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.controller.UserController;
import com.imovel.ufpi.imovel.models.Usuario;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText user;
    private EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // carregar o conteudo dos EditText
        user = (EditText)findViewById(R.id.editTextUser);
        password = (EditText)findViewById(R.id.editTextPassword);
    }

    /**
     *
     * @param view
     */
    public void login(View view) {
        String userInformado = user.getText().toString();
        String passwordInformado = password.getText().toString();

        try{ // para tratar excecao de erro de conexao ou qualquer outra excecao que por ventura possa ocorrer
            Usuario usuario = new UserController().carregaUsuario(userInformado);

            // verifica dados do usuario
            if(usuario != null) {
                if(passwordInformado.equals(usuario.getPassword())) {
                    //chama servico de verificacao de credenciais (checarCredenciais e cria um bundle para enviar informacoes das credenciais do usuario
                    Bundle bundle = new Bundle();
                    bundle.putString("nomeUsuario", usuario.getName());
                    bundle.putString("emailUsuario", usuario.getEmail());

                    Intent intent = new Intent(this, DashboardActivity.class);
                    intent.putExtras(bundle);

                    //carrega a tela principal e passa dados do Usuario
                    startActivity(intent);
                } else {
                    // ocorreu um erro de autenticacao
                    String msgErroAutenticacao = "ERRO: usuario ou senha incorreto";
                    Toast toat = Toast.makeText(this, msgErroAutenticacao, Toast.LENGTH_LONG);
                    toat.show();

                    limparCamposEntrada();
                }
            } else {
                // ocorreu um erro de autenticacao
                String msgErroAutenticacao = "ERRO: usuario ou senha incorreto";
                Toast toat = Toast.makeText(this, msgErroAutenticacao, Toast.LENGTH_LONG);
                toat.show();

                limparCamposEntrada();
            }
        }catch (Exception e) {
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            toast.show();

            limparCamposEntrada();
        }
    }

    /**
     * Limpa os campos de entrada, ou melhor, seta neles um valor padrão
     */
    public void limparCamposEntrada() {
        user.setText("User");
        password.setText("password");
    }

}

