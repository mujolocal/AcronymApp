package com.example.aconymapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aconymapp.databinding.AcronymItemBinding
import com.example.aconymapp.model.AcronymResponseItem

class AcronymAdapter(private val acronyms:AcronymResponseItem)
    : RecyclerView.Adapter<AcronymAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AcronymItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: AcronymAdapter.ViewHolder, position: Int) = with(holder.binding){
        lf = acronyms.lfs?.get(position)
    }

    override fun getItemCount(): Int {
        return acronyms.lfs?.size ?: 0
    }

    class ViewHolder(val binding:AcronymItemBinding ) : RecyclerView.ViewHolder(binding.root)

}