package com.example.homework_3.Profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3.ProfileData
import com.example.homework_3.R

class ProfileDataAdapter(
    private val items: ArrayList<ProfileData.ProfileElement>,
    private val chooseItem: (item: ProfileData.ProfileElement) -> Unit
) : RecyclerView.Adapter<ProfileDataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileDataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ProfileDataHolder(view, chooseItem)
    }

    override fun onBindViewHolder(holder: ProfileDataHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}