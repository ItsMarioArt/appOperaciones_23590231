package com.example.appoperaciones

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var v1: EditText
    private lateinit var v2: EditText
    private lateinit var v3: EditText
    private lateinit var resultado: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var btnOperar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnTrapecio: ImageButton
    private lateinit var btnRectangulo: ImageButton
    private lateinit var btnCirculo: ImageButton
    private lateinit var btnTriangulo: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        v1 = findViewById(R.id.v1)
        v2 = findViewById(R.id.v2)
        v3 = findViewById(R.id.v3)
        resultado = findViewById(R.id.resultado_op)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        btnOperar = findViewById(R.id.btnOperar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnTrapecio = findViewById(R.id.btnTrapecio)
        btnRectangulo = findViewById(R.id.btnRectangulo)
        btnCirculo = findViewById(R.id.btnCirculo)
        btnTriangulo = findViewById(R.id.btnTriangulo)

        ocultarCampos()

        btnTrapecio.setOnClickListener {
            limpiar()
            mostrarCampos()
            textView4.text = "Base mayor:"
            textView5.text = "Base menor:"
            textView6.text = "Altura:"
        }

        btnRectangulo.setOnClickListener {
            limpiar()
            mostrarCampos()
            textView4.text = "Base:"
            textView5.text = "Altura:"
            textView6.visibility = View.GONE
            v3.visibility = View.GONE
        }

        btnCirculo.setOnClickListener {
            limpiar()
            mostrarCampos()
            textView4.text = "Radio:"
            textView5.visibility = View.GONE
            v2.visibility = View.GONE
            textView6.visibility = View.GONE
            v3.visibility = View.GONE
        }

        btnTriangulo.setOnClickListener {
            limpiar()
            mostrarCampos()
            textView4.text = "Base:"
            textView5.text = "Altura:"
            textView6.visibility = View.GONE
            v3.visibility = View.GONE
        }

        btnOperar.setOnClickListener {
            operar()
        }

        btnLimpiar.setOnClickListener {
            limpiar()
        }
    }

    private fun ocultarCampos() {
        v1.visibility = View.GONE
        v2.visibility = View.GONE
        v3.visibility = View.GONE
        textView4.visibility = View.GONE
        textView5.visibility = View.GONE
        textView6.visibility = View.GONE
    }

    private fun mostrarCampos() {
        v1.visibility = View.VISIBLE
        v2.visibility = View.VISIBLE
        v3.visibility = View.VISIBLE
        textView4.visibility = View.VISIBLE
        textView5.visibility = View.VISIBLE
        textView6.visibility = View.VISIBLE
    }

    private fun operar() {
        val valor1 = v1.text.toString().toDoubleOrNull()
        val valor2 = v2.text.toString().toDoubleOrNull()
        val valor3 = v3.text.toString().toDoubleOrNull()
        var area = 0.0

        when {
            textView4.text == "Base mayor:" -> {
                if (valor1 != null && valor2 != null && valor3 != null) {
                    area = ((valor1 + valor2) / 2) * valor3
                }
            }
            textView4.text == "Base:" && textView6.visibility == View.GONE -> {
                if (valor1 != null && valor2 != null) {
                    area = valor1 * valor2
                }
            }
            textView4.text == "Radio:" -> {
                if (valor1 != null) {
                    area = Math.PI * Math.pow(valor1, 2.0)
                }
            }
            textView4.text == "Base:" && textView6.visibility == View.GONE -> {
                if (valor1 != null && valor2 != null) {
                    area = (valor1 * valor2) / 2
                }
            }
        }

        if (area != 0.0) {
            resultado.text = "${area}u"
        } else {
            resultado.text = "INGRESA LOS DATOS CORRESPONDIENTES :)"
        }
    }

    private fun limpiar() {
        ocultarCampos()
        v1.text.clear()
        v2.text.clear()
        v3.text.clear()
        resultado.text = "Resultado"
    }
}
