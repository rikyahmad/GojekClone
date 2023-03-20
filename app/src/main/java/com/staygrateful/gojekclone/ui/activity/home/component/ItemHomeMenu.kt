package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.annotation.RawRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.SvgLoader
import com.staygrateful.common_library.extension.circle
import com.staygrateful.common_library.extension.clip
import com.staygrateful.common_library.extension.rounded
import com.staygrateful.gojekclone.R
import com.staygrateful.gojekclone.ui.theme.ColorText


@Composable
fun ItemHomeMenu(
    modifier: Modifier = Modifier, title: String, @RawRes svgRes: Int,
    iconSize: Dp? = null,
    backgroundColor: Color = Color.Transparent,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(bottom = 7.dp, start = 1.dp, end = 1.dp)
            .fillMaxWidth()
            .padding(5.dp),
    ) {
        Column(
            modifier = modifier
                .align(Alignment.Center)
                .padding(5.dp)
                .fillMaxWidth()
                .clip(10.dp)
                .rounded(color = Color.Transparent, corner = 10.dp)
                .clickable {
                    onClick()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .circle(color = backgroundColor, size = 48.dp)
            ) {
                SvgLoader(
                    modifier = Modifier
                        .size(iconSize ?: 26.dp)
                        .align(Alignment.Center),
                    data = svgRes,
                    //colorFilter = ColorFilter.tint(color = Color.Red)
                )
            }
            Text(
                text = title,
                fontSize = 13.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                color = ColorText,
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    IconTextMenu(
        modifier = Modifier
            .fillMaxWidth(),
        title = "Pay",
        svgRes = R.raw.icon_pay
    ) {

    }
}