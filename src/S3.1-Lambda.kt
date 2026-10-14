fun main() {
    val numeros = listOf(1, 2, 3, 4, 5, 6)
    val resultado = numeros.filter { it % 2 == 0 }
    println(resultado) // Debera imprimir: [2, 4, 6]
}

