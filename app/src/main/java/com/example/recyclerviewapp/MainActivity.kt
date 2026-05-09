package com.example.recyclerviewapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Force dark mode for the entire app
        androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ItemAdapter { item ->
            // Open DetailActivity with selected item data
            val intent = android.content.Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_TITLE", item.title)
                putExtra("EXTRA_DESC", item.description)
                putExtra("EXTRA_IMG", item.imageRes)
            }
            startActivity(intent)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        // Add spacing between cards (8dp)
        val spacing = resources.getDimensionPixelSize(com.example.recyclerviewapp.R.dimen.item_spacing)
        binding.recyclerView.addItemDecoration(SpacingItemDecoration(spacing))
        binding.recyclerView.adapter = adapter

        // Generate 150 dummy items (100‑200 as requested)
        val dummyItems = generateDummyItems(150)
        adapter.submitList(dummyItems)
    }
}
