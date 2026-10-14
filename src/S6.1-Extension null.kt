// 1. Escribe el código de la función de extensión nInt
// Nota: Se debe extender Int? (con interrogación) para permitir que reciba nulos
fun Int?.ntoString(): String {
    return this?.toString() ?: "-"
}

fun main() {

    // 2. Define una lista de números enteros 1, 2, null, 3, 4, null, 5
    val numeros = listOf(1, 2, null, 3, 4, null, 5)

    // 3. Recorre la lista con un for e imprime sus valores usando la función
    for (numero in numeros) {
        println(numero.ntoString())
    }
	// 4. reduce: Junta todos los Strings en uno solo
    val resultadoFinal = numeros
        .map { it.ntoString() }
        .reduce { acumulador, siguienteElemento -> 
            "$acumulador, $siguienteElemento" 
        }

    println(resultadoFinal) 
    // Imprimirá: 1, 2, -, 3, 4, -, 5
}

