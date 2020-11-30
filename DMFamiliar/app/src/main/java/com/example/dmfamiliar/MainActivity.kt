package com.example.dmfamiliar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Botões que iniciam a montagem da requisição, permitindo o usuário escolher se vai pesquisar monstros, magias ou classes
        val buttonMonstros = findViewById<Button>(R.id.buttonMonstros)
            buttonMonstros.setOnClickListener{
                val intent = Intent(this, BuscaActivity::class.java)
                //Passando o tipo da requisição que será feita
                intent.putExtra("tipoBusca", "monsters")
                startActivity(intent)
            }

        val buttonMagias = findViewById<Button>(R.id.buttonMagias)
        buttonMagias.setOnClickListener{
            val intent = Intent(this, BuscaActivity::class.java)
            //Passando o tipo da requisição que será feita
            intent.putExtra("tipoBusca", "spells")
            startActivity(intent)
        }

        val buttonClasses = findViewById<Button>(R.id.buttonClasses)
        buttonClasses.setOnClickListener{
            val intent = Intent(this, BuscaActivity::class.java)
            //Passando o tipo da requisição que será feita
            intent.putExtra("tipoBusca", "classes")
            startActivity(intent)
        }
}
}