package com.example.aconymapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aconymapp.databinding.AcronymItemBinding
import com.example.aconymapp.model.AcronymResponseItem

class AcronymAdapter(private val acronyms:List<AcronymResponseItem>)
    : RecyclerView.Adapter<AcronymAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AcronymItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: AcronymAdapter.ViewHolder, position: Int) = with(holder.binding){
        acronym = acronyms[position]
    }

    override fun getItemCount() = acronyms.size

    class ViewHolder(val binding:AcronymItemBinding ) : RecyclerView.ViewHolder(binding.root)

}