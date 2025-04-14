package com.example.baitaprecycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baitaprecycleview.databinding.LayoutItemBinding

class RvAdapter (private val ds: MutableList<OutData>) : RecyclerView.Adapter<RvAdapter.itemViewHolder>() {
    private lateinit var binding: LayoutItemBinding
    class itemViewHolder(binding: LayoutItemBinding) :RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return ds.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context)
        binding = LayoutItemBinding.inflate(view,parent, false)
        return itemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.itemView.apply {
            binding.txtTen.text = ds[position].ten.toString()
            binding.txtMssv.text = ds[position].mssv.toString()
        }
        binding.btnDelete.setOnClickListener {
            removeItem(holder.adapterPosition)
        }
    }
    fun removeItem(position: Int) {
        if (position in ds.indices) {
            ds.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, ds.size)
        }
    }

}
