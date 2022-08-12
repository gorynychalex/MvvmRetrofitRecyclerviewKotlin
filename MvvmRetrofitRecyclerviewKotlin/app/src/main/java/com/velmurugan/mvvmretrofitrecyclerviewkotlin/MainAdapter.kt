package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.AdapterMovieBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var movies = mutableMapOf<String,List<Movie>>()

    fun setMovieList(movies: Map<String,List<Movie>>) {
        this.movies = movies.toMutableMap()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies.get("items")!![position]
       holder.binding.name.text = movie.title
//        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)

    }

    override fun getItemCount(): Int {
        if(!movies.isEmpty())
            return movies!!.get("items")!!.size
        return 0
    }
}

class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}
