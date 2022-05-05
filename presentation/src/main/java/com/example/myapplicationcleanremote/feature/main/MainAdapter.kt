package com.example.myapplicationcleanremote.feature.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationcleanremote.databinding.ItemMainBinding
import com.example.myapplicationcleanremote.model.PresentationUser

class MainAdapter():RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val items = mutableListOf<PresentationUser>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MainViewHolder(
            ItemMainBinding.inflate(layoutInflater)
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =
        items.size


    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<PresentationUser>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    inner class MainViewHolder(
        private val binding: ItemMainBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: PresentationUser) {
            binding.repoName.text = user.name
            binding.repoUrl.text = user.url
        }
    }
}