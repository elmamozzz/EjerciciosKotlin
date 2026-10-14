fun main() {
    // Crear un Map para almacenar los productos y sus precios
    // Usa una expresi�n lambda
    val productos = mutableMapOf<String, Float>("Manzana" to 0.50f, "Pan" to 1.20f, "Leche" to 0.99f, "Huevos" to 2.50f)

    // Lambda para formatear el precio a dos decimales
    val formatearPrecio: (Float) -> String = { precio -> "$"+"%.2f".format(precio) }

    // Mostrar todos los productos y precios formateados usando una expresi�n lambda
    println("Lista de productos y precios:")
    productos.forEach { (producto, precio) ->
        println("$producto: ${formatearPrecio(precio)}")
    }

    // Solicitar al usuario el nombre de un producto
    println("\nIngresa el nombre de un producto para conocer su precio:")
    val nombreProducto = readln()

    // Verificar si el producto existe en el Map y mostrar el precio usando la lambda
    if (nombreProducto != null && productos.containsKey(nombreProducto)) {
        val precioFormateado = formatearPrecio(productos[nombreProducto] ?: 0f)
        println("El precio de $nombreProducto es: $precioFormateado")
    } else {
        println("El producto '$nombreProducto' no fue encontrado.")
    }
}