package com.example.localization.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivityMemberBinding
import com.example.localization.manager.PreferencesManager
import com.example.localization.model.Member
import com.google.gson.Gson

class MemberActivity : AppCompatActivity() {

    private var context = this
    private lateinit var binding: ActivityMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    fun init() {
        val preferences = PreferencesManager.getInstance(context)

        val editTextFullnameOfMember: EditText = binding.editTextFullnameOfMember
        val editTextAgeOfMember: EditText = binding.editTextAgeOfMember
        val buttonSaveMember: Button = binding.buttonSaveMember
        val textViewMember: TextView = binding.textViewMember
        val buttonLoadMember: Button = binding.buttonLoadMember

        val keyMember = "data of member"

        buttonSaveMember.setOnClickListener {
            try {
                val member = Member(editTextFullnameOfMember.text.toString().trim(), editTextAgeOfMember.text.toString().trim().toInt())
                preferences.saveString(keyMember, Gson().toJson(member))
                Toast.makeText(context, "Obyekt yaratildi", Toast.LENGTH_SHORT).show()
            } catch (ignored: Exception) {
                textViewMember.text = "Yoshni kiritishda xatoga yo'l qo'ygan ko'rinasiz!"
            }
        }

        buttonLoadMember.setOnClickListener {
            val json = preferences.loadString(keyMember)
            var getData = "Object:\n"
            getData += try { Gson().fromJson(json, Member::class.java).toString() } catch (ignored: Exception) { "null" }
            textViewMember.text = getData
        }
    }
}
