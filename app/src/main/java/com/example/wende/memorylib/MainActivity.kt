package com.example.wende.memorylib

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_iniciar.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, NivelActivity::class.java))
        })

        button_instrucoes.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, InstrucoesActivity::class.java))
        })

    }

}
