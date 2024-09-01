// Define la interfaz FizzBuzz
interface FizzBuzz {
    fun printFizzBuzz(range: IntRange)
}

// Implementa la clase FizzBuzzImpl que sigue la interfaz FizzBuzz
class FizzBuzzImpl : FizzBuzz {
    override fun printFizzBuzz(range: IntRange) {
        // Validar el rango
        if (range.first <= 0 || range.last <= 0 || range.first > range.last) {
            throw IllegalArgumentException("El rango de números debe ser positivo y el inicio del rango debe ser menor o igual al final del rango.")
        }

        val result = StringBuilder()
        for (i in range) {
            when {
                i % 3 == 0 && i % 5 == 0 -> result.append("FizzBuzz ")
                i % 3 == 0 -> result.append("Fizz ")
                i % 5 == 0 -> result.append("Buzz ")
                else -> result.append("$i ")
            }
        }

        // Imprime la salida formateada en líneas de 10 elementos
        printFormattedOutput(result.toString())
    }

    private fun printFormattedOutput(output: String) {
        val lines = output.trim().split(" ").chunked(10)
        for (line in lines) {
            println(line.joinToString(" "))
        }
    }
}

// Función principal para ejecutar el programa
fun main() {
    val fizzBuzz: FizzBuzz = FizzBuzzImpl()
    try {
        fizzBuzz.printFizzBuzz(1..100)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
