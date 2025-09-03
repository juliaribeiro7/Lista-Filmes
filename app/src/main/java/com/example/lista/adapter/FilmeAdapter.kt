package com.example.lista.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista.R
import com.example.lista.model.Filme

class FilmeAdapter(private val filmes: List<Filme>, private val onItemClick: (Filme) -> Unit) :
    RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        return FilmeViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        holder.bind(filme)
    }

    override fun getItemCount(): Int = filmes.size

    inner class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitulo: TextView = itemView.findViewById(R.id.textViewTitulo)
        private val textViewAno: TextView = itemView.findViewById(R.id.textViewAno)
        private val textViewGenero: TextView = itemView.findViewById(R.id.textViewGenero)
        private val textViewDiretor: TextView = itemView.findViewById(R.id.textViewDiretor)

        fun bind(filme: Filme) {
            textViewTitulo.text = filme.titulo
            textViewAno.text = filme.ano.toString()
            textViewGenero.text = "Gênero: ${filme.genero}"
            textViewDiretor.text = "Diretor: ${filme.diretor}"

            itemView.setOnClickListener {
                onItemClick(filme)
            }
        }
    }
}