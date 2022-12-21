package com.example.homework_3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment(R.layout.fragment_search) {
    lateinit var image: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = view.findViewById(R.id.image)

        lifecycleScope.launch {
            // TODO loading
            try {
                val request = withContext(Dispatchers.IO) {
                    SearchResult.getSearchById(0)
                }
                Glide
                    .with(requireContext())
                    .load(request.image)
                    .into(image)
            } catch (error: Throwable) {
                // TODO error
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