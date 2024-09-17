package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvPreco = findViewById<TextView>(R.id.tv_preco_result)
        val tvConsumo = findViewById<TextView>(R.id.tv_consumo_result)
        val tvDistancia = findViewById<TextView>(R.id.tv_distancia_result)
        val btnNovoCalculo = findViewById<TextView>(R.id.btn_novo_calculo)

        val precoCombustivel = intent.getFloatExtra(PRECO_COMBUSTIVEL, 0f)
        val consumoCarro = intent.getFloatExtra(CONSUMO_CARRO, 0f)
        val distanciaViagem = intent.getFloatExtra(DISTANCIA_VIAGEM,0f)


        tvPreco.text = precoCombustivel.toString()
        tvConsumo.text = consumoCarro.toString()
        tvDistancia.text = distanciaViagem.toString()


        val result = (distanciaViagem / consumoCarro) * precoCombustivel


        tvResult.text = result.toString()

        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, Inicial::class.java)
            startActivity(intent)
        }

    }
}