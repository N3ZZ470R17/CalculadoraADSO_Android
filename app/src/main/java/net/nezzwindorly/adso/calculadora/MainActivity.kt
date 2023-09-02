package net.nezzwindorly.adso.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.nezzwindorly.adso.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {

    private lateinit var numero1EditText: EditText
    private lateinit var numero2EditText: EditText
    private lateinit var sumaButton: Button
    private lateinit var restaButton: Button
    private lateinit var multiplicacionButton: Button
    private lateinit var divisionButton: Button
    private lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        setContentView(R.layout.activity_main)

        numero1EditText = findViewById(R.id.numero1EditText)
        numero2EditText = findViewById(R.id.numero2EditText)
        sumaButton = findViewById(R.id.sumaButton)
        restaButton = findViewById(R.id.restaButton)
        multiplicacionButton = findViewById(R.id.multiplicacionButton)
        divisionButton = findViewById(R.id.divisionButton)
        resultadoTextView = findViewById(R.id.resultadoTextView)

        sumaButton.setOnClickListener {
            realizarOperacion("suma")
        }

        restaButton.setOnClickListener {
            realizarOperacion("resta")
        }

        multiplicacionButton.setOnClickListener {
            realizarOperacion("multiplicacion")
        }

        divisionButton.setOnClickListener {
            realizarOperacion("division")
        }
    }

    private fun realizarOperacion(operacion: String) {
        val numero1Str = numero1EditText.text.toString()
        val numero2Str = numero2EditText.text.toString()

        if (!numero1Str.isEmpty() && !numero2Str.isEmpty()) {
            val numero1 = numero1Str.toDouble()
            val numero2 = numero2Str.toDouble()
            var resultado = 0.0

            when (operacion) {
                "suma" -> resultado = numero1 + numero2
                "resta" -> resultado = numero1 - numero2
                "multiplicacion" -> resultado = numero1 * numero2
                "division" -> {
                    if (numero2 != 0.0) {
                        resultado = numero1 / numero2
                    } else {
                        resultadoTextView.text = "No se puede dividir por cero."
                        return
                    }
                }
            }

            resultadoTextView.text = "Resultado: $resultado"
        } else {
            resultadoTextView.text = "Por favor, ingrese números válidos."
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        Greeting("Android")
    }
}