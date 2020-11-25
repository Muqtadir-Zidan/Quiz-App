package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val btn = findViewById<Button>(R.id.btn_submit)
        val etname =findViewById<EditText>(R.id.et_name)

        btn.setOnClickListener {

                if (etname.text.toString().isEmpty()) Toast.makeText(this, "Pleas enter yout Name", Toast.LENGTH_SHORT).show() else{
                val intent = Intent (this, QuizQuestion::class.java)
                    startActivity(intent)
                    finish()
                }
        }


    }
}