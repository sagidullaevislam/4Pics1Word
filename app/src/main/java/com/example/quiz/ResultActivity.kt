package com.example.quiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = this.intent.getStringExtra("name")
        val count = this.intent.getIntExtra("rightCount", 0)
        val maxCount = this.intent.getIntExtra("maxCount", 0)
        binding.tvResult.text = "$name siz ${maxCount}dan ${count}in sheshtiniz"
    }
}