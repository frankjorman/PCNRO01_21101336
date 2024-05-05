package com.example.pcnro01

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PromedioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_promedio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etResultado= findViewById<TextView>(R.id.lblResultado)
        val etNotalFinal= findViewById<TextView>(R.id.lblNotaFinal)

        val notalFinal = intent.getStringExtra("notaFinal")
        val resultado = intent.getStringExtra("resultado")

        if (resultado == "Aprobado"){
            etResultado.setTextColor(Color.BLUE)
        }else{
            etResultado.setTextColor(Color.RED)
        }

        etNotalFinal.text = notalFinal.toString();
        etResultado.text = resultado.toString();
    }
}