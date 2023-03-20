package com.staygrateful.gojekclone.ui.activity.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.VerticalGrid
import com.staygrateful.common_library.extension.spacer
import com.staygrateful.gojekclone.R
import com.staygrateful.gojekclone.data.local.homeMenuList
import com.staygrateful.gojekclone.data.model.HomePromoData
import com.staygrateful.gojekclone.data.model.HomePromoSliderData
import com.staygrateful.gojekclone.ui.activity.home.component.*
import com.staygrateful.gojekclone.ui.theme.PaddingContent

@Composable
fun HomeScreen() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        val scrollState = rememberScrollState()
        val spanCount = 4
        Box(Modifier.background(color = Color.White)) {
            Column {
                HomeMenuSearch()
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = PaddingContent)
                ) {
                    item {
                        HomeMenuTop()
                    }
                    spacer(height = 20.dp)
                    item {
                        VerticalGrid(
                            horizontalPadding = PaddingContent,
                            data = homeMenuList,
                            span = spanCount
                        ) { _, data ->
                            ItemHomeMenu(
                                backgroundColor = data.color,
                                iconSize = data.size,
                                title = data.title,
                                svgRes = data.svgRes
                            ) {

                            }
                        }
                    }
                    spacer(height = 15.dp)

                    item { HomeGoClub() }

                    spacer(height = 30.dp)

                    item { HomeQuickActions() }

                    spacer(height = 30.dp)

                    item {
                        HomePromoSlider(
                            data = HomePromoSliderData(
                                1,
                                title = "Belanja makin hemat \uD83E\uDD11",
                                desc = "Dapetin diskon dan harga spesialnya di Tokopedia sekarang sebelum kehabisan!",
                                imageTitle = R.raw.image_gopay,
                                promoUrls = listOf(
                                    R.raw.image_promo_1,
                                    R.raw.image_promo_2,
                                    R.raw.image_promo_3,
                                )
                            )
                        )
                    }

                    spacer(height = 30.dp)

                    item {
                        HomePromo(
                            data = HomePromoData(
                                1,
                                title = "Belanja hemat, dianternya cepat",
                                desc = "Mumpung ada diskon Harbolnas 12.12, yuk belanja di GoMart!",
                                imageUrl = R.raw.image_promo_2
                            )
                        )
                    }

                    spacer(height = 30.dp)

                    item {
                        HomePromoSlider(
                            HomePromoSliderData(
                                1,
                                title = "Belanja makin hemat \uD83E\uDD11",
                                desc = "Dapetin diskon dan harga spesialnya di Tokopedia sekarang sebelum kehabisan!",
                                promoUrls = listOf(
                                    R.raw.image_promo_3,
                                    R.raw.image_promo_1,
                                    R.raw.image_promo_2,
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}