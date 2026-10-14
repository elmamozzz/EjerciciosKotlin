fun main() {
    val nombres = listOf("Juan", "Ana", "Roberto", "Lu")
    val resultado = ordenarPorLongitud(nombres) { it.length }
    println(resultado) // Debera imprimir: [Lu, Ana, Juan, Roberto]
}

private fun ordenarPorLongitud(lista: List<String>, criterio: (String) -> Int): List<String> {
    return lista.sortedBy(criterio)
}