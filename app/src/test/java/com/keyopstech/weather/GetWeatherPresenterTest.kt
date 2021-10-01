package com.keyopstech.weather

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.concurrent.Callable


class GetWeatherPresenterTest {
    lateinit var tester: GetWeatherPresenterTester
    @Before
    fun setup() {
        tester = GetWeatherPresenterTester()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> Schedulers.trampoline() }
    }

    @Test
    fun `given response is Londres when user touch Londres item then detail screen is shown`() {
        // Given
        tester.setCitySelected("Londres")

        // When
        tester.loadData()

        // Then
        assertEquals("Londres",tester.cityResponse)
    }

    @Test
    fun `given temperature is a number when user touch one city in list then detail screen is shown`() {
        // Given
        tester.setCitySelected("Abidjan")

        // When
        tester.loadData()

        // Then
        Assert.assertNotNull(tester.temperature.toFloat())
    }

    @Test
    fun `given response icon is not null and not empty when user touch one city in list then detail screen is shown`() {
        // Given
        tester.setCitySelected("Lyon")

        // When
        tester.loadData()

        // Then
        Assert.assertNotNull(tester.icon)
        Assert.assertTrue(tester.icon.isNotEmpty())
    }
}