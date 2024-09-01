// Define la interfaz INumero con métodos para verificar si un número es primo, par o impar
interface INumero {
    fun numPrimo(): Boolean
    fun numPar(): Boolean
    fun numImpar(): Boolean
}

// Clase base "Numero" que implementa la interfaz INumero
open class Numero(val valorEntero: Int) : INumero {

    // Método para determinar si el número es primo
    override fun numPrimo(): Boolean {
        if (valorEntero < 2) return false
        for (divisorActual in 2..Math.sqrt(valorEntero.toDouble()).toInt()) {
            if (valorEntero % divisorActual == 0) return false
        }
        return true
    }

    // Método para determinar si el número es par
    override fun numPar(): Boolean {
        return valorEntero % 2 == 0
    }

    // Método para determinar si el número es impar
    override fun numImpar(): Boolean {
        return valorEntero % 2 != 0
    }
}

// Clases derivadas que heredan de Numero
class numeroPrimo(valorEntero: Int) : Numero(valorEntero)
class numeroPar(valorEntero: Int) : Numero(valorEntero)
class numeroImpar(valorEntero: Int) : Numero(valorEntero)

// Clase EvaluadorNumeros que evalúa una serie de números
class AnalizadorNumerico {

    fun analizarNumeros(limiteSuperior: Int) {
        if (limiteSuperior <= 0) {
            println("Número inválido. El límite debe ser un entero positivo.")
            return
        }

        var contadorPrimos = 0
        var contadorPares = 0
        var contadorImpares = 0

        // Itera desde 1 hasta el límite para evaluar cada número
        for (numeroEvaluado in 1..limiteSuperior) {
            val numeroInstancia = Numero(numeroEvaluado)

            if (numeroInstancia.numPrimo()) contadorPrimos++
            if (numeroInstancia.numPar()) contadorPares++
            if (numeroInstancia.numImpar()) contadorImpares++
        }

        // Imprime los resultados de la evaluación
        println("Cantidad de números primos: $contadorPrimos")
        println("Cantidad de números pares: $contadorPares")
        println("Cantidad de números impares: $contadorImpares")
    }
}

fun main() {
    val analizadorInstancia = AnalizadorNumerico()
    print("Por favor, ingrese un número: ") 
    val limiteSuperior = readLine()?.toIntOrNull() ?: 0
    analizadorInstancia.analizarNumeros(limiteSuperior)
}
