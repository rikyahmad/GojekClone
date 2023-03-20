package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.ImageLoader
import com.staygrateful.common_library.extension.outerShadow
import com.staygrateful.gojekclone.data.model.HomePromoData
import com.staygrateful.gojekclone.ui.theme.*

@Composable
fun HomePromo(data: HomePromoData) {
    Column(
        modifier = Modifier
            .padding(horizontal = PaddingContent)
            .outerShadow(
                color = ColorShadow,
                contentColor = Color.White,
                cornersRadius = CornerNormal,
                elevation = 1.5.dp
            )
            .clickable {

            }
    ) {
        ImageLoader(
            modifier = Modifier.fillMaxWidth(),
            data = data.imageUrl,
            contentScale = ContentScale.FillWidth
        )
        Text(
            modifier = Modifier
                .padding(horizontal = PaddingContent)
                .padding(bottom = 8.dp, top = PaddingContent),
            text = data.title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.5.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = ColorTextDark
        )
        Text(
            modifier = Modifier
                .padding(horizontal = PaddingContent)
                .padding(bottom = PaddingContent),
            text = data.desc,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = ColorTextHint,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}