package ru.netology

import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun commission_MMLess() {
        val sum = 1000_00
        val previousPaym = 0
        val typeCardMast = "Mastercard"
        val typeCardMae = "Maestro"

        val resultMae = commission(sum, previousPaym, typeCardMae)
        val resultMast = commission(sum, previousPaym, typeCardMast)
        assertEquals(0, resultMae)
        assertEquals(0, resultMast)
    }

    @Test
    fun commission_MMOutLim() {
        val sum = 80000_00
        val previousPaym = 80000_00
        val typeCardMast = "Mastercard"
        val typeCardMae = "Maestro"

        val resultMae = commission(sum, previousPaym, typeCardMae)
        val resultMast = commission(sum, previousPaym, typeCardMast)
        assertEquals(500_00, resultMae)
        assertEquals(500_00, resultMast)
    }

    @Test
    fun commission_VK() {
        val sum = 80000_00
        val previousPaym = 0
        val typeCard = "VK pay"

        val result = commission(sum, previousPaym, typeCard)
        assertEquals(0, result)
    }

    @Test
    fun commission_visa() {
        val sum = 4500_00
        val previousPaym = 0
        val typeCardVisa = "Visa"
        val typeCardMir = "Мир"

        val resultVisa = commission(sum, previousPaym, typeCardVisa)
        val resultMir = commission(sum, previousPaym, typeCardMir)
        assertEquals(35_00, resultVisa)
        assertEquals(35_00, resultMir)
    }

    @Test
    fun commission_visaOutLim() {
        val sum = 5000_00
        val previousPaym = 0
        val typeCardVisa = "Visa"
        val typeCardMir = "Мир"

        val resultVisa = commission(sum, previousPaym, typeCardVisa)
        val resultMir = commission(sum, previousPaym, typeCardMir)
        assertEquals(37_50, resultVisa)
        assertEquals(37_50, resultMir)
    }

    @Test
    fun commission_notAvalCard() {
        val sum = 5000_00
        val previousPaym = 0
        val typeCard = "UnionPay"

        val result = commission(sum, previousPaym, typeCard)
        assertEquals(-1, result)
    }
}