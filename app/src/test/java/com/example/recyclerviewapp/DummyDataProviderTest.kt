package com.example.recyclerviewapp

import com.example.recyclerviewapp.Item
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DummyDataProviderTest {
    @Test
    fun `generateDummyItems returns requested count and unique ids`() {
        val count = 150
        val items = generateDummyItems(count)
        assertEquals(count, items.size)
        // IDs should be unique and sequential starting at 1
        val ids = items.map { it.id }
        assertTrue(ids.distinct().size == count)
        assertEquals(1L, ids.first())
        assertEquals(count.toLong(), ids.last())
    }
}
