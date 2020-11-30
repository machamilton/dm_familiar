package com.example.dmfamiliar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class ClassesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classes)
        //Traz os dados da activity BuscaActivity
        val titulo = intent.getStringExtra("textoTitulo")
        val conteudo = intent.getStringExtra("conteudo")
        val tituloPagina = findViewById<TextView>(R.id.tituloClasse)
        if (titulo != null) {
            tituloPagina.setText(titulo.capitalize())
        }
        val infoView = findViewById<TextView>(R.id.conteudoClasse)
        //Variavel objeto contem os dados da requisicao realizada
        val objeto = JSONObject(conteudo)
        val nome = "Classe: " + objeto.getString("name")
        val dadoVida = "Dado de Vida: " + objeto.getString("hit_die")
        val proficienciasGerais = objeto.getJSONArray("proficiency_choices")
        val profChoices = proficienciasGerais.getJSONObject(0)
        val quantidadeEscolha = "\n"+ "Pode escolher " + profChoices.getString("choose") + " proficiências da lista:" + "\n" + "\n"
        val listaEscolha = profChoices.getJSONArray("from")
        var profList = ""
        for (i in 0 until listaEscolha.length()) {
            var proficiencia = listaEscolha.getJSONObject(i)
            var proficiencias = proficiencia.getString("name").replace(oldValue= "Skill:", newValue= "", ignoreCase = false)
            profList = profList + proficiencias + " // "
        }
        var profClasse = objeto.getJSONArray("proficiencies")
        var profListClasse = "\n" + "A classe possui as seguintes proficiências passivamente: " + "\n" + "\n"
        for (x in 0 until profClasse.length()) {
            var profDisponiveis = profClasse.getJSONObject(x)
            var nomeProficiencia = profDisponiveis.getString("name")
            profListClasse = profListClasse + nomeProficiencia + "\n"
        }

        infoView.setText("\n" + nome + "\n" + dadoVida + "\n" + quantidadeEscolha + profList + "\n" + profListClasse)
    }
}

