package com.example.ui.theme

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

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF8A75),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFD5C2),
    onPrimaryContainer = Color(0xFF5C2E1A),
    secondary = Color(0xFFDBA88A),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF5D0C8),
    onSecondaryContainer = Color(0xFF4A2A1A),
    tertiary = Color(0xFFFFAB91),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFD0C0),
    onTertiaryContainer = Color(0xFF4A1A0A),
    background = Color(0xFFFFF5F0),
    onBackground = Color(0xFF3A1A0A),
    surface = Color(0xFFFFF5F0),
    onSurface = Color(0xFF3A1A0A),
    surfaceVariant = Color(0xFFFFE8D5),
    onSurfaceVariant = Color(0xFF5C3A2A),
    outline = Color(0xFFDBA88A)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF8A75),
    onPrimary = Color(0xFF4A1A0A),
    primaryContainer = Color(0xFF5C2E1A),
    onPrimaryContainer = Color(0xFFFFD5C2),
    secondary = Color(0xFFDBA88A),
    onSecondary = Color(0xFF3A1A0A),
    secondaryContainer = Color(0xFF5C3A2A),
    onSecondaryContainer = Color(0xFFF5D0C8),
    tertiary = Color(0xFFFFAB91),
    onTertiary = Color(0xFF3A0A0A),
    tertiaryContainer = Color(0xFF5C2A1A),
    onTertiaryContainer = Color(0xFFFFD0C0),
    background = Color(0xFF1A0A0A),
    onBackground = Color(0xFFF5E0D0),
    surface = Color(0xFF1A0A0A),
    onSurface = Color(0xFFF5E0D0),
    surfaceVariant = Color(0xFF3A2A1A),
    onSurfaceVariant = Color(0xFFD5C0B0),
    outline = Color(0xFF8A6A5A)
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
