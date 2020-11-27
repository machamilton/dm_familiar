package com.example.dmfamiliar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        val titulo = intent.getStringExtra("textoTitulo")
        val conteudo = intent.getStringExtra("conteudo")
        val tituloPagina = findViewById<TextView>(R.id.textoTitulo_)
        if (titulo != null) {
            tituloPagina.setText(titulo.capitalize())
        }
    }
}