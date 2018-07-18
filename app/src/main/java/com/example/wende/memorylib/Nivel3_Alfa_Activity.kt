package com.example.wende.memorylib

import android.os.Bundle
import android.view.View
import android.app.Activity
import android.media.Image
import android.os.Handler
import android.widget.ImageButton
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_nivel3__alfa_.*



class Nivel3_Alfa_Activity : Activity() {

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
        setContentView(R.layout.activity_nivel3__alfa_)

        initBotoes()

        letrasList.add(R.mipmap.j)
        letrasList.add(R.mipmap.j)
        letrasList.add(R.mipmap.l)
        letrasList.add(R.mipmap.l)
        letrasList.add(R.mipmap.m)
        letrasList.add(R.mipmap.m)
        letrasList.add(R.mipmap.n)
        letrasList.add(R.mipmap.n)
        letrasList.add(R.mipmap.o)
        letrasList.add(R.mipmap.o)
        letrasList.add(R.mipmap.p)
        letrasList.add(R.mipmap.p)
        letrasList.add(R.mipmap.q)
        letrasList.add(R.mipmap.q)
        letrasList.add(R.mipmap.r)
        letrasList.add(R.mipmap.r)
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
        botoes.add(button_card31)
        botoes.add(button_card32)
        botoes.add(button_card33)
        botoes.add(button_card34)
        botoes.add(button_card35)
        botoes.add(button_card36)
        botoes.add(button_card37)
        botoes.add(button_card38)
        botoes.add(button_card39)
        botoes.add(button_card310)
        botoes.add(button_card311)
        botoes.add(button_card312)
        botoes.add(button_card313)
        botoes.add(button_card314)
        botoes.add(button_card315)
        botoes.add(button_card316)

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

        val btn1 = findViewById<ImageButton>(id1)
        val btn2 = findViewById<ImageButton>(id2)
        botoes.remove(btn1)
        botoes.remove(btn2)

        enableCards(id1, id2, false)

        saoIguais = false
        ++acertos
        count = 0

        if (acertos == 8){
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
                R.id.button_card31 -> {
                    (button_card31.setImageResource(letrasList[0]))
                    (button_card31.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[0]
                    else if (idImagemAnterior == letrasList[0]) {
                        cartasIguais(idAnterior,R.id.button_card31)
                    }
                }

                R.id.button_card32 -> {
                    (button_card32.setImageResource(letrasList[1]))
                    (button_card32.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[1]
                    else if (idImagemAnterior == letrasList[1]) {
                        cartasIguais(idAnterior,R.id.button_card32)
                    }
                }

                R.id.button_card33 -> {
                    (button_card33.setImageResource(letrasList[2]))
                    (button_card33.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[2]
                    else if (idImagemAnterior == letrasList[2]) {
                        cartasIguais(idAnterior,R.id.button_card33)
                    }
                }

                R.id.button_card34 -> {
                    (button_card34.setImageResource(letrasList[3]))
                    (button_card34.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[3]
                    else if (idImagemAnterior == letrasList[3]) {
                        cartasIguais(idAnterior,R.id.button_card34)
                    }
                }
                R.id.button_card35 -> {
                    (button_card35.setImageResource(letrasList[4]))
                    (button_card35.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[4]
                    else if (idImagemAnterior == letrasList[4]) {
                        cartasIguais(idAnterior,R.id.button_card35)
                    }
                }
                R.id.button_card36 -> {
                    (button_card36.setImageResource(letrasList[5]))
                    (button_card36.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[5]
                    else if (idImagemAnterior == letrasList[5]) {
                        cartasIguais(idAnterior,R.id.button_card36)
                    }
                }
                R.id.button_card37 -> {
                    (button_card37.setImageResource(letrasList[6]))
                    (button_card37.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[6]
                    else if (idImagemAnterior == letrasList[6]) {
                        cartasIguais(idAnterior,R.id.button_card37)
                    }
                }
                R.id.button_card38 -> {
                    (button_card38.setImageResource(letrasList[7]))
                    (button_card38.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[7]
                    else if (idImagemAnterior == letrasList[7]) {
                        cartasIguais(idAnterior,R.id.button_card38)
                    }
                }
                R.id.button_card39 -> {
                    (button_card39.setImageResource(letrasList[8]))
                    (button_card39.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[8]
                    else if (idImagemAnterior == letrasList[8]) {
                        cartasIguais(idAnterior,R.id.button_card39)
                    }
                }
                R.id.button_card310 -> {
                    (button_card310.setImageResource(letrasList[9]))
                    (button_card310.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[9]
                    else if (idImagemAnterior == letrasList[9]) {
                        cartasIguais(idAnterior,R.id.button_card310)
                    }
                }
                R.id.button_card311 -> {
                    (button_card311.setImageResource(letrasList[10]))
                    (button_card311.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[10]
                    else if (idImagemAnterior == letrasList[10]) {
                        cartasIguais(idAnterior,R.id.button_card311)
                    }
                }
                R.id.button_card312 -> {
                    (button_card312.setImageResource(letrasList[11]))
                    (button_card312.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[11]
                    else if (idImagemAnterior == letrasList[11]) {
                        cartasIguais(idAnterior,R.id.button_card312)
                    }
                }
                R.id.button_card313 -> {
                    (button_card313.setImageResource(letrasList[12]))
                    (button_card313.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[12]
                    else if (idImagemAnterior == letrasList[12]) {
                        cartasIguais(idAnterior,R.id.button_card313)
                    }
                }
                R.id.button_card314 -> {
                    (button_card314.setImageResource(letrasList[13]))
                    (button_card314.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[13]
                    else if (idImagemAnterior == letrasList[13]) {
                        cartasIguais(idAnterior,R.id.button_card314)
                    }
                }
                R.id.button_card315 -> {
                    (button_card315.setImageResource(letrasList[14]))
                    (button_card315.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[14]
                    else if (idImagemAnterior == letrasList[14]) {
                        cartasIguais(idAnterior,R.id.button_card315)
                    }
                }
                R.id.button_card316 -> {
                    (button_card316.setImageResource(letrasList[15]))
                    (button_card316.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[15]
                    else if (idImagemAnterior == letrasList[15]) {
                        cartasIguais(idAnterior,R.id.button_card316)
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
