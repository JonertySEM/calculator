package com.example.calculatrorworks

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs


class MainActivity : AppCompatActivity() {

    var newNumb = true
    var oldNumber = ""
    var sigm = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


}

    fun numbersdo(view: View){
        if(newNumb)
            writingnumbers.setText("")
        newNumb = false
        var clicbutton =  writingnumbers.text.toString()
        var selectbuton = view as Button
        when(selectbuton.id){
            buttonofnull.id ->{
                clicbutton +="0"
            }
            button11.id ->{
                clicbutton +="1"
            }
            buttonof2.id ->{
                clicbutton +="2"
            }
            buttonof3.id ->{
                clicbutton +="3"
            }
            button14.id ->{
                clicbutton +="4"
            }
            buttonof5.id ->{
                clicbutton +="5"
            }
            buttonof6.id ->{
                clicbutton +="6"
            }
            buttonof7.id ->{
                clicbutton +="7"
            }
            buttonof8.id ->{
                clicbutton +="8"
            }
            buttonof9.id ->{
                clicbutton +="9"
            }
            buttonofcomm.id ->{
                clicbutton+="."
            }

            buttonofplusorminus.id -> {
                clicbutton = "-$clicbutton"
            }


        }
        writingnumbers.setText(clicbutton)
    }

    fun operatorEvent(view: View) {
        newNumb = true
        oldNumber = writingnumbers.text.toString()

        var selectbutton = view as Button

        when(selectbutton.id){
            buttonofplus.id -> {
                sigm = "+"
            }
            buttonofminus.id -> {
                sigm = "-"
            }
            buttonofmultpllic.id -> {
                sigm = "x"
            }
            buttonofdel.id -> {
                sigm = "/"
            }
        }

    }

    fun ansNumb(view: View) {
        var endNumb = writingnumbers.text.toString()
        var resultD = 0.0
        var resultI = 0
        var flag = true

        when(sigm){
            "+" -> {
                if(Math.abs(oldNumber.toDouble() + endNumb.toDouble()) == Math.abs(oldNumber.toDouble() + endNumb.toDouble()).toInt().toDouble())
                {
                    resultI= oldNumber.toInt() + endNumb.toInt()
                    flag = false
                }
                else
                    resultD = oldNumber.toDouble() + endNumb.toDouble()
            }
            "x" -> {
                if(Math.abs(oldNumber.toDouble() * endNumb.toDouble()) == Math.abs(oldNumber.toDouble() * endNumb.toDouble()).toInt().toDouble())
                {
                    resultI= oldNumber.toInt() * endNumb.toInt()
                    flag = false
                }
                else
                    resultD = oldNumber.toDouble() * endNumb.toDouble()

            }
            "/" -> {
                if(Math.abs(oldNumber.toDouble() / endNumb.toDouble()) == Math.abs(oldNumber.toDouble() / endNumb.toDouble()).toInt().toDouble())
                {
                    resultI= oldNumber.toInt() / endNumb.toInt()
                    flag = false
                }
                else
                    resultD = oldNumber.toDouble() / endNumb.toDouble()

            }
            "-" -> {
                if(Math.abs(oldNumber.toDouble() - endNumb.toDouble()) == Math.abs(oldNumber.toDouble() - endNumb.toDouble()).toInt().toDouble())
                {
                    resultI= oldNumber.toInt() - endNumb.toInt()
                    flag = false
                }
                else
                    resultD = oldNumber.toDouble() - endNumb.toDouble()

            }


        }
        if(flag) writingnumbers.setText(resultD.toString())
        else writingnumbers.setText(resultI.toString())

    }

    fun clearing(view: View) {
        writingnumbers.setText("")
        newNumb =true

    }

    fun percent(view: View) {
        var tmp = writingnumbers.text.toString().toDouble()/100
        writingnumbers.setText(tmp.toString())
        newNumb = true
    }


}

