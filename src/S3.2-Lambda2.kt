fun main() {
    val nombres = listOf("Juan", "Ana", "Roberto", "Lu")
    val resultado = ordenarPorLongitud(nombres) { it -> it.length }
    println(resultado) 
}

fun ordenarPorLongitud(lista: List<String>, criterio: (String) -> Int): List<String> {
    return lista.sortedBy(criterio)
}

