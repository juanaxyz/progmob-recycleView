package com.example.recyclerviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve extras
        val title = intent.getStringExtra("EXTRA_TITLE") ?: ""
        val desc = intent.getStringExtra("EXTRA_DESC") ?: ""
        val imgRes = intent.getIntExtra("EXTRA_IMG", R.mipmap.ic_launcher)

        // Populate UI
        binding.detailTitle.text = title
        binding.detailDescription.text = desc
        binding.detailImage.setImageResource(imgRes)
    }
}
