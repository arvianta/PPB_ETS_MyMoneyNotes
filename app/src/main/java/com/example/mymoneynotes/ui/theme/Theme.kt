package com.example.mymoneynotes.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryGreen,
    secondary = IncomeGreen,
    tertiary = PrimaryRed,
    background = BackgroundDark,
    surface = CardDark,
    onPrimary = Color.Black,
    onSecondary = TextLight,
    onBackground = TextLight,
    onSurface = TextLight,
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    secondary = IncomeGreen,
    tertiary = ExpenseRed,
    background = BackgroundLight,
    surface = CardLight,
    onPrimary = Color.White,
    onSecondary = TextDark,
    onBackground = TextDark,
    onSurface = TextDark,
)

@Composable
fun MyMoneyNotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}