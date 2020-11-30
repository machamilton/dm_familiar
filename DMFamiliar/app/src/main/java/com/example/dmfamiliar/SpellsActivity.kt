package com.example.dmfamiliar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject

class SpellsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spells)
        val titulo = intent.getStringExtra("textoTitulo")
        val conteudo = intent.getStringExtra("conteudo")
        val infoView = findViewById<TextView>(R.id.conteudoSpell)
        //Variavel objeto contem os dados da requisicao realizada
        val objeto = JSONObject(conteudo)
        val nome = "Nome: " + objeto.getString("name")
        val desc = "\n"+"Descrição: " + "\n" + objeto.getString("desc").replace(oldValue = "[", newValue = "").replace(oldValue = "]", newValue = "") + "\n"
        val hi_lv = "\n"+"Níveis mais altos: " + "\n" + objeto.getString("higher_level").replace(oldValue = "[", newValue = "").replace(oldValue = "]", newValue = "") + "\n"
        val range = "Alcance da magia: " + objeto.getString("range")
        val ritual = "É um ritual? "  +  objeto.getString("ritual")
        val concentration = "Precisa de concentração? " + objeto.getString("concentration")
        val duracao = "Duração: " + objeto.getString("duration")
        val casting_time = "Tempo de Invocação: " + objeto.getString("casting_time")
        val level = "Level: " + objeto.getString("level")
        val infototal = nome + "\n" + desc + "\n" + hi_lv + "\n" + range + "\n" + ritual + "\n" + concentration + "\n" + duracao + "\n" + casting_time + "\n" + level
        infoView.setText(infototal)
    }
}