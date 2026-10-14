fun main() {
    val nombres = listOf("Juan", "Ana", "Roberto", "Lu")
    val resultado = nombres.sortedBy{ it.length }
    println(resultado) // Debera imprimir: [Lu, Ana, Juan, Roberto]
}

