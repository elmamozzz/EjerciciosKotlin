fun main() {
    // Creamos un conjunto mutable inicial con algunos números
    val conjunto = mutableSetOf(10, 20, 30, 40)

    // Mostramos todos los elementos iniciales del Set con un foreach o un joinToString
    println("\nLos números iniciales del set:")
    println(conjunto.joinToString(", "))

    // Añadimos un número nuevo (funciona correctamente)
    var añadido = conjunto.add(50)
    println("\n$añadido: intento añadir 50: añadido correctamente")

    // Intentamos añadir un número que ya existe en la lista (20)
    añadido = conjunto.add(20)
    println("$añadido: intento añadir 20: rechazado, el 20 ya está en el conjunto")

    // Mostramos todos los elementos del Set con un foreach o un joinToString
    println("\nLos números guardados finalmente son:")
    println(conjunto.joinToString(", "))
}