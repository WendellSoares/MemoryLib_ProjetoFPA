package com.example.wende.memorylib

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.View

import kotlinx.android.synthetic.main.activity_nivel.*
import kotlinx.android.synthetic.main.activity_nivel01.*

class NivelActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel)

        button_01.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Nivel01Activity::class.java))
        })

        button_02.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Nivel2Alfabeto::class.java))
        })

        button_03.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Nivel3_Alfa_Activity::class.java))
        })
        button_04.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Nivel4_Alfa_Activity::class.java))
        })

    }



}
