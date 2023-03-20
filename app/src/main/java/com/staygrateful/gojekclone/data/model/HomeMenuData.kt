package com.staygrateful.gojekclone.data.model

import androidx.annotation.RawRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

class HomeMenuData(
    val title: String,
    val color: Color = Color.Transparent,
    val size: Dp? = null,
    @RawRes val svgRes: Int,
)