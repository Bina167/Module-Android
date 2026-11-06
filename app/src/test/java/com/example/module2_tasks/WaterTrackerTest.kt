package com.example.module2_tasks

import junit.framework.Assert.assertEquals
import org.junit.Test


class WaterTrackerTest {
    @Test
    fun testAddWater() {
        var waterCount = 0
        waterCount += 250
        assertEquals(250, waterCount)
    }

    @Test
    fun testFinishDayWithEnoughWater() {
        var waterCount = 1500
        var daysInARow = 0

        if (waterCount >= 1500) {
            daysInARow += 1
        } else {
            daysInARow = 0
        }
        waterCount = 0

        assertEquals(1, daysInARow)
        assertEquals(0, waterCount)
    }

    @Test
    fun testFinishDayWithNotEnoughWater() {
        var waterCount = 500
        var daysInARow = 5

        if (waterCount >= 1500) {
            daysInARow += 1
        } else {
            daysInARow = 0
        }
        waterCount = 0

        assertEquals(0, daysInARow)
        assertEquals(0, waterCount)
    }
}
