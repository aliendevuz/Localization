package com.example.localization.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.MyApplication.Companion.localeManager
import com.example.localization.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val context = this
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localeManager!!.setLocale(context)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    override fun onResume() {
        super.onResume()
        localeManager!!.setLocale(context)
    }

    private fun init() {
        val buttonOpen = binding.buttonOpen
        buttonOpen.setOnClickListener { openActivity(MemberActivity::class.java) }
    }

    private fun openActivity(activity: Class<*>) {
        val intent = Intent(context, activity)
        startActivity(intent)
    }
}