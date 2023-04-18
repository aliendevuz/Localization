package com.example.localization.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.R
import com.example.localization.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val context = this
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun init() {
        val buttonOpen = binding.buttonOpen
        buttonOpen.setOnClickListener {
            buttonOpen.startAnimation()
            Handler().postDelayed( {
                buttonOpen.revertAnimation()
                buttonOpen.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                val intent = Intent(context, LanguageActivity::class.java)
                startActivity(intent)
            }, 1400L)
        }
    }
}