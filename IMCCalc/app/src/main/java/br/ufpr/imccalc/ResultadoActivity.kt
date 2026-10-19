package br.ufpr.imccalc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.ufpr.imccalc.ui.theme.IMCCalcTheme
import kotlin.ranges.contains

class ResultadoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val imc = intent.getFloatExtra("VALOR_IMC", 0f)

        val textViewIMC = findViewById<TextView>(R.id.tvValorIMC)
        val textViewCategoria = findViewById<TextView>(R.id.tvCategoriaIMC)
        val buttonVoltar = findViewById<Button>(R.id.btnVoltar)

        val categoria = when{
            imc < 18.5 -> "Baixo Peso"
            imc in 18.5 .. 24.9 -> "Peso Normal"
            imc in 25.0 .. 29.9 -> "Sobrepeso"
            else -> "Obesidade"
        }
        textViewIMC.text = String.format("IMC: %.2f", imc)
        textViewCategoria.text = String.format("Categoria: %s", categoria)

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}