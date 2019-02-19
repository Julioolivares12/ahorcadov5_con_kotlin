package com.develop.julio.ahorcadov5

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edtletra : EditText
    lateinit var  edtE : EditText
    lateinit var edtT: EditText

    lateinit var edtP : EditText
    lateinit var edtS : EditText
    lateinit var edt1 : EditText

    lateinit var btnvalidar : Button
    lateinit var tvahorcado : TextView


    var scret = "ETPS1"
    var cantidadFallos =0
    var aciertos =0
    var ahorcado = ""

    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtletra = findViewById(R.id.edtletra)
        edtE = findViewById(R.id.edtE)
        edtT = findViewById(R.id.edtT)
        edtP = findViewById(R.id.edtP)
        edtS = findViewById(R.id.edtS)
        edt1 = findViewById(R.id.edt1)

        tvahorcado = findViewById(R.id.tvhaorcado)

        btnvalidar = findViewById(R.id.btnvalidar)

        btnvalidar.setOnClickListener {
            val lt = edtletra.text.toString().trim()
            val existe = validar(lt)


            if (existe){
                Toast.makeText(applicationContext,"Existe",Toast.LENGTH_SHORT).show()
                aciertos +=1
                when (lt){
                    "E" -> edtE.setText("E")
                    "T" -> edtT.setText("T")
                    "P"-> edtP.setText("P")
                    "S"->edtS.setText("S")
                    "1"->edt1.setText("1")
                }
            }else{
                cantidadFallos +=1
                when(cantidadFallos){
                    1 -> {
                        ahorcado = "a"
                        tvahorcado.text = ahorcado
                    }
                    2 ->{
                        ahorcado+="h"
                        tvahorcado.text = ahorcado
                    }
                    3->{
                        ahorcado += "o"
                        tvahorcado.text = ahorcado
                    }
                    4->{
                        ahorcado += "r"
                        tvahorcado.text = ahorcado
                    }
                    5->{
                        ahorcado +="c"
                        tvahorcado.text = ahorcado
                    }
                    6->{
                        ahorcado+="a"
                        tvahorcado.text = ahorcado
                    }
                    7->{
                        ahorcado +="d"
                        tvahorcado.text = ahorcado
                    }
                    8->{
                        ahorcado +="o"
                        tvahorcado.text = ahorcado
                    }
                }
                edtletra.setText("")
            }
            if (aciertos == 5){
                Toast.makeText(applicationContext,"Felicides ganaste",Toast.LENGTH_SHORT).show()
                val alertDialog = android.support.v7.app.AlertDialog.Builder(applicationContext)
                    .setPositiveButton("aceptar") { _: DialogInterface, i: Int ->
                        edtletra.setText("")
                        edtE.setText("")
                        edtS.setText("")
                        edtT.setText("")
                        edt1.setText("")
                        edtP.setText("")
                        tvahorcado.text = "jugando"
                        aciertos =0
                        cantidadFallos =0
                    }.setNegativeButton("cancelar"){dialog, which -> dialog.dismiss() }

                val alert = alertDialog.create()
                alert.show()
            }
            else if (cantidadFallos == 8){
                val alertDialog = android.support.v7.app.AlertDialog.Builder(applicationContext)
                    .setPositiveButton("aceptar") { _: DialogInterface, _: Int ->
                        edtletra.setText("")
                        edtE.setText("")
                        edtS.setText("")
                        edtT.setText("")
                        edt1.setText("")
                        edtP.setText("")
                        tvahorcado.text = ""
                    }.setNegativeButton("cancelar"){dialog, _ -> dialog.dismiss() }

                val alert = alertDialog.create()
                alert.show()
            }
        }
    }

    private fun validar(str : String) : Boolean{
        return scret.contains(str)
    }
}

