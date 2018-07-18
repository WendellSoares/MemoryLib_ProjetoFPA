package com.example.wende.memorylib

import android.os.Bundle
import android.view.View
import android.app.Activity
import android.media.Image
import android.os.Handler
import android.widget.ImageButton
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_nivel2_alfabeto.*



class Nivel2Alfabeto : Activity() {
    private val letrasList = ArrayList<Int>()
    private var count = 0
    private var idAnterior = 0
    private var idImagemAnterior = 0
    private var saoIguais = false
    private val handler = Handler()
    private var countClick = 0
    private var acertos = 0
    private val botoes = ArrayList<ImageButton>()
    private val actionTurnCards = ActionTurnCards()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel2_alfabeto)

        initBotoes()
        letrasList.add(R.mipmap.b)
        letrasList.add(R.mipmap.b)
        letrasList.add(R.mipmap.c)
        letrasList.add(R.mipmap.c)
        letrasList.add(R.mipmap.d)
        letrasList.add(R.mipmap.d)
        letrasList.add(R.mipmap.f)
        letrasList.add(R.mipmap.f)
        letrasList.add(R.mipmap.g)
        letrasList.add(R.mipmap.g)
        letrasList.add(R.mipmap.h)
        letrasList.add(R.mipmap.h)
        randomCards()

        button_recomecar.setOnClickListener({
            initBotoes()
            turnOffAllCards()
            randomCards()
            enableAllCards(true)
        })
    }

    private fun initBotoes(){
        botoes.clear()
        botoes.add(button_card21)
        botoes.add(button_card22)
        botoes.add(button_card23)
        botoes.add(button_card24)
        botoes.add(button_card25)
        botoes.add(button_card26)
        botoes.add(button_card27)
        botoes.add(button_card28)
        botoes.add(button_card29)
        botoes.add(button_card210)
        botoes.add(button_card211)
        botoes.add(button_card212)

        for (i in botoes){
            i.setOnClickListener(actionTurnCards)
        }
    }

    override fun onStop() {
        super.onStop()
        letrasList.clear()
        count = 0
        acertos = 0
        saoIguais = false

    }

    private fun turnOffAllCards(){
        for ( i in botoes){
            i.setImageResource(R.mipmap.logocard)
            i.setBackgroundResource(R.color.colorDefault)
        }
    }

    private fun randomCards(){
        letrasList!!.shuffle()
    }

    private fun enableCards(id1: Int, id2: Int, enable: Boolean){
        val btn1 = findViewById<ImageButton>(id1)
        val btn2 = findViewById<ImageButton>(id2)

        btn1.isEnabled = enable
        btn2.isEnabled = enable

    }

    private fun enableOneCard(id: Int, enable: Boolean){
        val btn = findViewById<ImageButton>(id)

        btn.isEnabled = enable
    }

    private fun cartasIguais(id1: Int, id2: Int){

        enableCards(id1, id2, false)
        val btn1 = findViewById<ImageButton>(id1)
        val btn2 = findViewById<ImageButton>(id2)

        botoes.remove(btn1)
        botoes.remove(btn2)

        saoIguais = false
        ++acertos
        count = 0

        if (acertos == 6){
            Toast.makeText(applicationContext, "Você completou este nível!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun turnOfCard(id1: Int, id2: Int){
        val btn1 =  findViewById<ImageButton>(id1)
        val btn2 = findViewById<ImageButton>(id2)

        btn1.setImageResource(R.mipmap.logocard)
        btn1.setBackgroundResource(R.color.colorDefault)
        btn2.setImageResource(R.mipmap.logocard)
        btn2.setBackgroundResource(R.color.colorDefault)
        count = 0
        enableAllCards(true)


    }

    private fun enableAllCards(enable:Boolean){
        for ( i in botoes){
            i.isEnabled = enable
        }
    }

    private inner class ActionTurnCards: View.OnClickListener {
        override fun onClick(v: View?) {
            ++countClick
            enableOneCard(v!!.id, false)

            //Toast.makeText(v!!.context,""+ count,Toast.LENGTH_LONG).show()


            when (v.id) {
                R.id.button_card21 -> {
                    (button_card21.setImageResource(letrasList[0]))
                    (button_card21.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[0]
                    else if (idImagemAnterior == letrasList[0]) {
                        cartasIguais(idAnterior,R.id.button_card21)
                    }
                }

                R.id.button_card22 -> {
                    (button_card22.setImageResource(letrasList[1]))
                    (button_card22.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[1]
                    else if (idImagemAnterior == letrasList[1]) {
                        cartasIguais(idAnterior,R.id.button_card22)
                    }
                }

                R.id.button_card23 -> {
                    (button_card23.setImageResource(letrasList[2]))
                    (button_card23.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[2]
                    else if (idImagemAnterior == letrasList[2]) {
                        cartasIguais(idAnterior,R.id.button_card23)
                    }
                }

                R.id.button_card24 -> {
                    (button_card24.setImageResource(letrasList[3]))
                    (button_card24.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[3]
                    else if (idImagemAnterior == letrasList[3]) {
                        cartasIguais(idAnterior,R.id.button_card24)
                    }
                }
                R.id.button_card25 -> {
                    (button_card25.setImageResource(letrasList[4]))
                    (button_card25.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[4]
                    else if (idImagemAnterior == letrasList[4]) {
                        cartasIguais(idAnterior,R.id.button_card25)
                    }
                }
                R.id.button_card26 -> {
                    (button_card26.setImageResource(letrasList[5]))
                    (button_card26.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[5]
                    else if (idImagemAnterior == letrasList[5]) {
                        cartasIguais(idAnterior,R.id.button_card26)
                    }
                }
                R.id.button_card27 -> {
                    (button_card27.setImageResource(letrasList[6]))
                    (button_card27.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[6]
                    else if (idImagemAnterior == letrasList[6]) {
                        cartasIguais(idAnterior,R.id.button_card27)
                    }
                }
                R.id.button_card28 -> {
                    (button_card28.setImageResource(letrasList[7]))
                    (button_card28.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[7]
                    else if (idImagemAnterior == letrasList[7]) {
                        cartasIguais(idAnterior,R.id.button_card28)
                    }
                }
                R.id.button_card29 -> {
                    (button_card29.setImageResource(letrasList[8]))
                    (button_card29.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[8]
                    else if (idImagemAnterior == letrasList[8]) {
                        cartasIguais(idAnterior,R.id.button_card29)
                    }
                }
                R.id.button_card210 -> {
                    (button_card210.setImageResource(letrasList[9]))
                    (button_card210.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[9]
                    else if (idImagemAnterior == letrasList[9]) {
                        cartasIguais(idAnterior,R.id.button_card210)
                    }
                }
                R.id.button_card211 -> {
                    (button_card211.setImageResource(letrasList[10]))
                    (button_card211.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[10]
                    else if (idImagemAnterior == letrasList[10]) {
                        cartasIguais(idAnterior,R.id.button_card211)
                    }
                }
                R.id.button_card212 -> {
                    (button_card212.setImageResource(letrasList[11]))
                    (button_card212.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[11]
                    else if (idImagemAnterior == letrasList[11]) {
                        cartasIguais(idAnterior,R.id.button_card212)
                    }
                }
            }
            if (count == 0) {
                idAnterior = v.id
                count++
            } else if (!saoIguais) {
                enableAllCards(false)
                handler.postDelayed({ turnOfCard(idAnterior, v.id) }, 1000)

            } else {
                saoIguais = false
            }

            if (countClick > 1) {
                count = 0
                countClick = 0
            }
        }
    }

}
