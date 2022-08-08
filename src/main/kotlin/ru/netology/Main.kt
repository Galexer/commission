package ru.netology

import kotlin.math.ceil

const val MM_CARD_LIMIT = 75000_00
const val MM_CARD_CHANGE_COMM = 0.006
const val MM_CARD_STAT_COMM = 20_00
const val VISA_MIN_COMM = 35_00
const val VISA_COMM = 0.0075

fun main() {
    val sum = 1000_00
    val previousPaym = 0
    val typeCard = "VK pay"
    println(commission(sum, previousPaym, typeCard))
}

fun commission(sum: Int, previousPaym: Int, typeCard: String): Int {
    return when (typeCard) {
        "Mastercard", "Maestro" ->  if(previousPaym <= MM_CARD_LIMIT) 0 else ceil(sum * MM_CARD_CHANGE_COMM).toInt() + MM_CARD_STAT_COMM
        "VK pay" ->  0
        "Visa", "Мир" -> if(sum * VISA_COMM < VISA_MIN_COMM) VISA_MIN_COMM else ceil(sum * VISA_COMM).toInt()
        else -> -1
    }
}