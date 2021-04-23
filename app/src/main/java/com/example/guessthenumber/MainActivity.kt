package com.example.guessthenumber

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guessthenumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private var num: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private var beg = 0
    private var last = num.size - 1
    private var mid = num.size / 2
    private var qBarNum = num[mid]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setTextOfQuestionBar(qBarNum)

        bind.prevButton.setOnClickListener {
            enableReset()
            makeDisplayBarInvisible()
            //move to lower hierarchy
            updateNum()
            setTextOfQuestionBar(qBarNum)

        }

        bind.check.setOnClickListener {
            enableReset()
            makeDisplayBarVisible()
            setTextOfDisplayBar(qBarNum)
            init()
        }

        bind.nextButton.setOnClickListener {
            enableReset()
            makeDisplayBarInvisible()
            //move to higher hierarchy
            updateNum()
            setTextOfQuestionBar(qBarNum)


        }

        bind.resetButton.setOnClickListener {
            reset()
        }


    }

    private fun updateNum() {
        mid = (beg + last) / 2
        qBarNum = num[mid]
    }

    private fun setTextOfDisplayBar(num: Int) {
        bind.displayBar.text = String.format(resources.getString(R.string.display), num)
    }

    private fun setTextOfQuestionBar(num: Int) {
        bind.questionBar.text = String.format(resources.getString(R.string.question), num)
    }

    private fun reset() {
        disableReset()
        makeDisplayBarInvisible()
        init()
        setTextOfQuestionBar(qBarNum)
    }

    private fun init() {
        beg = 0
        last = num.size - 1
        mid = num.size / 2
        qBarNum = num[mid]
    }

    private fun enableReset() {
        bind.resetButton.isEnabled = true
    }

    private fun disableReset() {
        bind.resetButton.isEnabled = false
    }

    private fun makeDisplayBarVisible() {
        bind.displayBar.visibility = View.VISIBLE
    }

    private fun makeDisplayBarInvisible() {
        bind.displayBar.visibility = View.INVISIBLE
    }
}