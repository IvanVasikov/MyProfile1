package com.example.myprofile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View;
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.appcompat.widget.Toolbar

import android.text.Editable
import android.text.InputType

import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        val saveButton = findViewById<View>(R.id.save_button) as ImageButton
        saveButton.isClickable=false
        saveButton.isEnabled=false
        setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.back_arrow) //Стрелка "Назад"
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            toolbar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.back_arrow_on_click) //Изменить цвет стрелки при нажатии
            val handler = Handler()
            handler.postDelayed({
                toolbar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.back_arrow) //Вернуть изначальный цвет стрелки после нажатия
            }, 100)
        })
        val text1 = findViewById<View>(R.id.mobile_phone_text_box) as EditText
        text1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!text1.getText().toString().equals("")) {
                    text1.setBackgroundResource(R.drawable.filled_text_box)
                    saveButton.setImageResource(R.drawable.save_button_active)
                    saveButton.isClickable = true
                    saveButton.isEnabled=true
                }
            }
        })
        val text2 = findViewById<View>(R.id.russian_mobile_phone_text_box) as EditText
        text2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!text2.getText().toString().equals("")) {
                    text2.setBackgroundResource(R.drawable.filled_text_box)
                    saveButton.setImageResource(R.drawable.save_button_active)
                    saveButton.isClickable = true
                    saveButton.isEnabled=true
                }
            }
        })
        val text3 = findViewById<View>(R.id.dop_info_textbox) as EditText
        text3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!text3.getText().toString().equals("")) {
                    text3.setBackgroundResource(R.drawable.filled_text_box)
                    saveButton.setImageResource(R.drawable.save_button_active)
                    saveButton.isClickable = true
                    saveButton.isEnabled=true
                }
            }
        })

        saveButton.setOnClickListener()
        {
            if (saveButton.isClickable == true) {
                val inputManager: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

                inputManager.hideSoftInputFromWindow(
                    currentFocus!!.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
                saveButton.setImageResource(R.drawable.save_button_on_click)
                val handler = Handler()
                handler.postDelayed({
                    saveButton.setImageResource(R.drawable.save_button)
                }, 50)
                saveButton.isClickable = false
                saveButton.isEnabled=false
            }
        }
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewpager)

        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position ->
            when(position){
                0 -> {
                    tab.text = "Удостоверение личности"
                }
                1 -> {
                    tab.text= "Регистрация"
                }
            }
        }.attach()
        val passwordButton = findViewById<View>(R.id.password_button)  as ImageButton
        passwordButton.isClickable=false
        passwordButton.isEnabled=false
        val text4 = findViewById<View>(R.id.password) as EditText
        text4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!text4.getText().toString().equals("")) {
                    text4.setBackgroundResource(R.drawable.filled_text_box)
                    passwordButton.setImageResource(R.drawable.save_button_active)
                    passwordButton.isClickable = true
                    passwordButton.isEnabled=true
                }
            }
        })
        val text5 = findViewById<View>(R.id.password1) as EditText
        text5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!text5.getText().toString().equals("")) {
                    text5.setBackgroundResource(R.drawable.filled_text_box)
                    passwordButton.setImageResource(R.drawable.password_button_active)
                    passwordButton.isClickable = true
                    passwordButton.isEnabled=true
                }
            }
        })
        passwordButton.setOnClickListener()
        {
            if (passwordButton.isClickable == true) {
                val inputManager: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

                inputManager.hideSoftInputFromWindow(
                    currentFocus!!.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
                saveButton.setImageResource(R.drawable.password_button_clicked)
                val handler = Handler()
                handler.postDelayed({
                    saveButton.setImageResource(R.drawable.password_button)
                }, 50)
                saveButton.isClickable = false
                saveButton.isEnabled=false
            }
        }


    }

}

