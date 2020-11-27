package com.example.dmfamiliar

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.net.URL

class BuscaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)

        if (Build.VERSION.SDK_INT >= 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

            StrictMode.setThreadPolicy(policy)
        }

        val tipo = intent.getStringExtra("tipoBusca")
        val tituloPagina = findViewById<TextView>(R.id.nomeBusca)
        if (tipo != null) {
            tituloPagina.setText(tipo.capitalize())
        }
        val buttonBuscar = findViewById<Button>(R.id.buttonBusca)
        buttonBuscar.setOnClickListener{
            val inputBusca = findViewById<EditText>(R.id.inputBusca)
            val textoBusca = inputBusca.text.toString().toLowerCase().replace(" ", "-")
            val retornoBusca = inputBusca.text.toString()
            var result =""
            if (tipo != null) {
                result = fazRequest(textoBusca, tipo)
                if (result !=null){
                    val intent = Intent(this, DisplayActivity::class.java)
                    intent.putExtra("textoTitulo", retornoBusca)
                    intent.putExtra("conteudo", result)
                    startActivity(intent)
                }
            }

        }
    }
    fun fazRequest(input: String, tipoDaBusca: String): String {
        val request_api = "https://www.dnd5eapi.co/api/$tipoDaBusca/$input"
        val queryResult = URL(request_api).readText()
        return queryResult
    }
}