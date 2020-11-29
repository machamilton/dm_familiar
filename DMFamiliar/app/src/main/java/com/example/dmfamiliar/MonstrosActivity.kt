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
        //Traz os dados da activity BuscaActivity
        val titulo = intent.getStringExtra("textoTitulo")
        val conteudo = intent.getStringExtra("conteudo")
        val tituloPagina = findViewById<TextView>(R.id.titulo)
        //Define o titulo da pagina como a busca realizada
        if (titulo != null) {
            tituloPagina.setText(titulo.capitalize())
        }
        val infoView = findViewById<TextView>(R.id.textView2)
        //Variavel objeto contem os dados da requisicao realizada
        val objeto = JSONObject(conteudo)
        val nome = "Nome: " + objeto.getString("name")
        val tamanho: String = "Tamanho: " + objeto.getString("size")
        val tipo = "Tipo: " + objeto.getString("type")
        val subtipo = "SubTipo: " + objeto.getString("subtype")
        val alinhamento = "Alinhamento: " + objeto.getString("alignment")
        //Retorna as informacoes basicas do monstro
        val informacoes: String = nome + "\n" + tamanho + "\n" + tipo + "\n" + subtipo + "\n" + alinhamento + "\n"
        infoView.setText(informacoes)
        //Retorna as informacoes de combate do monstro
        val tituloCombate = findViewById<TextView>(R.id.textView4)
        tituloCombate.setText("Informações de Combate")

        val infoCombate = findViewById<TextView>(R.id.textView7)
        val hp = "Pontos de Vida: " + objeto.getString("hit_points")
        val armadura = "Pontos de Armadura: " + objeto.getString("armor_class")
        val hit_dice = "Dados de Vida: " + objeto.getString("hit_dice")

        val informacoesCombate = "\n" + hp + "\n" + armadura + "\n" + hit_dice
        infoCombate.setText(informacoesCombate)

        val infoAtributos = findViewById<TextView>(R.id.atributos)
        val forca = "Força: " + objeto.getString("strength")
        val destreza = "Destreza: " + objeto.getString("dexterity")
        val const = "Constituição: " + objeto.getString("constitution")
        val int = "Inteligência: " + objeto.getString("intelligence")
        val sabedoria = "Sabedoria: " + objeto.getString("wisdom")
        val carisma = "Carisma: " + objeto.getString("charisma")

        val retornoAtributos = "\n" + forca + "\n" + destreza + "\n" + const + "\n" + int + "\n" + sabedoria + "\n" + carisma
        infoAtributos.setText(retornoAtributos)



    }
}