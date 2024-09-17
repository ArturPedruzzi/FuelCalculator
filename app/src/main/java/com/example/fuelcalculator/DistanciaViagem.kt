package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.Result

const val DISTANCIA_VIAGEM = "distancia_viagem"

class DistanciaViagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia_viagem)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtDistanciaViagem = findViewById<EditText>(R.id.edt_distanciaViagem)
        val btnResult = findViewById<Button>(R.id.btn_calcular)


        val precoCombustivel = intent.getFloatExtra("preco_combustivel", 0f)
        val consumoCarro = intent.getFloatExtra("consumo_carro", 0f)

        btnResult.setOnClickListener {

            val distanciaViagem = edtDistanciaViagem.text

            if (distanciaViagem.isEmpty()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Informe a distância da viagem",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                distanciaViagem.toString().toFloat()
                val intent = Intent(this, ResultCalculator::class.java)
                    .apply {
                        putExtra("distancia_viagem", distanciaViagem)
                        putExtra("preco_combustivel", precoCombustivel)
                        putExtra("consumo_carro", consumoCarro)
                    }
                startActivity(intent)
            }
        }
    }
}