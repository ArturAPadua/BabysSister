package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PerfilContratante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_contratante)

        val btnHome = findViewById<Button>(R.id.btnHome)

        btnHome.setOnClickListener {
            val homeContratante = Intent(this@PerfilContratante, HomeContratante::class.java)
            startActivity(homeContratante)
        }

        /*
        val btnChat = findViewById<Button>(R.id.btnChatContratante)

        btnChat.setOnClickListener {
            val chatContratante = Intent(this@PerfilContratante, ChatContratante::class.java)
            startActivity(chatContratante)
        }
        */

        val btnPerfil = findViewById<Button>(R.id.btnPerfilContratante)

        btnPerfil.setOnClickListener {
            val perfilContratante = Intent(this@PerfilContratante, PerfilContratante::class.java)
            startActivity(perfilContratante)

        }

    }
}