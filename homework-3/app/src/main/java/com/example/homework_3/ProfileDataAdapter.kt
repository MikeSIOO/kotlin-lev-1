package com.example.homework_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProfileDataAdapter(private val items: ArrayList<ProfileData.ProfileElement>) : RecyclerView.Adapter<ProfileDataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileDataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ProfileDataHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileDataHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}