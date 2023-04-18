package com.example.localization.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.example.localization.BuildConfig
import com.example.localization.R
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
        if (BuildConfig.DEBUG) if (Timber.treeCount == 0) Timber.plant(Timber.DebugTree())
        init()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun init() {
        val buttonChinese = binding.buttonChinese
        val buttonKorean = binding.buttonKorean
        val buttonJapanese = binding.buttonJapanese
        val buttonUzbek = binding.buttonUzbek

        buttonChinese.setOnClickListener {
            buttonChinese.startAnimation()
            Handler().postDelayed( {
                buttonChinese.revertAnimation()
                buttonChinese.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                setLocale("zh")
            }, 400L)
        }

        buttonKorean.setOnClickListener {
            buttonKorean.startAnimation()
            Handler().postDelayed( {
                buttonKorean.revertAnimation()
                buttonKorean.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                setLocale("ko")
            }, 400L)
        }

        buttonJapanese.setOnClickListener {
            buttonJapanese.startAnimation()
            Handler().postDelayed( {
                buttonJapanese.revertAnimation()
                buttonJapanese.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                setLocale("ja")
            }, 400L)
        }

        buttonUzbek.setOnClickListener {
            buttonUzbek.startAnimation()
            Handler().postDelayed( {
                buttonUzbek.revertAnimation()
                buttonUzbek.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                setLocale("uz")
            }, 400L)
        }
    }

    private fun setLocale(lan: String) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags (lan)
        AppCompatDelegate.setApplicationLocales (appLocale)
        finish()
    }
}