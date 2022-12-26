package com.example.homework_3.Search

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
import com.example.homework_3.R
import com.example.homework_3.SearchResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var stub: TextView
    private lateinit var load: ProgressBar
    private lateinit var card: CardView
    private lateinit var image: ImageView
    private lateinit var tags: TextView
    private lateinit var name: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stub = view.findViewById(R.id.stub)
        load = view.findViewById(R.id.load)
        card = view.findViewById(R.id.card)
        image = view.findViewById(R.id.image)
        tags = view.findViewById(R.id.tags)
        name = view.findViewById(R.id.name)

        var id: Int = 0
        loadData(id)

        view.findViewById<Button>(R.id.likeButton).setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_recipeFragment)
        }

        view.findViewById<Button>(R.id.filterButton).setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_filterFragment)
        }

        view.findViewById<Button>(R.id.dislikeButton).setOnClickListener {
            loadData(++id)
        }

        view.findViewById<Button>(R.id.returnButton).setOnClickListener {
            loadData(--id)
        }

        stub.setOnClickListener {
            loadData(id)
        }
    }

    private fun loadData(id: Int) {
        lifecycleScope.launch {
            load.isVisible = true
            stub.isVisible = false
            card.isVisible = false
            try {
                val data = withContext(Dispatchers.IO) {
                    SearchResult.getSearchById(id)
                }
                load.isVisible = false
                stub.isVisible = false
                card.isVisible = true

                Glide.with(requireContext()).load(data.image).into(image)
                tags.text = data.tags.joinToString("\n")
                name.text = "${data.name}, ${data.time}"
            } catch (error: Throwable) {
                load.isVisible = false
                stub.isVisible = true
                card.isVisible = false
            }
        }
    }
}