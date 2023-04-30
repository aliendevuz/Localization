package com.example.localization.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivitySaveBinding
import com.example.localization.manager.PreferencesManager

class SaveActivity : AppCompatActivity() {

    private val context = this
    private lateinit var binding: ActivitySaveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    fun init() {
        val preferences: PreferencesManager = PreferencesManager.getInstance(context)

        val editTextLong: EditText = binding.editTextLong
        val switchBoolean: Switch = binding.switchBoolean
        val editTextInteger: EditText = binding.editTextInteger
        val editTextDouble: EditText = binding.editTextDouble
        val buttonSaveData: Button = binding.buttonSaveData
        val textViewData: TextView = binding.textViewData
        val buttonLoadData: Button = binding.buttonLoadData

        val keyLong = "data of Long type"
        val keyBoolean = "data of Boolean type"
        val keyInteger = "data of Integer type"
        val keyDouble = "data of Double type"

        buttonSaveData.setOnClickListener {
            try {
                preferences.saveLong(keyLong, editTextLong.text.toString().toLong())
            } catch (ignored: Exception) {}
            preferences.saveBoolean(keyBoolean, switchBoolean.isChecked)
            try {
                preferences.saveInteger(keyInteger, editTextInteger.text.toString().toInt())
            } catch (ignored: Exception) {}
            try {
                preferences.saveDouble(keyDouble, editTextDouble.text.toString().toDouble())
            } catch (ignored: Exception) {}
        }

        buttonLoadData.setOnClickListener {
            val getData = "Long:\t\t\t\t" + preferences.loadLong(keyLong).toString() + "L\n" +
            "Boolean:\t\t" + preferences.loadBoolean(keyBoolean).toString() + "\n" +
            "Integer:\t\t" + preferences.loadInteger(keyInteger).toString() + "\n" +
            "Double:\t\t" + preferences.loadDouble(keyDouble).toString()
            textViewData.text = getData
        }
    }
}
