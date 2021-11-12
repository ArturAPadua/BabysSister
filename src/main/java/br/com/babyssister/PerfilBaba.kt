package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PerfilBaba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_baba)

        /*
        val btnChatBaba = findViewById<Button>(R.id.btnChatBaba)

        btnChatBaba.setOnClickListener {
            val chatBaba = Intent(this@PerfilBaba, ChatBaba::class.java)
            startActivity(chatBaba)
        }
        */

        val btnPerfilBaba = findViewById<Button>(R.id.btnPerfilBaba)

        btnPerfilBaba.setOnClickListener {
            val perfilBaba = Intent(this@PerfilBaba, PerfilBaba::class.java)
            startActivity(perfilBaba)

        }
    }
}