package ufrpe.wendellsoares.memorylib

import android.os.Bundle
import android.os.Handler
import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.*

import kotlinx.android.synthetic.main.activity_nivel01.*



class Nivel01Activity : Activity() {
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
        setContentView(R.layout.activity_nivel01)

        initBotoes()

        letrasList.add(R.mipmap.a)
        letrasList.add(R.mipmap.e)
        letrasList.add(R.mipmap.i)
        letrasList.add(R.mipmap.a)
        letrasList.add(R.mipmap.e)
        letrasList.add(R.mipmap.i)
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

        botoes.add(button_card01)
        botoes.add(button_card02)
        botoes.add(button_card03)
        botoes.add(button_card04)
        botoes.add(button_card05)
        botoes.add(button_card06)

        button_card01.setOnClickListener(actionTurnCards)
        button_card02.setOnClickListener(actionTurnCards)
        button_card03.setOnClickListener(actionTurnCards)
        button_card04.setOnClickListener(actionTurnCards)
        button_card05.setOnClickListener(actionTurnCards)
        button_card06.setOnClickListener(actionTurnCards)
    }


        override fun onStop() {
        super.onStop()
        letrasList.clear()
        count = 0
        acertos = 0
        saoIguais = false

    }

    private fun enableOneCard(id: Int, enable: Boolean){
        val btn = findViewById<ImageButton>(id)

        btn.isEnabled = enable
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

    private fun cartasIguais(id1: Int, id2: Int){

        val btn1 = findViewById<ImageButton>(id1)
        val btn2 = findViewById<ImageButton>(id2)

        botoes.remove(btn1)
        botoes.remove(btn2)

        saoIguais = false
        ++acertos
        count = 0

        if (acertos == 3){
            Toast.makeText(applicationContext, "Você completou este nível!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun randomCards(){
        letrasList!!.shuffle()
    }

    private fun turnOffAllCards(){
        for ( i in botoes){
            i.setImageResource(R.mipmap.logocard)
            i.setBackgroundResource(R.color.colorDefault)
        }
    }

    private fun enableAllCards(enable:Boolean){
        for ( i in botoes){
            i.isEnabled = enable
        }
    }

    private inner class ActionTurnCards: View.OnClickListener{
        override fun onClick(v: View?) {
            ++countClick
            enableOneCard(v!!.id, false)

            //Toast.makeText(v!!.context,""+ count,Toast.LENGTH_LONG).show()



            when(v!!.id){
                R.id.button_card01 -> {(button_card01.setImageResource(letrasList[0]))
                    (button_card01.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[0]
                    else if (idImagemAnterior == letrasList[0]){
                        cartasIguais(idAnterior, R.id.button_card01)
                    }
                }

                R.id.button_card02 -> {(button_card02.setImageResource(letrasList[1]))
                    (button_card02.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[1]
                    else if (idImagemAnterior == letrasList[1]){
                        cartasIguais(idAnterior, R.id.button_card02)
                    }
                }

                R.id.button_card03 -> {(button_card03.setImageResource(letrasList[2]))
                    (button_card03.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count ==0) idImagemAnterior = letrasList[2]
                    else if (idImagemAnterior == letrasList[2]){
                        cartasIguais(idAnterior, R.id.button_card03)
                    }
                }

                R.id.button_card04 -> {(button_card04.setImageResource(letrasList[3]))
                    (button_card04.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count==0) idImagemAnterior = letrasList[3]
                    else if (idImagemAnterior == letrasList[3]){
                        cartasIguais(idAnterior, R.id.button_card04)
                    }
                }
                R.id.button_card05 -> {(button_card05.setImageResource(letrasList[4]))
                    (button_card05.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count==0) idImagemAnterior = letrasList[4]
                    else if (idImagemAnterior == letrasList[4]){
                        cartasIguais(idAnterior, R.id.button_card05)
                    }
                }
                R.id.button_card06 -> {(button_card06.setImageResource(letrasList[5]))
                    (button_card06.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count==0) idImagemAnterior = letrasList[5]
                    else if (idImagemAnterior == letrasList[5]){
                        cartasIguais(idAnterior, R.id.button_card06)
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
