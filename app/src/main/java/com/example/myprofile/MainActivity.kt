package com.example.myprofile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View;
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.appcompat.widget.Toolbar
import org.jetbrains.anko.doAsync
import java.net.URL

import android.text.Editable

import android.text.TextWatcher





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
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
                }
            }
        })
        val text3 = findViewById<View>(R.id.dop_info_textbox) as EditText
        text1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!text3.getText().toString().equals("")) {
                    text3.setBackgroundResource(R.drawable.filled_text_box)
                }
            }
        })



    }


    /*
    Выход из приложение на кнопку "Назад"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.toolbar) finish()
        return true
    }
     */

}