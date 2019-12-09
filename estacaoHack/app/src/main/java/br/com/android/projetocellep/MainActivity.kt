package br.com.android.projetocellep

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //abrindo o Shared Preference
        val minhapreferencia = getSharedPreferences("minha-preferência", Context.MODE_PRIVATE)

        val nome = minhapreferencia.getString("nome", "Nome não encontrado!")
        val sobrenome = minhapreferencia.getString("sobrenome", "Sobrenome não encontrado!")
        val email = minhapreferencia.getString("email", "e-mail não encontrado!")
        val idade = minhapreferencia.getString("idade", "Idade não encontrada!")

        txvNome.text = "$nome $sobrenome"
        txvEmail.text = email
        txvIdade.text = "$idade anos"

        btnSair.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finishAffinity()
        }

        btnSite.setOnClickListener {
            startActivity(Intent(this@MainActivity, WebActivity::class.java))
            finishAffinity()
        }
    }
}
