package br.com.babyssister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CadastroBaba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_baba)

        val btnContinuarCadBaba = findViewById<Button>(R.id.btnContinuarCadBaba)

        btnContinuarCadBaba.setOnClickListener{
            val continuaCadastroBaba = Intent(this@CadastroBaba, CadastroBabaFinal::class.java)
            startActivity(continuaCadastroBaba)
        }
    }
}