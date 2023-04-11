package com.example.localization.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivityLanguageBinding
import timber.log.Timber
import java.util.*

@Suppress("DEPRECATION")
class LanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.buttonChinese.setOnClickListener { setLocale("zh") }
        binding.buttonKorean.setOnClickListener { setLocale("ko") }
        binding.buttonJapanese.setOnClickListener { setLocale("ja") }
        binding.buttonUzbek.setOnClickListener { setLocale("uz") }
        Timber.d("Salom")
    }

    private fun setLocale(lan: String) {
        val locale = Locale(lan)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()
    }
}