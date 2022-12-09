package com.example.homework_2.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.homework_2.R
import com.example.homework_2.StatusLoad
import com.example.homework_2.presentation.model.Response
import com.example.homework_2.utils.PassContextToProvider
import com.example.homework_2.utils.PassContextToProvider.context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.image_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = requireArguments().getParcelable<Response.Item>(MY_KEY)!!
        val imageFrag = view.findViewById<ImageView>(R.id.image_frag)

        val singleProvider = PassContextToProvider.singleProvider()

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val request = withContext(Dispatchers.IO) {
                    singleProvider.getSingleItems(item.id)
                }


                Glide
                    .with(PassContextToProvider.context)
                    .load(request.data.images.original.url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imageFrag)
            } catch (error: Throwable) {
                error.printStackTrace()
            }
        }


    }

    companion object {
        const val MY_KEY = "KEY"
        fun newInstance(item: Response.Item): ImageFragment {
            val extras = Bundle().apply {
                putParcelable(MY_KEY, item)
            }

            val fragment = ImageFragment().apply {
                arguments = extras
            }

            return fragment
        }
    }
}