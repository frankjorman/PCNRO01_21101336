package com.example.pcnro01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etExamenParcial: EditText = findViewById(R.id.txtExamenParcial)
        val etExamenFinal: EditText = findViewById(R.id.txtExamenFinal)
        val etPep: EditText = findViewById(R.id.txtPep)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener{
            this.evaluarNota(etExamenParcial.text.toString(),etExamenFinal.text.toString(),etPep.text.toString())
        }
    }

    private fun evaluarNota(examenParcial: String,examenFinal: String,pep: String){
        val porcentajeParcial = 0.20
        val porcentajeFinal = 0.20
        val porcentajePEP = 0.60

        val notaFinal =   (examenParcial.toDouble() * porcentajeParcial) + (examenFinal.toDouble() * porcentajeFinal) + (pep.toDouble() * porcentajePEP)

        var resultado = ""
        if (notaFinal > 10.5){
            resultado = "Aprobado"
        }else{
            resultado = "Desaprobado"
        }

        val intent = Intent(this, PromedioActivity::class.java)
        intent.putExtra("resultado",resultado)
        intent.putExtra("notaFinal",notaFinal.toString())
        startActivity(intent)
    }
}