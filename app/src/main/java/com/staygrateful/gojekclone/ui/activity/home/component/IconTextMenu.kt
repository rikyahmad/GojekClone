package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.annotation.RawRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.SvgLoader
import com.staygrateful.common_library.extension.clip
import com.staygrateful.common_library.extension.rounded
import com.staygrateful.gojekclone.R


@Composable
fun IconTextMenu(
    modifier: Modifier, title: String, @RawRes svgRes: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(start = 5.dp)
            .height(70.dp)
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
                .padding(bottom = 5.dp)
                .size(22.dp)
                .rounded(color = Color.White, corner = 8.dp)
        ) {
            SvgLoader(
                modifier = Modifier
                    .size(10.dp)
                    .align(Alignment.Center),
                data = svgRes,
                //colorFilter = ColorFilter.tint(color = Color.Red)
            )
        }
        Text(
            text = title,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            maxLines = 1,
        )
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