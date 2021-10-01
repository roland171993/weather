package com.keyopstech.city

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CityListPresenterTest {
    lateinit var tester: CityListPresenterTester
    @Before
    fun setup() {
        tester = CityListPresenterTester()
    }

    @Test
    fun `List contain many items when user open app`() {

        // When
        tester.loadData()

        // Then
        Assert.assertFalse(tester.verifyEmptyOrNull())
    }

    @Test
    fun `List first item is Abidjan when user open app`() {

        // When
        tester.loadData()

        // Then
        Assert.assertNotNull(tester.getFirstItem())
        Assert.assertTrue(tester.getFirstItem()?.name.toString().contentEquals("Abidjan"))
    }

}