package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startBtn.setOnClickListener {
            if (binding.outlinedEditText.text.toString().isEmpty()) {
                Toast.makeText(
                    this, "Please enter your name", Toast.LENGTH_SHORT
                ).show()

            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("name", binding.outlinedEditText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}