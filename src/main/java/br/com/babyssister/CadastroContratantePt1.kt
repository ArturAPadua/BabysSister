package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CadastroContratantePt1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contratante_pt1)

        val btnCadastroContratante1 = findViewById<Button>(R.id.btnContinuarCadastroContratante)

        btnCadastroContratante1.setOnClickListener{
            val continuaCadastroContratante1 = Intent(this@CadastroContratantePt1, CadastroContratantePt2::class.java)
            startActivity(continuaCadastroContratante1)

        }
    }
}