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

const val PRECO_COMBUSTIVEL = "preco_combustivel"

class PrecoCombustivel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPrecoCombustivel = findViewById<EditText>(R.id.edt_precoCombustivel)
        val btnProx = findViewById<Button>(R.id.btn_proxConsumo)



        btnProx.setOnClickListener {

            val precoCombustivel = edtPrecoCombustivel.text

            if (precoCombustivel.isEmpty()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Informe o preço do combustível",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                precoCombustivel.toString().toFloat()
                val intent = Intent(this, ConsumoCarro::class.java)
                    .apply {
                        putExtra("preco_combustivel", precoCombustivel)
                    }
                startActivity(intent)
            }
        }
    }
}