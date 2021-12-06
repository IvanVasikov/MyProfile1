package com.example.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View;
import androidx.core.content.ContextCompat
import androidx.appcompat.widget.Toolbar
import org.jetbrains.anko.doAsync
import java.net.URL


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

        var url:String = "https://lk.etu.ru/dashboard/api/user"
        doAsync {
            val apiResponse = URL(url).readText()
            Log.d("INFO", apiResponse)
        }
    }

    /*
    Выход из приложение на кнопку "Назад"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.toolbar) finish()
        return true
    }
     */

}