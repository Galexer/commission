package ru.netology

import kotlin.math.ceil

fun main() {
    val sum = 1000_00
    val previousPaym = 0
    val typeCard = "VK pay"
    println( commission(sum, previousPaym, typeCard))
}

fun commission(sum: Int, previousPaym: Int, typeCard: String): Int {
    val mmCardLimit = 75000_00
    val mmCardChengeCommis = 0.006
    val mmCardStaticCommis = 20_00
    val visaMirMinCommis = 35_00
    val visaMirCommis = 0.0075
    when (typeCard) {
        "Mastercard", "Maestro" -> return if(previousPaym <= mmCardLimit) 0 else ceil((sum * mmCardChengeCommis) - mmCardStaticCommis).toInt()
        "VK pay" -> return 0
        "Visa", "Мир" -> return if(sum * visaMirCommis < visaMirMinCommis) visaMirMinCommis else ceil(sum * visaMirCommis).toInt()
    }
    return -1
}