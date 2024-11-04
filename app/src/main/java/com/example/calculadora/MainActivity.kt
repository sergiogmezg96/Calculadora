package com.example.calculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        var resultado = binding.resultado.text
        binding.boton0.setOnClickListener {

            binding.resultado.text = binding.resultado.text.toString() + "0"


        }

        binding.boton1.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "1"
        }
        binding.boton2.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "2"

        }
        binding.boton3.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "3"

        }
        binding.boton4.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "4"

        }
        binding.boton5.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "5"

        }
        binding.boton6.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "6"

        }
        binding.boton7.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "7"

        }
        binding.boton8.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "8"

        }
        binding.boton9.setOnClickListener {
            binding.resultado.text = binding.resultado.text.toString() + "9"


        }
        binding.botonAC.setOnClickListener {
            binding.resultado.text = ""
        }
        binding.botonPosNeg.setOnClickListener {
            var numero=binding.resultado.text.toString().toInt()
            if (numero>0){
                binding.resultado.text= (numero*-1).toString()
            }else if (numero<0){
                binding.resultado.text= (numero*-1).toString()
            }

        }
        binding.botonBorrar.setOnClickListener {
            val resultado = binding.resultado.text.toString()

            // Verificar si el resultado no está vacío
            if (resultado.isNotEmpty()) {
                // Eliminar el último carácter
                val numero = binding.resultado.text.substring(0, resultado.length - 1)
                binding.resultado.text = if (numero.isNotEmpty()) {
                    numero // Mostrar la cadena sin el último carácter
                } else {
                    "" // Si la cadena está vacía después de borrar, mostrar "0"
                }
            } else {
                binding.resultado.text = "" // Si ya estaba vacía, mostrar "0"
            }
        }
        binding.botonPunto.setOnClickListener {
            if (binding.resultado.text.contains(".")) {
                binding.resultado.text=binding.resultado.text
            }else {
                var numeros: String = binding.resultado.text.toString() + "."

                binding.resultado.text = numeros
            }


        }
        binding.botonDividir.setOnClickListener {
            if (binding.resultado.text.contains("/")) {
                binding.resultado.text=binding.resultado.text
            }else {
                binding.resultado.text = binding.resultado.text.toString() + "/"
            }


        }
        binding.botonResto.setOnClickListener {
            if (binding.resultado.text.contains("%")) {
                binding.resultado.text=binding.resultado.text
            }else {
                binding.resultado.text = binding.resultado.text.toString() + "%"
            }



        }
        binding.botonMultiplicar.setOnClickListener {
            if (binding.resultado.text.contains("X")) {
                binding.resultado.text = binding.resultado.text
            } else {

                binding.resultado.text = binding.resultado.text.toString() + "X"
            }

        }

        
        binding.botonRestar.setOnClickListener {
            if (binding.resultado.text.contains("-")) {
                binding.resultado.text=binding.resultado.text
            }else {
                binding.resultado.text = binding.resultado.text.toString() + "-"
            }


        }
        binding.botonSumar.setOnClickListener {
            if (binding.resultado.text.contains("+")) {
                binding.resultado.text=binding.resultado.text
            }else {
                binding.resultado.text = binding.resultado.text.toString() + "+"
            }

        }
        binding.botonIgual.setOnClickListener {
            var resultadoAnterior1=binding.resultado.text
            if (binding.resultado.text.contains("/")) {
                var division: List<String> = binding.resultado.text.split("/")
                binding.resultado.text = dividir(division[0], division[1])

            } else if (binding.resultado.text.contains("X")) {
                var division: List<String> = binding.resultado.text.split("X")
                binding.resultado.text = multiplicar(division[0], division[1])
            } else if (binding.resultado.text.contains("-")) {
                var division: List<String> = binding.resultado.text.split("-")
                binding.resultado.text = restar(division[0], division[1])
            } else if (binding.resultado.text.contains("+")) {
                var division: List<String> = binding.resultado.text.split("+")
                binding.resultado.text = sumar(division[0], division[1])
            } else if (binding.resultado.text.contains("%")) {
                var division: List<String> = binding.resultado.text.split("%")
                binding.resultado.text = porcentaje(division[0], division[1])
            }
            binding.resultadoAnterior.text=resultadoAnterior1.toString()+"\n"+ binding.resultado.text.toString()
        }


    }

    fun sumar(numero1: String, numero2: String): String {

        return (numero1.toFloat()+ numero2.toFloat()).toString()
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

    fun porcentaje(numero1: String,numero2:String): String {
        var resultado=((numero1.toFloat()/numero2.toFloat())*100);
        return resultado.toString()
    }
}