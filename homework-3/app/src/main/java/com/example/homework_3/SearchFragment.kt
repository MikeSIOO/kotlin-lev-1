package com.example.homework_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stub = view.findViewById<TextView>(R.id.stub)
        val load = view.findViewById<ProgressBar>(R.id.load)
        val card = view.findViewById<CardView>(R.id.card)
        lifecycleScope.launch {
            load.isVisible = true
            stub.isVisible = false
            card.isVisible = false
            try {
                val data = withContext(Dispatchers.IO) {
                    SearchResult.getSearchById(1)
                }

                load.isVisible = false
                stub.isVisible = false
                card.isVisible = true
                Glide
                    .with(requireContext())
                    .load(data.image)
                    .into(view.findViewById<ImageView>(R.id.image))
                view.findViewById<TextView>(R.id.tags).text = data.tags.joinToString("\n")
                view.findViewById<TextView>(R.id.name).text = "${data.name}, ${data.time}"
            } catch (error: Throwable) {
                load.isVisible = false
                stub.isVisible = true
                card.isVisible = false
            }
        }

        view.findViewById<Button>(R.id.likeButton).setOnClickListener{
            findNavController().navigate(R.id.action_searchFragment_to_recipeFragment)
        }

        view.findViewById<Button>(R.id.filterButton).setOnClickListener{
            findNavController().navigate(R.id.action_searchFragment_to_filterFragment)
        }
    }
}