package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.SvgLoader
import com.staygrateful.common_library.extension.outerShadow
import com.staygrateful.gojekclone.R
import com.staygrateful.gojekclone.ui.theme.*


@Composable
fun HomeGoClub() {
    Box(
        Modifier
            .padding(horizontal = PaddingContent)
            .fillMaxWidth()
            .height(65.dp)
            .outerShadow(
                elevation = 1.5.dp,
                color = ColorShadow,
                cornersRadius = CornerNormal,
            )
            .clickable {

            }
    ) {
        SvgLoader(
            modifier = Modifier
                .fillMaxHeight(),
            data = R.raw.bg_goclub,
            contentScale = ContentScale.FillHeight
        )
        Row(
            Modifier
                .align(Alignment.CenterStart)
                .padding(vertical = 10.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SvgLoader(modifier = Modifier.size(45.dp), data = R.raw.icon_goclub_star)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "54 XP more for a treasure",
                    color = ColorTextDark,
                    fontSize = 15.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Medium,
                    overflow = TextOverflow.Ellipsis
                )
                LinearProgressIndicator(
                    modifier = Modifier.padding(top = 10.dp),
                    progress = 0.7f
                )
            }
            SvgLoader(
                modifier = Modifier.size(16.dp),
                data = R.raw.arrow_right,
                colorFilter = ColorFilter.tint(color = ColorGreyDark)
            )
            //Icon(Icons.Filled.ArrowCircleRight, contentDescription = "To Go")
        }
    }
}