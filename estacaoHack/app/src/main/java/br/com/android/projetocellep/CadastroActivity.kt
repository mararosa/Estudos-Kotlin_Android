package br.com.android.projetocellep

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        val listaIdades = arrayListOf<String>("Selecione a idade")

        for (i in 1..100) {
            listaIdades.add("$i")
        }
        val adapterIdades = ArrayAdapter(this@CadastroActivity, android.R.layout.simple_spinner_dropdown_item, listaIdades)

        spnIdade.adapter = adapterIdades

        //configurando o SharedPreferences (nome do arquivo que vai criar)
        val minhaPreferencia = getSharedPreferences("minha-preferência", Context.MODE_PRIVATE)
        val meuEditor = minhaPreferencia.edit()

        //Criando listener do botao cadastrar
        btnRegister.setOnClickListener{
            val nome = edtNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val senha = edtPassword.text.toString().trim()

            //Obtendo as informações digitadas
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this@CadastroActivity, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                //Validando o Spinner
                if (spnIdade.selectedItemPosition == 0){
                    Toast.makeText(this@CadastroActivity, "Idade inválida", Toast.LENGTH_SHORT).show()
                } else { //gravando o minha preferencia
                    meuEditor.putString("nome", nome).apply()
                    meuEditor.putString("sobrenome", sobrenome).apply()
                    meuEditor.putString("email", email).apply()
                    meuEditor.putString("senha", senha).apply()
                    meuEditor.putString("idade", spnIdade.selectedItem.toString()).apply()

                    //alertando que o cadastro foi efetuado
                    //Toast.makeText(this@CadastroActivity, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show()

                    // add alert
                    AlertDialog.Builder(this@CadastroActivity)

                    //configurar o alerta
                        .setTitle(("Sucesso!"))
                        .setMessage("Usuário Cadastrado")
                        .setPositiveButton("Ok") {_,_ ->
                            //indo para a prox tela
                            startActivity((Intent(this@CadastroActivity, MainActivity::class.java)))
                        }
                        .setCancelable(false)
                        .create()
                        .show()
                }
            }

        }
    }
}
