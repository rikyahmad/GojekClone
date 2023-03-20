package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.ImageLoader
import com.staygrateful.common_library.extension.outerShadow
import com.staygrateful.gojekclone.R
import com.staygrateful.gojekclone.data.model.HomePromoSliderData
import com.staygrateful.gojekclone.ui.theme.*

@Composable
fun HomePromoSlider(data: HomePromoSliderData) {
    Column() {
        if (data.imageTitle != null) {
            ImageLoader(
                modifier = Modifier
                    .padding(horizontal = PaddingContent)
                    .padding(bottom = 10.dp)
                    .height(17.dp),
                data = data.imageTitle,
                contentScale = ContentScale.FillHeight
            )
        }
        Text(
            modifier = Modifier
                .padding(horizontal = PaddingContent)
                .padding(bottom = 10.dp),
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
                .padding(bottom = 20.dp),
            text = data.desc,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = ColorTextHint,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = PaddingContent),
            horizontalArrangement = Arrangement.spacedBy(PaddingContent)
        ) {
            items(data.promoUrls) { url ->
                ImageLoader(
                    modifier = Modifier
                        .height(170.dp)
                        .outerShadow(
                            color = ColorShadow,
                            elevation = 3.dp,
                            cornersRadius = CornerNormal
                        ),
                    data = url,
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}