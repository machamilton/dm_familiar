package com.example.dmfamiliar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject
import android.util.Log

class MonstrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monstros)
        val titulo = intent.getStringExtra("textoTitulo")
        val conteudo = intent.getStringExtra("conteudo")
        val tituloPagina = findViewById<TextView>(R.id.titulo)
        if (titulo != null) {
            tituloPagina.setText(titulo.capitalize())
        }
        val infoView = findViewById<TextView>(R.id.textView2)
        val objeto = JSONObject(conteudo)
        val nome = "Nome: " + objeto.getString("name")
        val tamanho: String = "Tamanho: " + objeto.getString("size")
        val tipo = "Tipo: " + objeto.getString("type")
        val subtipo = "SubTipo: " + objeto.getString("subtype")
        val alinhamento = "Alinhamento: " + objeto.getString("alignment")

        val informacoes: String = nome + "\n" + tamanho + "\n" + tipo + "\n" + subtipo + "\n" + alinhamento + "\n"
        infoView.setText(informacoes)

        val tituloCombate = findViewById<TextView>(R.id.textView4)
        tituloCombate.setText("Informações de Combate")

        val infoCombate = findViewById<TextView>(R.id.textView7)
        val hp = "Pontos de Vida: " + objeto.getString("hit_points")
        val armadura = "Pontos de Armadura: " + objeto.getString("armor_class")
        val hit_dice = "Dados de Vida: " + objeto.getString("hit_dice")

        val informacoesCombate = hp + "\n" + armadura + "\n" + hit_dice
        infoCombate.setText(informacoesCombate)



    }
}