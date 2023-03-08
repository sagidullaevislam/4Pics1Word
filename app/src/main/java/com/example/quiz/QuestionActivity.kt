package com.example.quiz

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quiz.databinding.ActivityQuestionBinding

 class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    private var hazirgiSorawdinIndex = 0
    private var name: String? = null
    private var saylanganKnopkaninIndeksi = -1
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setQuestion()

        object : CountDownTimer(120000, 1200) {
            var timer = 1200
            override fun onTick(millisUntilFinished: Long) {
                timer -=12
                binding.progressBar.setProgress(timer, true)
            }

            override fun onFinish() {
                Toast.makeText(this@QuestionActivity, "Waqtiniz tawsildi", Toast.LENGTH_SHORT).show()
            }
        }.start()

        binding.materialButton.setOnClickListener {
            saylanganKnopkaninIndeksi = 1
            checkQuestion()
            disable()
        }

        binding.materialButton2.setOnClickListener {
            saylanganKnopkaninIndeksi = 2
            checkQuestion()
            disable()
        }

        binding.materialButton3.setOnClickListener {
            saylanganKnopkaninIndeksi = 3
            checkQuestion()
            disable()
        }

        binding.materialButton4.setOnClickListener {
            saylanganKnopkaninIndeksi = 4
            checkQuestion()
            disable()
        }

        binding.nextBtn.setOnClickListener {
            if (saylanganKnopkaninIndeksi != -1) {
                enable()

                hazirgiSorawdinIndex++

                saylanganKnopkaninIndeksi = -1

                try {
                    setQuestion()
                    unpaintAnswers()
                } catch (e: Exception) {
                    val intent = Intent(this@QuestionActivity, ResultActivity::class.java)
                    val name = this.intent.getStringExtra("name")
                    intent.putExtra("name", name)
                    intent.putExtra("rightCount", score)
                    intent.putExtra("maxCount", hazirgiSorawdinIndex)
                    startActivity(intent)
                }
            }
        }
    }

    fun unpaintAnswers() {
        binding.materialButton.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.purple_700)
        )
        binding.materialButton2.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.purple_700)
        )
        binding.materialButton3.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.purple_700)
        )
        binding.materialButton4.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.purple_700)
        )
    }

    fun nextQuestion() {
        hazirgiSorawdinIndex++
        setQuestion()
        checkQuestion()

    }

    fun disable() {
        binding.apply {
            materialButton.isEnabled = false
            materialButton2.isEnabled = false
            materialButton3.isEnabled = false
            materialButton4.isEnabled = false
        }
    }

    fun enable() {
        binding.apply {
            materialButton.isEnabled = true
            materialButton2.isEnabled = true
            materialButton3.isEnabled = true
            materialButton4.isEnabled = true
        }
    }

    fun setQuestion() {
        val soraw = QuestionList.getQuestion()[hazirgiSorawdinIndex]


        binding.qarekenFlag.setImageResource(soraw.image)
        binding.textQuestion.text = soraw.question

        binding.materialButton.text = soraw.optionOne
        binding.materialButton2.text = soraw.optionTwo
        binding.materialButton3.text = soraw.optionThree
        binding.materialButton4.text = soraw.optionFour

    }


    fun checkQuestion() {
        val soraw = QuestionList.getQuestion()[hazirgiSorawdinIndex]
        if (saylanganKnopkaninIndeksi == -1) {
            Toast.makeText(this, "Sayla", Toast.LENGTH_SHORT).show()
        } else {
            if (saylanganKnopkaninIndeksi == soraw.correctAnswer) {
                when (saylanganKnopkaninIndeksi) {
                    1 -> binding.materialButton.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)
                    )
                    2 -> binding.materialButton2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)
                    )
                    3 -> binding.materialButton3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)
                    )
                    4 -> binding.materialButton4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)
                    )
                }
                score++
            } else {
                when (saylanganKnopkaninIndeksi) {
                    1 -> binding.materialButton.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.qate_juwap)
                    )
                    2 -> binding.materialButton2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.qate_juwap)
                    )
                    3 -> binding.materialButton3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.qate_juwap)
                    )
                    4 -> binding.materialButton4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.qate_juwap)

                    )
                }

                when (soraw.correctAnswer) {
                    1 -> binding.materialButton.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)
                    )
                    2 -> binding.materialButton2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)
                    )
                    3 -> binding.materialButton3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)
                    )
                    4 -> binding.materialButton4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.duris_juwap)

                    )
                }
            }
        }
    }
}