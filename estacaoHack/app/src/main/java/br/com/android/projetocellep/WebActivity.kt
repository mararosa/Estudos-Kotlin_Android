package br.com.android.projetocellep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //config de ativar ou desativas javascript. conseguir ler pag na internet
        wbvSite.settings.javaScriptEnabled = true

        //carregar o site
        wbvSite.loadUrl("http://br.cellep.com/")
    }
}
