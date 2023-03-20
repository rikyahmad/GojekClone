package com.staygrateful.gojekclone.data.model

import androidx.compose.ui.unit.Dp
import com.staygrateful.common_library.data.MultiTextData

class HomeCarouselData(
    vararg val multiText: MultiTextData,
    val iconData: Any,
    val iconHeight: Dp? = null,
    val dest: String? = null, // url or activity package
)