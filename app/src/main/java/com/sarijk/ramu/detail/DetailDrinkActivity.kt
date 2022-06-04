package com.sarijk.ramu.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.sarijk.core.domain.model.Drink
import com.sarijk.ramu.R
import com.sarijk.ramu.databinding.ActivityDetailDrinkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailDrinkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDrinkBinding
    private val detailDrinkViewModel: DetailDrinkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDrinkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val detailDrink = intent.getParcelableExtra<Drink>(EXTRA_DATA)
        showDetailDrink(detailDrink)

    }

    private fun showDetailDrink(detailDrink: Drink?) {
        detailDrink?.let {
            supportActionBar?.title = detailDrink.name
            Glide.with(this@DetailDrinkActivity)
                .load(detailDrink.image)
                .into(binding.ivDetailImage)

            binding.nameCocktail.text = detailDrink.name
            binding.contentInstructions.text = detailDrink.instructions

            binding.buttonBack.setOnClickListener{
                finish()
            }

            var statusFavorite = detailDrink.favorite
            setStatusFavorite(statusFavorite)
            binding.buttonFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailDrinkViewModel.setFavoriteDrink(detailDrink, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.buttonFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_favorite_filled))
        } else {
            binding.buttonFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_favorite_outlined))
        }
    }

    companion object {

        const val EXTRA_DATA = "extra_data"
    }

}