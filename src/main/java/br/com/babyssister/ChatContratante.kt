package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChatContratante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_contratante)

        val btnHome = findViewById<Button>(R.id.btnHome)

        btnHome.setOnClickListener {
            val homecontratante = Intent(this@ChatContratante, HomeContratante::class.java)
            startActivity(homecontratante)
        }

        val btnChat = findViewById<Button>(R.id.btnChatContratante)

        btnChat.setOnClickListener {
            val chatContratante = Intent(this@ChatContratante, ChatContratante::class.java)
            startActivity(chatContratante)
        }

        val btnPerfil = findViewById<Button>(R.id.btnPerfil2)

        btnPerfil.setOnClickListener {
            val perfilContratante = Intent(this@ChatContratante, PerfilContratante::class.java)
            startActivity(perfilContratante)

        }
    }
}