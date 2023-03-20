package com.staygrateful.gojekclone.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = ColorPrimaryDark,
    secondary = ColorSecondaryDark,
    tertiary = ColorTertiaryDark
)

private val LightColorScheme = lightColorScheme(
    primary = ColorPrimary,
    secondary = ColorSecondary,
    tertiary = ColorTertiary

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun GojekCopyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    statusBarDarkColor: Color = Color.DarkGray,
    navigationBarDarkColor: Color = Color.DarkGray,
    statusBarColor: Color = ColorPrimary,
    navigationBarColor: Color = Color.White,
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

    /*val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }*/

    SystemBarColor(
        darkTheme = darkTheme,
        statusBarDarkColor = statusBarDarkColor,
        navigationBarDarkColor = navigationBarDarkColor,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

@Composable
fun SystemBarColor(
    darkTheme: Boolean = isSystemInDarkTheme(),
    statusBarDarkColor: Color? = null,
    navigationBarDarkColor: Color? = null,
    statusBarColor: Color? = null,
    navigationBarColor: Color? = null,
    content: (@Composable () -> Unit) ? = null
) {
    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        statusBarDarkColor?.let {
            systemUiController.setStatusBarColor(
                color = it
            )
        }
        navigationBarDarkColor?.let {
            systemUiController.setNavigationBarColor(
                color = it
            )
        }
    } else {
        statusBarColor?.let {
            systemUiController.setStatusBarColor(
                color = it
            )
        }
        navigationBarColor?.let {
            systemUiController.setNavigationBarColor(
                color = it
            )
        }
    }
    content?.let { it() }
}