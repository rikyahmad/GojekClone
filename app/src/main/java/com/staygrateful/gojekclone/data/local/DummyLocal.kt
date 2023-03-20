package com.staygrateful.gojekclone.data.local

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.data.MultiTextData
import com.staygrateful.common_library.data.TextData
import com.staygrateful.gojekclone.R
import com.staygrateful.gojekclone.data.model.*
import com.staygrateful.gojekclone.ui.activity.data.BottomNavItem
import com.staygrateful.gojekclone.ui.theme.*

val homeBottomMenuList = listOf(
    BottomNavItem.Home,
    BottomNavItem.Promo,
    BottomNavItem.Order,
    BottomNavItem.Chat,
)

val homeCarouselList = listOf(
    HomeCarouselData(
        MultiTextData.from(
            TextData(
                "250.120",
                fontWeight = FontWeight.Bold,
                size = 13.5.sp,
                color = ColorTextDark
            ),
            TextData(
                "\nTap for details",
                fontWeight = FontWeight.Normal,
                size = 11.sp,
                color = ColorText
            ),
            style = TextStyle(
                fontSize = 11.5.sp,
                lineHeight = 18.sp,
                color = ColorText
            )
        ), iconData = R.raw.image_gopaycoin, iconHeight = 26.dp
    ),
    HomeCarouselData(
        MultiTextData.from(
            TextData(
                "Rp750.450",
                fontWeight = FontWeight.Bold,
                size = 13.5.sp,
                color = ColorTextDark
            ),
            TextData(
                "\nLet's order now!",
                fontWeight = FontWeight.Medium,
                size = 11.sp,
                color = ColorGreenDark
            ),
            style = TextStyle(
                fontSize = 11.5.sp,
                lineHeight = 18.sp,
                color = ColorText
            )
        ), iconData = R.raw.image_gopaylater, iconHeight = 23.dp
    ),
    HomeCarouselData(
        MultiTextData.single(
            "Payments made easy with GoPay!", style = TextStyle(
                fontSize = 11.5.sp,
                lineHeight = 15.sp,
                color = ColorText
            )
        ),
        MultiTextData.from(
            TextData("No balance yet"),
            TextData(
                "\nTap to top up",
                fontWeight = FontWeight.Medium,
                color = ColorGreenDark
            ),
            style = TextStyle(
                fontSize = 11.5.sp,
                lineHeight = 15.sp,
                color = ColorText
            )
        ), iconData = R.raw.image_gopay, iconHeight = 20.5.dp
    ),
)

val homeMenuList = listOf(
    HomeMenuData(title = "GoRide", svgRes = R.raw.icon_goride, color = ColorGreen, size = 26.dp),
    HomeMenuData(title = "GoCar", svgRes = R.raw.icon_gocar, color = ColorGreen, size = 31.dp),
    HomeMenuData(title = "GoFood", svgRes = R.raw.icon_gofood, color = ColorRed, size = 26.dp),
    HomeMenuData(title = "GoSend", svgRes = R.raw.icon_gosend, color = ColorGreen, size = 26.dp),
    HomeMenuData(title = "GoMart", svgRes = R.raw.icon_gomart, color = ColorRed, size = 26.dp),
    HomeMenuData(
        title = "GoPulsa",
        svgRes = R.raw.icon_gopulsa,
        color = ColorBlueDark,
        size = 26.dp
    ),
    HomeMenuData(
        title = "GoClub",
        svgRes = R.raw.icon_goclub,
        color = Color.Transparent,
        size = 29.dp
    ),
    HomeMenuData(
        title = "More",
        svgRes = R.raw.icon_more_grid,
        color = ColorGreyLight,
        size = 22.dp
    ),
)

val homeQuickActionList = listOf(
    HomeQuickActionData(id = 1, title = "Restos near me", icon = R.raw.icon_gofood),
    HomeQuickActionData(id = 2, title = "Best-seller in my area", icon = R.raw.icon_gofood),
)