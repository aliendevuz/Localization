package com.example.localization.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.example.localization.BuildConfig
import com.example.localization.MyApplication
import com.example.localization.R
import com.example.localization.databinding.ActivityLanguageBinding
import timber.log.Timber
import com.example.localization.manager.LocaleManager
import java.util.*

@Suppress("DEPRECATION")
class LanguageActivity : AppCompatActivity() {

    private val context = this
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
                MyApplication.localeManager!!.setNewLocale(context, LocaleManager.LANGUAGE_CHINESE)
                finish()
            }, 400L)
        }

        buttonKorean.setOnClickListener {
            buttonKorean.startAnimation()
            Handler().postDelayed( {
                buttonKorean.revertAnimation()
                buttonKorean.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                MyApplication.localeManager!!.setNewLocale(context, LocaleManager.LANGUAGE_KOREAN)
                finish()
            }, 400L)
        }

        buttonJapanese.setOnClickListener {
            buttonJapanese.startAnimation()
            Handler().postDelayed( {
                buttonJapanese.revertAnimation()
                buttonJapanese.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                MyApplication.localeManager!!.setNewLocale(context, LocaleManager.LANGUAGE_JAPAN)
                finish()
            }, 400L)
        }

        buttonUzbek.setOnClickListener {
            buttonUzbek.startAnimation()
            Handler().postDelayed( {
                buttonUzbek.revertAnimation()
                buttonUzbek.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape))
                MyApplication.localeManager!!.setNewLocale(context, LocaleManager.LANGUAGE_UZBEK)
                finish()
            }, 400L)
        }
    }

}