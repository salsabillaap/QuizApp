package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import kotlinx.android.synthetic.main.activity_soal_quiz.*

class SoalQuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mSoalList: ArrayList<Soal>? = null

    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0

    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal_quiz)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mSoalList = Constants.getSoal()

        setSoal()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.tv_option_one ->{

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two ->{

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three ->{

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four ->{

                selectedOptionView(tv_option_four,4 )
            }

            R.id.btn_submit ->{

                if(mSelectedOptionPosition == 0){

                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mSoalList!!.size ->{

                            setSoal()
                        }else ->{

                        val intent = Intent(this, HasilActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                        intent.putExtra(Constants.TOTAL_SOAL, mSoalList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }else{
                    val  soal = mSoalList?.get(mCurrentPosition -1)

                    if(soal!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(soal.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mSoalList!!.size){
                        btn_submit.text = "SELESAI"
                    }else{
                        btn_submit.text = "SELANJUTNYA"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun setSoal(){

        val soal = mSoalList!![mCurrentPosition -1]

        defaultOptionsView()

        if (mCurrentPosition == mSoalList!!.size){
            btn_submit.text = "SELESAI"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_soal.text = soal!!.soal
        iv_image.setImageResource(soal.image)
        tv_option_one.text = soal.optionOne
        tv_option_two.text = soal.optionTwo
        tv_option_three.text = soal.optionThree
        tv_option_four.text = soal.optionFour
    }

    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363a43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.default_option_border_bg
        )
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }

    }

    private fun answerView(answer: Int, drawablesView: Int){
        when(answer){
            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this@SoalQuizActivity,
                     drawablesView
                )
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(
                    this@SoalQuizActivity,
                    drawablesView
                )
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this@SoalQuizActivity,
                     drawablesView
                )
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this@SoalQuizActivity,
                     drawablesView
                )
            }
        }
    }
}