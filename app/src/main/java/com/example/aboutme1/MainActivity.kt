package com.example.aboutme1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Ayush Shrivastava")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName


        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view:View){

        binding.apply {
            nicknameTextD.text = nickname.text
            myName?.nickName = nickname.text.toString()
            invalidateAll()
            nickname.visibility = View.GONE
            view.visibility = View.GONE
            nicknameTextD.visibility = View.VISIBLE

        }

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}