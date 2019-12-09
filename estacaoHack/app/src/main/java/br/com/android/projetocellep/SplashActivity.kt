package br.com.android.projetocellep


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Manipular a execção - postDelayed
       Handler().postDelayed({
           //Criando uma intent explicita
           val intentLogin = Intent(this@SplashActivity, LoginActivity ::class.java)
           //Executar a intent
           startActivity((intentLogin))
       },3000)

    }
}






