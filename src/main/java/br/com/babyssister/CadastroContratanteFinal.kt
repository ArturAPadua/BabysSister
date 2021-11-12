package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.edit
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.babyssister.Adapter.CadastroContratanteFinalRecyclerViewAdapter
import br.com.babyssister.Classes.CadastroContratanteFinalClasses
import java.util.ArrayList


class CadastroContratanteFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contratante_final)

        val txtIdade = findViewById<EditText>(R.id.txtIdade)
        val txtGenero = findViewById<EditText>(R.id.txtGenero)
        val txtSobreCrianca = findViewById<TextView>(R.id.txtSobreCrianca)

        val arrayCriancas = carregaDadosCriancas()

        val criancasAdapter = CadastroContratanteFinalRecyclerViewAdapter(this, arrayCriancas,
            fun (crianca: CadastroContratanteFinalClasses) {

                startActivity(intent)
            })

        val recyclerView = findViewById<RecyclerView>(R.id.rvFilhosCadastroContratante)

        recyclerView.adapter = criancasAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()

        /*
          //depois pode precisar
        val quantFilhos = intent.getStringExtra("quantFilhos")
        var lblQuantFilhosCadastroFinal = findViewById<TextView>(R.id.lblQuantFilhosCadastroFinal).apply {
            text = quantFilhos
        }
         */

          //dando erro no recyclerview
        /*
        val arrayGeneroCrianca = arrayOf("", "Masculino", "Feminino", "Outro", "Prefiro não dizer")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayGeneroCrianca)

        spnGeneroCrianca.adapter = arrayAdapter

        spnGeneroCrianca.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                lblGeneroCriancaResult.text = arrayGeneroCrianca[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val arrayIdadeCrianca = arrayOf("", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18")
        val arrayAdapterIdadeCrianca = ArrayAdapter(this@CadastroContratanteFinal, android.R.layout.simple_spinner_item, arrayIdadeCrianca)

        spnIdadeCrianca.adapter = arrayAdapterIdadeCrianca

        spnIdadeCrianca.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               lblIdadeCriancaResult.text = arrayIdadeCrianca[position] }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

         */

        val btnFinalizarCadastroContratante = findViewById<Button>(R.id.btnFinalizarCadastroContratante)

        btnFinalizarCadastroContratante.setOnClickListener {

            val preferences = getSharedPreferences("a",MODE_PRIVATE)

            val finalizarCadContratante = Intent(this@CadastroContratanteFinal, Login::class.java)

            if (txtGenero.text.toString() == "" || txtIdade.text.toString() == ""
                || txtSobreCrianca.text.toString() == "") {
                Toast.makeText(
                   baseContext, "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                preferences.edit {
                    putString("generoCrianca", txtGenero.text.toString())
                    putString("idadeCrianca", txtIdade.text.toString())
                    putString("sobreCrianca", txtSobreCrianca.text.toString())

                }
                Toast.makeText(
                    baseContext, "Cadastro gravado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(finalizarCadContratante)
            }
        }
    }

    fun carregaDadosCriancas(): ArrayList<CadastroContratanteFinalClasses> {
        var array = ArrayList<CadastroContratanteFinalClasses>()
        val quantFilhosT = intent.getStringExtra("quantFilhos")
        when (quantFilhosT){
            "1" -> {
                array.add(CadastroContratanteFinalClasses("1"))
            }
            "2" -> {
                array.add(CadastroContratanteFinalClasses("1"))
                array.add(CadastroContratanteFinalClasses("2"))
            }
            "3" -> {
                array.add(CadastroContratanteFinalClasses("1"))
                array.add(CadastroContratanteFinalClasses("2"))
                array.add(CadastroContratanteFinalClasses("3"))
            }
            "4" -> {
                array.add(CadastroContratanteFinalClasses("1"))
                array.add(CadastroContratanteFinalClasses("2"))
                array.add(CadastroContratanteFinalClasses("3"))
                array.add(CadastroContratanteFinalClasses("4"))
            }
            else -> {
                array.add(CadastroContratanteFinalClasses("1"))
                array.add(CadastroContratanteFinalClasses("2"))
                array.add(CadastroContratanteFinalClasses("3"))
                array.add(CadastroContratanteFinalClasses("4"))
                array.add(CadastroContratanteFinalClasses("5"))
            }
        }

        return array
    }
}
