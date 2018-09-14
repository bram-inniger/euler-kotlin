package be.inniger.euler

import be.inniger.euler.problems01to10.*
import org.junit.Test
import kotlin.test.assertEquals

class Problems01to10Test {

    @Test
    fun verifySolution01() {
        assertEquals(233168, solve01())
    }

    @Test
    fun verifySolution02() {
        assertEquals(4613732, solve02())
    }

    @Test
    fun verifySolution03() {
        assertEquals(6857, solve03())
    }

    @Test
    fun verifySolution04() {
        assertEquals(906609, solve04())
    }

    @Test
    fun verifySolution05() {
        assertEquals(232792560, solve05())
    }

    @Test
    fun verifySolution06() {
        assertEquals(25164150, solve06())
    }

    @Test
    fun verifySolution07() {
        assertEquals(104743, solve07())
    }

    @Test
    fun verifySolution08() {
        assertEquals(23514624000L, solve08())
    }

    @Test
    fun verifySolution09() {
        assertEquals(31875000, solve09())
    }

    @Test
    fun verifySolution10() {
        assertEquals(142913828922L, solve10())
    }
}
