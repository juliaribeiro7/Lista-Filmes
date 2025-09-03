package com.example.lista

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista.adapter.FilmeAdapter
import com.example.lista.model.Filme

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FilmeAdapter
    private val listaFilmes = mutableListOf<Filme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewFilmes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Adiciona filmes de exemplo à lista
        carregarFilmes()

        // Configura o adaptador
        adapter = FilmeAdapter(listaFilmes) { filme ->
            // Ação ao clicar em um filme
            Toast.makeText(this, "Filme selecionado: ${filme.titulo}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter
    }

    private fun carregarFilmes() {
        // Adiciona alguns filmes de exemplo
        listaFilmes.add(Filme(1, "O Poderoso Chefão", 1972, "Drama/Crime", "Francis Ford Coppola"))
        listaFilmes.add(Filme(2, "Pulp Fiction", 1994, "Crime/Drama", "Quentin Tarantino"))
        listaFilmes.add(Filme(3, "O Senhor dos Anéis: A Sociedade do Anel", 2001, "Fantasia/Aventura", "Peter Jackson"))
        listaFilmes.add(Filme(4, "Cidade de Deus", 2002, "Crime/Drama", "Fernando Meirelles"))
        listaFilmes.add(Filme(5, "Interestelar", 2014, "Ficção Científica/Aventura", "Christopher Nolan"))
        listaFilmes.add(Filme(6, "Parasita", 2019, "Drama/Suspense", "Bong Joon-ho"))
        listaFilmes.add(Filme(7, "Vingadores: Ultimato", 2019, "Ação/Aventura", "Anthony e Joe Russo"))
        listaFilmes.add(Filme(8, "Coringa", 2019, "Drama/Crime", "Todd Phillips"))
        listaFilmes.add(Filme(9, "Matrix", 1999, "Ficção Científica/Ação", "Lana e Lilly Wachowski"))
        listaFilmes.add(Filme(10, "Clube da Luta", 1999, "Drama", "David Fincher"))
    }
}