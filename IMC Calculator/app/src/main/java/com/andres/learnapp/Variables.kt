package com.andres.learnapp

import kotlin.math.ln

fun main() {

    usoVariables()
    mostrarEnPantalla()

    sumarNumbers(4, 9)
}

fun usoVariables() {

    // VARIABLES:
    // En algunos casos no es necesario especificar el tipo de dato, en estas se puede meter cualquier tipo de dato.
    val nombre = "rodrigo"
    // De esta forma con : se puede especificar el tipo de dato, pero en este caso la variable
    // solo podra almacenar datos de ese tipo.
    val entero:Int = 30
    val decimales:Float = 27.5f // Debe llevar el f al final si es flotante.
    val tetonasMejor:Boolean = true
    // VAL son las variables que se puede cambiar valor, y VAR son las constantes que no cambiaran.
    var pi = 3.1416
    // En este caso se especificara tipo de dato cuando se necesite que solo ese sea el dato posible.

}

fun mostrarEnPantalla() {

    // MOSTRAR COSAS EN PANTALLA:
    val num1 = 27
    val num2 = 28
    println("Multiplicar:")
    println(num1 * num2)

    // CONCATENAR STRING CON VARIABLE:
    val name = "Andrés"
    val frase = "Hola me llamo $name"
    println()
    println(frase)

}

fun sumarNumbers(firstNumber:Int, secondNumber:Int) {
    println("La suma de los numeros es: " + (firstNumber + secondNumber))
}