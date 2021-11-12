package br.com.babyssister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.babyssister.Adapter.HomeContratanteRecyclerViewAdapter
import br.com.babyssister.Classes.HomeContratanteClasses

class HomeContratante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_contratante)

        val btnHome = findViewById<Button>(R.id.btnHome)

        btnHome.setOnClickListener {
            val homeContratante = Intent(this@HomeContratante, HomeContratante::class.java)
            startActivity(homeContratante)
        }

        /*
        val btnChat = findViewById<Button>(R.id.btnChatContratante)

        btnChat.setOnClickListener {
            val chatContratante = Intent(this@HomeContratante, ChatContratante::class.java)
            startActivity(chatContratante)
        }
        */

        val btnPerfil = findViewById<Button>(R.id.btnPerfilContratante)

        btnPerfil.setOnClickListener {
            val perfilContratante = Intent(this@HomeContratante, PerfilContratante::class.java)
            startActivity(perfilContratante)

        }
        val recyclerView = findViewById<RecyclerView>(R.id.rcvHomeContratante)

        val arrayPessoas = carregaDadosPessoas()

        val pessoaAdapter = HomeContratanteRecyclerViewAdapter(this, arrayPessoas,
            fun (pessoa: HomeContratanteClasses) {
                Toast.makeText(this, "Nome: ${pessoa.nomeBaba}, UltimaMensagem: ${pessoa.descBaba}", Toast.LENGTH_SHORT).show()
            })

        recyclerView.adapter = pessoaAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    // Método para carregar uma lista de Pessoa
    fun carregaDadosPessoas(): ArrayList<HomeContratanteClasses> {
        var array = ArrayList<HomeContratanteClasses>()
        array.add(HomeContratanteClasses("Felipe", "agdkjugf"))
        array.add(HomeContratanteClasses("Sabrina", "agdkjugf"))
        array.add(HomeContratanteClasses("Sarah", "agdkjugf"))
        array.add(HomeContratanteClasses("Bárbara", "agdkjugf"))
        array.add(HomeContratanteClasses("Laura", "agdkjugf"))
        array.add(HomeContratanteClasses("Nilton", "agdkjugf"))
        array.add(HomeContratanteClasses("Felipe", "agdkjugf"))
        array.add(HomeContratanteClasses("Hiago", "agdkjugf"))
        array.add(HomeContratanteClasses("Vagner", "agdkjugf"))
        array.add(HomeContratanteClasses("Augusto", "agdkjugf"))
        array.add(HomeContratanteClasses("Artur", "agdkjugf"))
        array.add(HomeContratanteClasses("Ana", "agdkjugf"))

        return array
    }
}