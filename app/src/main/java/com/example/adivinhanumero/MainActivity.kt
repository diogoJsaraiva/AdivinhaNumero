package com.example.adivinhanumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private val random = Random()
    private var numeroAdivinhar : Int = 0
    private var jogo : Int = 0
    private var tentativas: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        novoJogo()

    }

    private fun novoJogo() {
        numeroAdivinhar = random.nextInt(10) + 1
        tentativas = 0
        jogo++

        atualizaJogo()
        atualizaTentativas()
    }

    private fun atualizaJogo() {
        findViewById<TextView>(R.id.textViewJogo).text = getString(R.string.Jogo) + jogo
    }

    private fun atualizaTentativas() {
        findViewById<TextView>(R.id.textViewTentativas).text = getString(R.string.Tentativa) + tentativas

    }





    fun adivinhar(view: View) {
        val editTextNumero = findViewById<EditText>(R.id.editTextNumero)
        val numero = editTextNumero.text.toString().toIntOrNull()

        when (numero){
            in 1..10 -> verificaAcertou(numero!!)
            null -> editTextNumero.error =getString(R.string.numero_invalido)
            else -> editTextNumero.error =getString(R.string.numero_entre_1_10)


        }





    }

    private fun verificaAcertou(numero: Int) {
        val textViewFeedback = findViewById<TextView>(R.id.textViewFeedback)

        val mensagem : String


         if(numero == numeroAdivinhar){
             textViewFeedback.text = getString(R.string.Acerto)
             perguntarSeQuerJogarNovamente()
        }else if(numeroAdivinhar > numero){
             textViewFeedback.text =getString(R.string.numero_Maior)
        }else{
             textViewFeedback.text =getString(R.string.numero_Menor)
        }

        tentativas++
        atualizaTentativas()

    }

    private fun perguntarSeQuerJogarNovamente() {
        // colocar um alerta se quer jogar novamente
    }
}