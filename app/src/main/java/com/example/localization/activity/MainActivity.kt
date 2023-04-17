package com.example.localization.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val context = this
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val buttonOpen = binding.buttonOpen
        buttonOpen.setOnClickListener {
            val intent = Intent(context, LanguageActivity::class.java)
            startActivity(intent)
        }
    }
}