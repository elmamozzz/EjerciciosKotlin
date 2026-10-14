fun main() {
    val numeros = listOf(1, 2, 3, 4, 5, 6)
    val resultado = filtrarPares(numeros) { it % 2 == 0 }
    println(resultado) // Deber�a imprimir: [2, 4, 6]
}

fun filtrarPares(lista: List<Int>, criterio: (Int) -> Boolean): List<Int> {
    return lista.filter(criterio)
}