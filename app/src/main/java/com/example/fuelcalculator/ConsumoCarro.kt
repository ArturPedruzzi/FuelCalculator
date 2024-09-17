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

const val CONSUMO_CARRO = "consumo_carro"

class ConsumoCarro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo_carro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val edtConsumoCarro = findViewById<EditText>(R.id.edt_consumoCarro)
        val btnProxDistancia = findViewById<Button>(R.id.btn_proxDistancia)

        val precoCombustivel = intent.getFloatExtra(PRECO_COMBUSTIVEL, 0f)

        btnProxDistancia.setOnClickListener {

            val consumoCarro = edtConsumoCarro.text

            if (consumoCarro.isEmpty()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Informe o consumo do carro",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                consumoCarro.toString().toFloat()
                val intent = Intent(this, DistanciaViagem::class.java)
                    .apply {
                        putExtra("consumo_carro", consumoCarro)
                        putExtra("preco_combustivel", precoCombustivel)
                    }
                startActivity(intent)
            }
        }

    }
}