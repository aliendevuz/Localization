package com.example.localization.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivityPreferenceBinding
import com.example.localization.manager.PreferencesManager

class PreferenceActivity : AppCompatActivity() {

    private val context = this
    private lateinit var binding: ActivityPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val editTextEmail = binding.editTextEmail
        val buttonSave = binding.buttonSave
        val buttonLoad = binding.buttonLoad
        val textViewEmail = binding.textViewEmail

        buttonSave.setOnClickListener {
            val stringEmail = editTextEmail.text.toString().trim()
            PreferencesManager.getInstance(context).saveString("email", stringEmail)
        }

        buttonLoad.setOnClickListener {
            textViewEmail.text = PreferencesManager.getInstance(context).loadString("email")
        }
    }
}