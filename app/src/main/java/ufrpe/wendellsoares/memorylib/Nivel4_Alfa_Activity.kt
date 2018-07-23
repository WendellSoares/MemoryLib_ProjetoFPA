package ufrpe.wendellsoares.memorylib

import android.os.Bundle
import android.view.View
import android.app.Activity
import android.media.Image
import android.os.Handler
import android.widget.ImageButton
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_nivel4__alfa_.*



class Nivel4_Alfa_Activity : Activity() {
    private val letrasList = ArrayList<Int>()
    private var count = 0
    private var idAnterior = 0
    private var idImagemAnterior = 0
    private var saoIguais = false
    private val handler = Handler()
    private var countClick = 0
    private var acertos = 0
    private val botoes = ArrayList<ImageButton>()
    private val botoesCongelados = ArrayList<ImageButton>()

    private val actionTurnCards = ActionTurnCards()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel4__alfa_)



        initBotoes()

        letrasList.add(R.mipmap.s)
        letrasList.add(R.mipmap.s)
        letrasList.add(R.mipmap.t)
        letrasList.add(R.mipmap.t)
        letrasList.add(R.mipmap.u)
        letrasList.add(R.mipmap.u)
        letrasList.add(R.mipmap.v)
        letrasList.add(R.mipmap.v)
        letrasList.add(R.mipmap.w)
        letrasList.add(R.mipmap.w)
        letrasList.add(R.mipmap.x)
        letrasList.add(R.mipmap.x)
        letrasList.add(R.mipmap.y)
        letrasList.add(R.mipmap.y)
        letrasList.add(R.mipmap.z)
        letrasList.add(R.mipmap.z)
        letrasList.add(R.mipmap.a)
        letrasList.add(R.mipmap.a)
        letrasList.add(R.mipmap.e)
        letrasList.add(R.mipmap.e)
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
        botoes.add(button_card41)
        botoes.add(button_card42)
        botoes.add(button_card43)
        botoes.add(button_card44)
        botoes.add(button_card45)
        botoes.add(button_card46)
        botoes.add(button_card47)
        botoes.add(button_card48)
        botoes.add(button_card49)
        botoes.add(button_card410)
        botoes.add(button_card411)
        botoes.add(button_card412)
        botoes.add(button_card413)
        botoes.add(button_card414)
        botoes.add(button_card415)
        botoes.add(button_card416)
        botoes.add(button_card417)
        botoes.add(button_card418)
        botoes.add(button_card419)
        botoes.add(button_card420)

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

        if (acertos == 10){
            Toast.makeText(applicationContext, "Você completou este nível!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun acertosCongelados(){
        for  (i in botoesCongelados){
            enableOneCard(i.id, false)
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
                R.id.button_card41 -> {
                    (button_card41.setImageResource(letrasList[0]))
                    (button_card41.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[0]
                    else if (idImagemAnterior == letrasList[0]) {
                        cartasIguais(idAnterior,R.id.button_card41)
                    }
                }

                R.id.button_card42 -> {
                    (button_card42.setImageResource(letrasList[1]))
                    (button_card42.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[1]
                    else if (idImagemAnterior == letrasList[1]) {
                        cartasIguais(idAnterior,R.id.button_card42)
                    }
                }

                R.id.button_card43 -> {
                    (button_card43.setImageResource(letrasList[2]))
                    (button_card43.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[2]
                    else if (idImagemAnterior == letrasList[2]) {
                        cartasIguais(idAnterior,R.id.button_card43)
                    }
                }

                R.id.button_card44 -> {
                    (button_card44.setImageResource(letrasList[3]))
                    (button_card44.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[3]
                    else if (idImagemAnterior == letrasList[3]) {
                        cartasIguais(idAnterior,R.id.button_card44)
                    }
                }
                R.id.button_card45 -> {
                    (button_card45.setImageResource(letrasList[4]))
                    (button_card45.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[4]
                    else if (idImagemAnterior == letrasList[4]) {
                        cartasIguais(idAnterior,R.id.button_card45)
                    }
                }
                R.id.button_card46 -> {
                    (button_card46.setImageResource(letrasList[5]))
                    (button_card46.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[5]
                    else if (idImagemAnterior == letrasList[5]) {
                        cartasIguais(idAnterior,R.id.button_card46)
                    }
                }
                R.id.button_card47 -> {
                    (button_card47.setImageResource(letrasList[6]))
                    (button_card47.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[6]
                    else if (idImagemAnterior == letrasList[6]) {
                        cartasIguais(idAnterior,R.id.button_card47)
                    }
                }
                R.id.button_card48 -> {
                    (button_card48.setImageResource(letrasList[7]))
                    (button_card48.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[7]
                    else if (idImagemAnterior == letrasList[7]) {
                        cartasIguais(idAnterior,R.id.button_card48)
                    }
                }
                R.id.button_card49 -> {
                    (button_card49.setImageResource(letrasList[8]))
                    (button_card49.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[8]
                    else if (idImagemAnterior == letrasList[8]) {
                        cartasIguais(idAnterior,R.id.button_card49)
                    }
                }
                R.id.button_card410 -> {
                    (button_card410.setImageResource(letrasList[9]))
                    (button_card410.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[9]
                    else if (idImagemAnterior == letrasList[9]) {
                        cartasIguais(idAnterior,R.id.button_card410)
                    }
                }
                R.id.button_card411 -> {
                    (button_card411.setImageResource(letrasList[10]))
                    (button_card411.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[10]
                    else if (idImagemAnterior == letrasList[10]) {
                        cartasIguais(idAnterior,R.id.button_card411)
                    }
                }
                R.id.button_card412 -> {
                    (button_card412.setImageResource(letrasList[11]))
                    (button_card412.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[11]
                    else if (idImagemAnterior == letrasList[11]) {
                        cartasIguais(idAnterior,R.id.button_card412)
                    }
                }
                R.id.button_card413 -> {
                    (button_card413.setImageResource(letrasList[12]))
                    (button_card413.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[12]
                    else if (idImagemAnterior == letrasList[12]) {
                        cartasIguais(idAnterior,R.id.button_card413)
                    }
                }
                R.id.button_card414 -> {
                    (button_card414.setImageResource(letrasList[13]))
                    (button_card414.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[13]
                    else if (idImagemAnterior == letrasList[13]) {
                        cartasIguais(idAnterior,R.id.button_card414)
                    }
                }
                R.id.button_card415 -> {
                    (button_card415.setImageResource(letrasList[14]))
                    (button_card415.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[14]
                    else if (idImagemAnterior == letrasList[14]) {
                        cartasIguais(idAnterior,R.id.button_card415)
                    }
                }
                R.id.button_card416 -> {
                    (button_card416.setImageResource(letrasList[15]))
                    (button_card416.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[15]
                    else if (idImagemAnterior == letrasList[15]) {
                        cartasIguais(idAnterior,R.id.button_card416)
                    }
                }
                R.id.button_card417 -> {
                    (button_card417.setImageResource(letrasList[16]))
                    (button_card417.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[16]
                    else if (idImagemAnterior == letrasList[16]) {
                        cartasIguais(idAnterior,R.id.button_card417)
                    }
                }
                R.id.button_card418 -> {
                    (button_card418.setImageResource(letrasList[17]))
                    (button_card418.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[17]
                    else if (idImagemAnterior == letrasList[17]) {
                        cartasIguais(idAnterior,R.id.button_card418)
                    }
                }
                R.id.button_card419 -> {
                    (button_card419.setImageResource(letrasList[18]))
                    (button_card419.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[18]
                    else if (idImagemAnterior == letrasList[18]) {
                        cartasIguais(idAnterior,R.id.button_card419)
                    }
                }
                R.id.button_card420 -> {
                    (button_card420.setImageResource(letrasList[19]))
                    (button_card420.setBackgroundColor(resources.getColor(R.color.colorWhite)))
                    if (count == 0) idImagemAnterior = letrasList[19]
                    else if (idImagemAnterior == letrasList[19]) {
                        cartasIguais(idAnterior,R.id.button_card420)
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
