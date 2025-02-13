package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var numeroUno:Double=0.0
    private  var numeroDos:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        var resultado = binding.resultado.text
        binding.boton0.setOnClickListener(this)
        binding.boton1.setOnClickListener(this)
        binding.boton2.setOnClickListener(this)
        binding.boton3.setOnClickListener(this)
        binding.boton4.setOnClickListener(this)
        binding.boton5.setOnClickListener(this)
        binding.boton6.setOnClickListener(this)
        binding.boton7.setOnClickListener(this)
        binding.boton8.setOnClickListener(this)
        binding.boton9.setOnClickListener(this)
        binding.botonAC.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonPunto.setOnClickListener(this)
        binding.botonResto.setOnClickListener(this)
        binding.botonBorrar.setOnClickListener(this)
        binding.botonSumar.setOnClickListener(this)
        binding.botonRestar.setOnClickListener(this)
        binding.botonMultiplicar.setOnClickListener(this)
        binding.botonDividir.setOnClickListener(this)
        binding.botonPosNeg.setOnClickListener(this)


    }

    fun sumar(numero1: String, numero2: String): String {

        return (numero1.toFloat() + numero2.toFloat()).toString()
    }

    fun restar(numero1: String, numero2: String): String {

        return (numero1.toFloat() - numero2.toFloat()).toString()
    }

    fun multiplicar(numero1: String, numero2: String): String {

        return (numero1.toFloat() * numero2.toFloat()).toString()
    }

    fun dividir(numero1: String, numero2: String): String {

        return (numero1.toFloat() / numero2.toFloat()).toString()
    }

    fun porcentaje(numero1: String, numero2: String): String {
        var resultado = ((numero1.toFloat() / numero2.toFloat()) * 100);
        return resultado.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.boton0.id -> {
                binding.resultado?.text = binding.resultado.text.toString() + "0"
            }

            binding.boton1.id -> {
                binding.resultado?.text = binding.resultado.text.toString() + "1"
            }

            binding.boton2.id -> {
                binding.resultado?.text = binding.resultado.text.toString() + "2"
            }

            binding.boton3.id -> {
                binding.resultado?.text = binding.resultado.text.toString() + "3"
            }

            binding.boton4.id -> {
                binding.resultado?.text = binding.resultado.text.toString() + "4"
            }

            binding.boton5.id -> {
                binding.resultado?.text = binding.resultado?.text.toString() + "5"
            }

            binding.boton6.id -> {
                binding.resultado?.text = binding.resultado?.text.toString() + "6"
            }

            binding.boton7.id -> {
                binding.resultado?.text = binding.resultado?.text.toString() + "7"
            }

            binding.boton8.id -> {
                binding.resultado?.text = binding.resultado?.text.toString() + "8"
            }

            binding.boton9.id -> {
                binding.resultado?.text = binding.resultado?.text.toString() + "9"
            }

            binding.botonAC.id -> {
                binding.resultado?.text = ""
            }

            binding.botonPosNeg.id -> {
                var numero = binding.resultado?.text.toString().toInt()
                if (numero > 0) {
                    binding.resultado?.text = (numero * -1).toString()
                } else if (numero < 0) {
                    binding.resultado?.text = (numero * -1).toString()
                }
            }

            binding.botonBorrar.id -> {
                val resultado = binding.resultado?.text.toString()


                if (resultado.isNotEmpty()) {

                    val numero = binding.resultado?.text?.substring(0, resultado.length - 1)
                    if (numero != null) {
                        binding.resultado?.text = if (numero.isNotEmpty()) {
                            numero
                        } else {
                            ""
                        }
                    }
                } else {
                    binding.resultado.text = ""
                }
            }

            binding.botonPunto.id -> {
                if (binding.resultado?.text.contains(".")) {
                    binding.resultado?.text = binding.resultado?.text
                } else {
                    var numeros: String = binding.resultado?.text.toString() + "."
                    binding.resultado?.text = numeros
                }
            }

            binding.botonDividir.id -> {
                if (binding.resultado?.text.contains("/")) {
                    binding.resultado?.text = binding.resultado?.text
                } else {
                    binding.resultado?.text = binding.resultado.text.toString() + "/"
                }
            }

            binding.botonResto.id -> {
                if (binding.resultado?.text.contains("%")) {
                    binding.resultado?.text = binding.resultado?.text
                } else {
                    binding.resultado?.text = binding.resultado.text.toString() + "%"
                }
            }

            binding.botonMultiplicar.id -> {
                if (binding.resultado?.text.contains("X")) {
                    binding.resultado?.text = binding.resultado?.text
                } else {
                    binding.resultado?.text = binding.resultado.?text.toString() + "X"
                }
            }

            binding.botonRestar.id -> {

                if (binding.resultado.text.contains("-")) {
                    binding.resultado.text = binding.resultado.text
                } else {
                    binding.resultado.text = binding.resultado.text.toString() + "-"
                }
            }

            binding.botonSumar.id -> {
                if (binding.resultado.text.contains("+")) {
                    binding.resultado.text = binding.resultado.text
                } else {
                    binding.resultado.text = binding.resultado.text.toString() + "+"
                }
            }

            binding.botonIgual.id -> {
                var resultadoAnterior1 = binding.resultado.text

                if (binding.resultado?.text?.contains("/") ?: ||((binding.resultado.text.contains("/")&&binding.resultado.text.contains("-")))) {
                    var division: List<String> = binding.resultado.text.split("/")
                    binding.resultado?.text ?:  = dividir(division[0], division[1])

                } else if (binding.resultado?.text.contains("X")||((binding.resultado.text.contains("X")&&binding.resultado.text.contains("-")))) {
                    var division: List<String> = binding.resultado.text.split("X")
                    binding.resultado?.text = multiplicar(division[0], division[1])
                } else if (binding.resultado?.text.contains("-")) {
                    var division: List<String> = binding.resultado.text.split("-")
                    binding.resultado?.text = restar(division[0], division[1])
                } else if (binding.resultado?.text.contains("+")||((binding.resultado.text.contains("+")&&binding.resultado.text.contains("-")))) {
                    var division: List<String> = binding.resultado?.text.split("+")
                    binding.resultado?.text = sumar(division[0], division[1])
                } else if (binding.resultado?.text.contains("%")||((binding.resultado.text.contains("+")&&binding.resultado.text.contains("-")))) {
                    var division: List<String> = binding.resultado?.text.split("%")
                    binding.resultado?.text = porcentaje(division[0], division[1])
                }
                binding.resultadoAnterior?.text =
                    resultadoAnterior1.toString() + "\n" + binding.resultado.text.toString()
            }


        }
    }
}

