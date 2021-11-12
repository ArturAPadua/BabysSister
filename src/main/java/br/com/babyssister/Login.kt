package br.com.babyssister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private val ARQUIVO_PREFERENCIA: String = "ArquivoPreferencia"
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FirebaseApp.initializeApp(this)

        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtSenha = findViewById<EditText>(R.id.txtSenhaLogin)
        val btnLogar = findViewById<Button>(R.id.btnLogar)
        val btnNCadastro = findViewById<Button>(R.id.btnNCadastro)
        val lblTipoUsuarioResgate = findViewById<TextView>(R.id.lblTipoUsuarioResgate)

        btnLogar.setOnClickListener {
            val preferences = getSharedPreferences("a",MODE_PRIVATE)

            if (preferences.contains("email")) {
                txtEmail.setText(preferences.getString("email", ""))
            }
            if (preferences.contains("senha")) {
                txtSenha.setText(preferences.getString("senha", ""))
            }

            if (preferences.contains("tipoUsuario")) {
                lblTipoUsuarioResgate.text = preferences.getString("tipoUsuario", "")
            }

            val homeBaba = Intent(this@Login, /* ChatBaba */ PerfilBaba::class.java)
            val homeContratante = Intent(this@Login, HomeContratante::class.java)
            if (txtEmail.text.toString() == "" || txtSenha.text.toString() == "" ||
                lblTipoUsuarioResgate.text == ""
            ) {
                Toast.makeText(
                    this@Login.applicationContext,
                    "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (lblTipoUsuarioResgate.text == "Babá") {
                    startActivity(homeBaba)

                } else if (lblTipoUsuarioResgate.text == "Pai, mãe ou responsável") {
                    startActivity(homeContratante)
                }
            }
        }

        if (mAuth != null) {
            mAuth!!.signInWithEmailAndPassword(
                "lucasoliveira@cotemig.com.br",
                "senha1234"
            )
                // Método para escutar o retorno em caso de sucesso
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        println("signInWithCustomToken:success")
                    } else {
                        // If sign in fails, display a message to the user.
                        println("signInWithCustomToken:failure")
                    }
                }
        }

        btnNCadastro.setOnClickListener {
            val cadastrar = Intent(this@Login, Cadastro::class.java)
            startActivity(cadastrar)
        }
    }
}