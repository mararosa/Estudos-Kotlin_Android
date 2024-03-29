package br.com.android.projetocellep

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //abrindo o shared prefeences
        val minhaPreferencia = getSharedPreferences("minha-preferência", Context.MODE_PRIVATE)

        //obtendo as informaçoes do shared preference
        val email = minhaPreferencia.getString("email", "adm@cellep.com")
        val senhaReal = minhaPreferencia.getString("senha", "123")

        //Listener (ouvinte) para o bbotao entrar
        btnEntrar.setOnClickListener {
            //Obtendo informação do EditText
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenha.text.toString().trim() // trim copila todos os espaços, tira todos os espaços do campo

            //txvResultado.text = "Bem-vindo $usuario"

            if (usuario.isNotEmpty()) {
                if (senha.isNotEmpty()) {
                    if (usuario == email && senha == senhaReal) {
                       // txvResultado.text = "Logado" Agora ao inves de aparecer logado vamos para a tela main
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                    else {
                        //txvResultado.text = "Usuário ou Senha incorretos"
                        Toast.makeText(this@LoginActivity, "Usuário ou Senha incorretos!", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    //txvResultado.text = "Senha vazia"
                    Toast.makeText(this@LoginActivity, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                //txvResultado.text = "Usuário vazio"
                Toast.makeText(this@LoginActivity, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }

        }
        //Listener (ouvinte) para o botao cadastrar
        btnCadastrar.setOnClickListener{
            //Abrindo a tela de cadastro
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }
    }
}

/*
* soma (a, b)
* val s = soma(a, b)
* print(s)
* print(soma(a, b))
* */