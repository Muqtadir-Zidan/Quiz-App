package com.example.quiz

import android.annotation.SuppressLint
import android.graphics.Color.parseColor
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    val op1 = findViewById<TextView>(R.id.tv_option_one)
    val op2 = findViewById<TextView>(R.id.tv_option_two)
    val op3 = findViewById<TextView>(R.id.tv_option_three)
    val op4 = findViewById<TextView>(R.id.tv_option_four)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constents.getQuestions()

        setQuestion()

        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        op4.setOnClickListener(this)


    }

    private fun setQuestion(){

        mCurrentPosition = 1
        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionView()


        val pro_bar = findViewById<ProgressBar>(R.id.progressBar)
        pro_bar.progress = mCurrentPosition
        val tv_proBar = findViewById<TextView>(R.id.tv_progress)
        tv_proBar.text = "$mCurrentPosition" + "/" + pro_bar.max

        val tv_Qus = findViewById<TextView>(R.id.tv_question)
        tv_Qus.text = question.question
        val img = findViewById<ImageView>(R.id.iv_image)
        img.setImageResource(question.image)

        op1.text = question.optionOne
        op2.text = question.optionTwo
        op3.text = question.optionThree
        op4.text = question.optionFour


    }

    @SuppressLint("ResourceType")
    private fun  defaultOptionView(){



        val options = ArrayList<TextView>()
        options.add(0, op1)
        options.add(1, op2)
        options.add(2, op3)
        options.add(3, op4)

        for (option in options){
            option. setTextColor(getColor(parseColor("#7A8089")))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this, R.drawable.default_option_border_bg
            )
        }



    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(op1, selectOptionNum = 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(op2, selectOptionNum = 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(op3, selectOptionNum = 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(op4, selectOptionNum = 4)
            }

        }

    }
    @SuppressLint("ResourceType")
    private fun selectedOptionView(
            tv:TextView, selectOptionNum: Int)
    {
        defaultOptionView()
        mSelectedOptionPosition = selectOptionNum

            tv.setTextColor(getColor(parseColor("#363A43")))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(
                    this, R.drawable.selected,
            )



    }

}