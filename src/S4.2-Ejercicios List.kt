package com.egomezdj.sintaxis.sintaxis

fun main(){
    val frutas = listOf("manzana", "naranja", "plátano", "kiwi", "melón", "naranja")

    val ocurrencias = contarOcurrencias(frutas)
    println(ocurrencias)

    val sinRepetidos = listaSinRepetidos(frutas)
    println(sinRepetidos)

    val sinRepetidosOrdenada = listaSinRepetidosOrdenada(frutas)
    println(sinRepetidosOrdenada)
}

fun contarOcurrencias(lista: List<String>): Map<String, Int> {
    return lista.groupingBy { it }.eachCount()
}

fun listaSinRepetidos(lista: List<String>): List<String> {
    return lista.distinct()
}

fun listaSinRepetidosOrdenada(lista: List<String>): List<String> {
    return lista.distinct().sorted()
}

