package com.example.localization.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivitySignupBinding
import com.example.localization.manager.PreferencesManager

class SignupActivity : AppCompatActivity() {

    private var context = this
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    fun init() {
        val preferences = PreferencesManager.getInstance(context)
        val editTextFullname: EditText = binding.editTextFullname
        val editTextEmail: EditText = binding.editTextEmail
        val editTextPassword: EditText = binding.editTextPassword
        val editTextConfirmPassword: EditText = binding.editTextConfirmPassword
        val buttonSaveUser: Button = binding.buttonSaveUser
        val textViewUser: TextView = binding.textViewUser
        val buttonShowUser: Button = binding.buttonShowUser

        val keyFullname = "data of fullname"
        val keyEmail = "data of email"
        val keyPassword = "data of password"

        buttonSaveUser.setOnClickListener {
            if (editTextFullname.text.isEmpty() || editTextEmail.text.isEmpty() || editTextPassword.text.isEmpty() || editTextConfirmPassword.text.isEmpty()) {
                textViewUser.text = "Biror maydon bo'sh\nqolmaganligiga ishonch\nhosil qiling!"
            } else if (editTextPassword.text.toString() == editTextConfirmPassword.text.toString()) {
                preferences.saveString(keyFullname, editTextFullname.text.toString().trim())
                preferences.saveString(keyEmail, editTextEmail.text.toString().trim())
                preferences.saveString(keyPassword, editTextPassword.text.toString().trim())
                Toast.makeText(context, "Ma'lumotlar saqlandi :)", Toast.LENGTH_SHORT).show()
            } else
                textViewUser.text = "Confirm passwordga yozilgan parol,\nPasswordga yozilgan parol\nbilan bir xil bo'lishi kerak!"
        }

        buttonShowUser.setOnClickListener {
            val getData = "Fullname:\t\t${preferences.loadString(keyFullname)}" +
                    "\nEmail:\t\t\t\t${preferences.loadString(keyEmail)}" +
                    "\nPassword:\t\t${preferences.loadString(keyPassword)}"
            textViewUser.text = getData
        }
    }
}
