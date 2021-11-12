package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.edit

class CadastroContratantePt2 : AppCompatActivity() {
    private val Shared_Preferences: String = "ArquivoPreferencia"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contratante_pt2)

        val spnQuantFilhos = findViewById<Spinner>(R.id.spnQuantFilhos)
        val lblQuantFilhosCad2Result = findViewById<TextView>(R.id.lblQuantFilhosCad2Result)
        val txtFaleVoce = findViewById<TextView>(R.id.txtFaleVoce)

        val arrayQuantFilhos = arrayOf("", "1", "2", "3", "4", "5")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayQuantFilhos)

        spnQuantFilhos.adapter = arrayAdapter

        spnQuantFilhos.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                lblQuantFilhosCad2Result.text = arrayQuantFilhos[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val btnContinuarCadastro2 = findViewById<Button>(R.id.btnContinuarCadastroContratante2)

        btnContinuarCadastro2.setOnClickListener {

            val preferences = getSharedPreferences("a",MODE_PRIVATE)
            val continuaCadastroContratante2 =
                Intent(this@CadastroContratantePt2, CadastroContratanteFinal::class.java).apply {
                    putExtra("quantFilhos", lblQuantFilhosCad2Result.text)
                }
            if (lblQuantFilhosCad2Result.text.toString() == "" || txtFaleVoce.text.toString() == ""
            ) {
                Toast.makeText(
                    baseContext, "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                preferences.edit {
                    putString("quantFilhos", lblQuantFilhosCad2Result.text.toString())
                    //putString("sobreContratante", txtFaleVoce.text.toString())
                }
                Toast.makeText(
                    baseContext, "Cadastro gravado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(continuaCadastroContratante2)
            }
        }
    }
}