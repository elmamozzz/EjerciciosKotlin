fun main() {
    // Crear un Map para almacenar los productos y sus precios
    val productos = mutableMapOf<String, Float>("Manzana" to 0.50f, "Pan" to 1.20f, "Leche" to 0.99f, "Huevos" to 2.50f)

    // Mostrar todos los productos y precios formateados
    println("Lista de productos y precios:")
    for ((producto, precio) in productos) {
        println("$producto: \$${"%.2f".format(precio)}")
    }

    // Solicitar al usuario el nombre de un producto
    println("\nIngresa el nombre de un producto para conocer su precio:")
    val nombreProducto = readln()

    // Verificar si el producto existe en el Map y mostrar el precio
    if (nombreProducto != null && productos.containsKey(nombreProducto)) {
        val precioFormateado = "%.2f".format(productos[nombreProducto])
        println("El precio de $nombreProducto es: \$$precioFormateado")
    } else {
        println("El producto '$nombreProducto' no fue encontrado.")
    }
}
