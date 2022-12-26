package com.example.homework_3.Recipe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3.FullRecipe
import com.example.homework_3.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipeFragment : Fragment(R.layout.fragment_recipe) {
    private val args: RecipeFragmentArgs by navArgs()

    private lateinit var stub: TextView
    private lateinit var load: ProgressBar
    private lateinit var recycler: RecyclerView
    private lateinit var labelText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stub = view.findViewById(R.id.stub)
        load = view.findViewById(R.id.load)
        recycler = view.findViewById(R.id.recycler)
        labelText = view.findViewById(R.id.labelText)

        loadData(args.id)

        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun loadData(id: Int) {
        lifecycleScope.launch {
            load.isVisible = true
            stub.isVisible = false
            recycler.isVisible = false
            try {
                val data = withContext(Dispatchers.IO) {
                    FullRecipe.getRecipe(id)
                }
                load.isVisible = false
                stub.isVisible = false
                recycler.isVisible = true

                var ingredients = "Ингредиенты:"
                data.ingredients.forEach { ingredients += "\n${it.name} - ${it.quantity}" }
                val newSteps = arrayListOf<FullRecipe.RecipeElement.Step>(
                    FullRecipe.RecipeElement.Step("0", data.image, ingredients)
                )
                newSteps.addAll(data.steps)

                val myAdapter = RecipeAdapter(newSteps)
                recycler.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = myAdapter
                }
                labelText.text = "${data.name}, ${data.time}"
            } catch (error: Throwable) {
                load.isVisible = false
                stub.isVisible = true
                recycler.isVisible = false
            }
        }
    }
}