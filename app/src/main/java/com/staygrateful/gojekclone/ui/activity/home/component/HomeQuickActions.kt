package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.SvgLoader
import com.staygrateful.common_library.extension.outerShadow
import com.staygrateful.gojekclone.data.local.homeQuickActionList
import com.staygrateful.gojekclone.ui.theme.*


@Composable
fun HomeQuickActions() {
    Column {
        Text(
            modifier = Modifier.padding(
                bottom = 15.dp,
                start = PaddingContent,
                end = PaddingContent
            ),
            text = "Quick actions",
            fontSize = 17.5.sp,
            fontWeight = FontWeight.Bold,
            color = ColorTextDark
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(PaddingContent),
            contentPadding = PaddingValues(horizontal = PaddingContent)
        ) {
            items(homeQuickActionList) { data ->
                Row(
                    modifier = Modifier
                        .height(63.dp)
                        .outerShadow(
                            color = ColorShadow,
                            contentColor = Color.White,
                            elevation = 1.dp,
                            cornersRadius = CornerSmall
                        )
                        .clickable {

                        }
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = data.title,
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    SvgLoader(
                        modifier = Modifier
                            .padding(start = 50.dp)
                            .size(18.dp),
                        data = data.icon,
                        colorFilter = ColorFilter.tint(color = ColorRed)
                    )
                }
            }
        }
    }
}