package com.nuklas.cryptoprice

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTests {
    @Test
    fun smokeTest() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun mainActivityShouldNotBeNull(){
        val mainActivity = MainActivity()
        assertNotNull(mainActivity)
    }
}
