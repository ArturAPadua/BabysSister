package br.com.babyssister

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import br.com.babyssister.Crud.User
import br.com.babyssister.Crud.UsersServices
import java.util.*

class Cadastro : AppCompatActivity() {
    var isEdition: Boolean = false
    var user: User? = null

    lateinit var txtNome: EditText
    lateinit var txtEmail: EditText
    lateinit var txtSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        txtNome = findViewById(R.id.txtNome)
        txtEmail = findViewById(R.id.txtEmail)
        txtSenha = findViewById(R.id.txtSenha)
        val txtSenhaConfirma = findViewById<EditText>(R.id.txtSenhaConfirma)
        val spnTipoUsuarioCadastro = findViewById<Spinner>(R.id.spnTipoUsuarioCadastro)
        val spnGeneroCadastro = findViewById<Spinner>(R.id.spnGeneroCadastro)
        val lblTipoUsuarioCadastroResult = findViewById<TextView>(R.id.lblTipoUsuarioCadastroResult)
        val lblGeneroCadastroResult = findViewById<TextView>(R.id.lblGeneroCadastroResult)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnTemCadastro = findViewById<Button>(R.id.btnTemCadastro)

        val arrayGeneroCadastro = arrayOf("","Masculino", "Feminino", "Outro", "Prefiro não dizer")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayGeneroCadastro)

        var idStr = intent.getStringExtra("id")
        if (idStr != null) {
            isEdition = true
            carregaDados(idStr)
        }

        spnGeneroCadastro.adapter = arrayAdapter

        spnGeneroCadastro.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                lblGeneroCadastroResult.text = arrayGeneroCadastro[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val arrayTipoUsuarioCadastro = arrayOf("","Babá", "Pai, mãe ou responsável")
        val arrayAdapterTipoUsuario = ArrayAdapter(this@Cadastro, android.R.layout.simple_spinner_item, arrayTipoUsuarioCadastro)

        spnTipoUsuarioCadastro.adapter = arrayAdapterTipoUsuario

        spnTipoUsuarioCadastro.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                lblTipoUsuarioCadastroResult.text = arrayTipoUsuarioCadastro[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        btnCadastrar.setOnClickListener {
            val preferences = getSharedPreferences("a",MODE_PRIVATE)

            val cadastrarBaba = Intent(this@Cadastro, CadastroBaba::class.java)
            val cadastrarContratante = Intent(this@Cadastro, CadastroContratantePt1::class.java)

            if (lblGeneroCadastroResult.text.toString() == "" || txtNome.text.toString() == "" ||
                txtEmail.text.toString() == "" || txtSenha.text.toString() == "" ||
                lblTipoUsuarioCadastroResult.text.toString() == "" || txtSenhaConfirma.text.toString() == ""
                || txtSenha.text.toString() != txtSenhaConfirma.text.toString()
            ) {

                Toast.makeText(
                    baseContext, "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                preferences.edit {
                    putString("nome", txtNome.text.toString())
                    putString("email", txtEmail.text.toString())
                    putString("senha", txtSenha.text.toString())
                    putString("tipoUsuario", lblTipoUsuarioCadastroResult.text.toString())
                    putString("tipoGenero", lblGeneroCadastroResult.text.toString())
                }
                if (lblTipoUsuarioCadastroResult.text == "Babá") {
                    Toast.makeText(
                        baseContext, "Cadastro gravado com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(cadastrarBaba)
                } else if (lblTipoUsuarioCadastroResult.text == "Pai, mãe ou responsável") {
                    Toast.makeText(
                        baseContext, "Cadastro gravado com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(cadastrarContratante)
                }
            }
        }

        btnTemCadastro.setOnClickListener{
            val voltarLogin = Intent(this@Cadastro, Login::class.java)
            startActivity(voltarLogin)
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
        } else {
            cadastrar()
        }
    }

    fun editar() {

        val nome = txtNome.text.toString()
        val email = txtEmail.text.toString()
        val senha = txtSenha.text.toString()
        val experiencia = ""
        val habilidades = ""
        val valor = null

        this.user?.nome = nome
        this.user?.email = email
        this.user?.senha = senha
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

    fun cadastrar() {
        val nome = txtNome.text.toString()
        val email = txtEmail.text.toString()
        val senha = txtSenha.text.toString()
        val experiencia = ""
        val habilidades = ""
        val valor = null

        this.user?.nome = nome
        this.user?.email = email
        this.user?.senha = senha
        this.user?.temExBaba = experiencia
        this.user?.habilidadesBaba = habilidades
        this.user?.valorBaba = valor

        UsersServices().postUser(this.user!!) {
            if (it != null) {
                this.isEdition = true
                this.user = it
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Não foi possível cadastrar o usuário!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}