package app

import lib.Expr
import lib.Const
import lib.Sum
import lib.NotANumber
import lib.Multiply

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Expected usage ./myapp <number> <number>")
        exitProcess(1)
    }
    val (n, m) = args.map { it.toDouble() }
    val sum = eval(Sum(Const(n), Const(m)))
    println("$n + $m = $sum")
    val product = eval(Multiply(Const(n), Const(m)))
    println("$n * $m = $product")
}

fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    is Multiply -> eval(expr.e1) * eval(expr.e2)
    NotANumber -> Double.NaN
}
