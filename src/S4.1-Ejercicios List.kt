package com.egomezdj.sintaxis.sintaxis

fun main() {
    val numeros = listOf(1, 2, 5, 7, 8, 11)

    val suma = sumaElementos(numeros)
    println("Suma de los elementos: $suma")

    val pares = obtenerPares(numeros)
    println("Números pares: $pares")

    val maximo = obtenerMaximo(numeros)
    println("Máximo de la lista: $maximo")

    val duplicados = duplicarElementos(numeros)
    println("Elementos duplicados: $duplicados")
}

fun sumaElementos(lista: List<Int>): Int {
    return lista.sum()
}

fun obtenerPares(lista: List<Int>): List<Int> {
    return lista.filter { it % 2 == 0 }
}

fun obtenerMaximo(lista: List<Int>): Int? {
    return lista.maxOrNull()
}

fun duplicarElementos(lista: List<Int>): List<Int> {
    return lista.map { it * 2 }
}
