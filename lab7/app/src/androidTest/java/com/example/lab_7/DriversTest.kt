package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_drivers_add_driver_add_clear_and_return_home() {
        // navigate to drive screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // verify drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // add a drivers name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Liz")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver appears
        composeTestRule
            .onNodeWithText("Liz")
            .assertExists()

        // clear drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify that the driver is actually gone
        composeTestRule
            .onNodeWithText("Liz")
            .assertDoesNotExist()

        // verify return to home screen
        composeTestRule
            .onNodeWithTag( "driversBackButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}