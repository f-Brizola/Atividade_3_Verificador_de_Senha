package com.example.atividade_3_verificador_de_senha

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val senha = findViewById<EditText>(R.id.edSenha)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val botaoValidar = findViewById<Button>(R.id.btnVerificarSenha)
        val senhaCoreta: Int = 123

        botaoValidar.setOnClickListener {

            val senhaInformada = senha.text.toString()

            if (senhaInformada.isNotEmpty()){

                val senhaInfo = senhaInformada.toInt()

                if (senhaInfo == senhaCoreta){
                    resultado.setText("Senha Coreta")
                }else{
                    resultado.setText("Senha Incoreta")
                }

            }else{resultado.setText("Digite a Senha")}

        }
    }

    fun limparValores(view: View){
        val senha = findViewById<EditText>(R.id.edSenha)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        senha.setText("")
        resultado.setText("")


    }
}