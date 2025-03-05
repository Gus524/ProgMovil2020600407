import java.time.LocalDateTime
import java.time.Period
import kotlin.system.exitProcess
import java.time.Duration

fun main() {
    while (true) {
        println("Seleccione una de las siguientes opciones a realizar: ")
        println("1. Realizar la suma de 3 numeros")
        println("2. Ingresar su nombre completo")
        println("3. Ingresar su fecha de nacimiento y mostrar el tiempo trasncurrido hasta la fecha")
        println("4. Terminar el programa")
        var input = readNumber()
        while(input < 1 || input > 4) {
            println("Debe ingresar un valor entre 1 y 4")
            input = readNumber()
        }
        when (input) {
            1 -> funcionSuma()
            2 -> funcionName()
            3 -> funcionDate()
            4 -> endProgram()
        }
    }
}

fun valorValido() {
    println("Debe ingresar un valor entre 1 y 4: ")
}

/*
    Funciones para realizar la suma
 */
fun readNumber(): Int {
    var num: Int? = readLine()!!.toIntOrNull()
    while (num == null) {
        println("Ingrese un numero que sea valido: ")
        num = readLine()!!.toInt()
    }
    return num
}

fun clearConsole(){
    print("\u001b[H\u001b[2J")
}

fun funcionSuma() {
    clearConsole()
    println("Ingrese 3 numeros para sumar: ")
    println("Primer numero: ")
    val n1 = readNumber()
    println("Segundo numero: ")
    val n2 = readNumber()
    println("Tercer numero: ")
    val n3 = readNumber()
    println("La suma es: ${suma(n1, n2, n3)}")
}

fun suma(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun funcionName() {
    clearConsole()
    println("Ingrese su nombre completo: ")
    val name = readLine()!!.toString()
    println("Su nombre es: $name")
}

fun funcionDate() {
    clearConsole()
    println("Ingrese su fecha de nacimiento completa, todos en formato de numeros")
    println("Ingrese su año de nacimiento: ")
    val year = readNumber()
    println("Ingrese su mes de nacimiento: ")
    val month = readNumber()
    println("Ingrese su dia de nacimiento: ")
    val day = readNumber()
    getDateResult(year, month, day)
}

fun getDateResult(year: Int, month: Int, day: Int) {
    val birthDate = LocalDateTime.of(year, month, day, 0, 0, 0) // Pasamos la fecha ingresada a LocalDateTime
    val today = LocalDateTime.now()
    val diferencia = Period.between(birthDate.toLocalDate(), today.toLocalDate()) // Obtenemos la diferencia en anios
    val duration = Duration.between(birthDate, today) // Obtenemos la diferencia en horas, minutos y segundos

    val years = diferencia.years
    val months = diferencia.months + (years * 12)
    val days = diferencia.days
    val weeks = day / 7
    val hours = duration.toHoursPart()
    val minutes = duration.toMinutesPart()
    val seconds = duration.toSecondsPart()

    println("Fecha ingresada: $year/$month/$day")
    println("Fecha actual: ${today.year}/${today.monthValue}/${today.dayOfMonth}")
    println("\n\nMeses transcurridos: $months\nSemanas trasncurridas: $weeks\nDias trasncurridos: $days\nHoras transcurridas: $hours\nMinutos transcurridos: $minutes\nSegundos transcurridos: $seconds")
}

fun endProgram() {
    exitProcess(0)
}