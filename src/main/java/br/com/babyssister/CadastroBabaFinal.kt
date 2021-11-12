package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import br.com.babyssister.Crud.User
import br.com.babyssister.Crud.UsersServices

class CadastroBabaFinal : AppCompatActivity() {
    var isEdition: Boolean = false
    var user: User? = null

    lateinit var lblTempoExperienciaBabaResult: TextView
    lateinit var txtHabilidades: EditText
    lateinit var txtValor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_baba_final)

        val spnTempoExperienciaBaba = findViewById<Spinner>(R.id.spnTempoExperienciaBaba)
        val txtHabilidades = findViewById<EditText>(R.id.txtHabilidades)
        val txtConfortavel = findViewById<EditText>(R.id.txtConfortavel)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val txtFaleVoce = findViewById<EditText>(R.id.txtFaleVoce)
        val lblTempoExperienciaBabaResult = findViewById<TextView>(R.id.lblTempoExperienciaBabaResult)
        val btnFinalizarCadBaba = findViewById<Button>(R.id.btnFinalizarCadBaba)

        val arrayTempoExperienciaBaba =
            arrayOf("", "Não tenho experiência", "Menos de 1 ano", "1 ano", "2 anos", "3 anos", "4 anos", "5 anos ou mais")
        val arrayAdapterTempoExperienciaBaba =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayTempoExperienciaBaba)

        spnTempoExperienciaBaba.adapter = arrayAdapterTempoExperienciaBaba

        spnTempoExperienciaBaba.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                lblTempoExperienciaBabaResult.text = arrayTempoExperienciaBaba[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        var idStr = intent.getStringExtra("id")
        if (idStr != null) {
            isEdition = true
            carregaDados(idStr)
        }

        btnFinalizarCadBaba.setOnClickListener {
            val preferences = getPreferences(MODE_PRIVATE)
            val editor = preferences.edit()

            val logarBaba = Intent(this@CadastroBabaFinal, Login::class.java)
            if (lblTempoExperienciaBabaResult.text.toString() == "" || txtHabilidades.text.toString() == "" ||
                txtConfortavel.text.toString() == "" || txtValor.text.toString() == "" ||
                txtFaleVoce.text.toString() == ""
            ) {

                Toast.makeText(
                    baseContext, "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                editor.putString(
                    "tempoExperienciaBaba",
                    lblTempoExperienciaBabaResult.text.toString()
                )
                editor.putString("habilidadesBaba", txtHabilidades.text.toString())
                editor.putString("confortavelEmBaba", txtConfortavel.text.toString())
                editor.putString("valorBaba", txtValor.text.toString())
                editor.putString("sobreBaba", txtFaleVoce.text.toString())
                editor.apply()
                Toast.makeText(
                    baseContext, "Cadastro gravado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(logarBaba)
            }
        }
    }

    fun carregaDados(idStr: String) {
        UsersServices().getUserById(idStr) {
            if (it != null) {
                this.user = it
            } else {
                Toast.makeText(this, "Não foi possível carregar os dados!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun salvarDados(view: View) {
        if (this.isEdition) {
            editar()
        }
    }

    fun editar() {
        val experiencia = lblTempoExperienciaBabaResult.toString()
        val habilidades = txtHabilidades.toString()
        val valorStr = txtValor.toString()
        val valor: Float? = valorStr.toFloat()

        this.user?.temExBaba = experiencia
        this.user?.habilidadesBaba = habilidades
        this.user?.valorBaba = valor

        UsersServices().putUserById(this.user?.id.toString(), this.user!!) {
            if (it != null) {
                this.user = it
                Toast.makeText(this, "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Não foi possível salvar os dados!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}