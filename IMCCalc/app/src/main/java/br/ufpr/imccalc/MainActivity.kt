package br.ufpr.imccalc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextAltura = findViewById<EditText>(R.id.etAltura)
        val editTextPeso = findViewById<EditText>(R.id.etPeso)

        val buttonCalcular = findViewById<Button>(R.id.btnCalcular)
        val buttonLimpar = findViewById<Button>(R.id.btnLimpar)

        buttonCalcular.setOnClickListener {
            val altura = editTextAltura.text.toString()
            val peso = editTextPeso.text.toString()

            if (altura.isEmpty() || peso.isEmpty()){
                Toast.makeText(this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show()
            } else {
                val alturaflt = altura.toFloat()
                val pesoflt = peso.toFloat()

                if (pesoflt != null && alturaflt != null && pesoflt > 0 && alturaflt > 0){
                    val imc = pesoflt / (alturaflt * alturaflt)

                    // Intent para passar os valores para a outra activity
                    val intent = Intent(this, ResultadoActivity::class.java).apply{
                        putExtra("VALOR_IMC", imc)
                    }
                    // Inicia a activity
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        buttonLimpar.setOnClickListener {
            editTextAltura.text.clear()
            editTextPeso.text.clear()
        }

    }
}
