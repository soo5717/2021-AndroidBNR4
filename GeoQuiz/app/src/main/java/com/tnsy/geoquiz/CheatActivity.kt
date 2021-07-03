package com.tnsy.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val KEY_INDEX = "index"

const val EXTRA_ANSWER_SHOW = "com.tnsy.geoquiz.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE = "com.tnsy.geoquiz.answer_is_true"

class CheatActivity : AppCompatActivity() {

    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button

    private var answerIsTrue = false
    private var isAnswerShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        // 챌린지1 : 회전시 커닝 여부 보존
        isAnswerShown = savedInstanceState?.getBoolean(KEY_INDEX, false) ?: false
        setAnswerShownResult()

        // 인텐트 데이터 받기
        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        answerTextView = findViewById(R.id.answer_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)
        showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)

            isAnswerShown = true
            setAnswerShownResult()
        }
    }

    // 커닝 여부 MainActivity로 전달
    private fun setAnswerShownResult() {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOW, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    // 챌린지1 : 회전시 커닝 여부 보존
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_INDEX, isAnswerShown)
    }

    // 인텐트 요청 캡슐화
    companion object { // 자바에서의 static이라고 이해하면 쉬움.
        fun newIntent(packageContext: Context, answerIsTrue: Boolean) : Intent {
            return Intent(packageContext, CheatActivity::class.java).apply { // this 반환
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}