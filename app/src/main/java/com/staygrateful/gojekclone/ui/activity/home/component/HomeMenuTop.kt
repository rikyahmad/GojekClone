package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.staygrateful.common_library.component.*
import com.staygrateful.common_library.extension.clip
import com.staygrateful.common_library.extension.rounded
import com.staygrateful.common_library.util.UtilsIntent
import com.staygrateful.gojekclone.R
import com.staygrateful.gojekclone.data.local.homeCarouselList
import com.staygrateful.gojekclone.data.model.HomeCarouselData
import com.staygrateful.gojekclone.ui.theme.CornerNormal
import com.staygrateful.gojekclone.ui.theme.GojekCopyTheme
import com.staygrateful.gojekclone.ui.theme.PaddingContent

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeMenuTop() {
    val pagerState = rememberPagerState()
    Box(
        modifier = Modifier
            .padding(horizontal = PaddingContent)
            .height(98.dp)
            .fillMaxWidth()
            .rounded(color = MaterialTheme.colorScheme.tertiary, corner = CornerNormal)
            .padding(start = 5.dp, end = 10.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 9.dp, start = 6.dp)
            ) {

                PageIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    indicatorType = IndicatorType.VERTICAL,
                    numberOfPages = pagerState.pageCount,
                    selectedPage = pagerState.currentPage,
                    defaultColor = Color.LightGray,
                    selectedColor = Color.White,
                    defaultHeight = 8.dp,
                    defaultWidth = 2.6.dp,
                    selectedWidth = 2.6.dp,
                    selectedHeight = 8.dp,
                    defaultCorner = 10.dp,
                    selectedCorner = 10.dp,
                    space = 5.dp,
                    animationDurationInMillis = 500,
                )
            }
            VerticalCarousel(height = 100.dp,
                width = 130.dp,
                verticalPadding = 10.dp,
                verticalExtraPadding = 1.dp,
                scaleFrom = 0.9f,
                alphaFrom = 0.5f,
                state = pagerState,
                slideType = CarouselSlideType.AUTO,
                pageCount = homeCarouselList.size,
                onPageSelected = { page ->
                    println("Selected page : $page")
                }) { page ->
                CarouselItem(page, homeCarouselList[page])
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                IconTextMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    title = "Pay",
                    svgRes = R.raw.icon_pay
                ) {

                }
                IconTextMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    title = "Top Up",
                    svgRes = com.staygrateful.common_library.R.raw.icon_add
                ) {

                }
                IconTextMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    title = "Explore",
                    svgRes = R.raw.icon_rocket
                ) {

                }
            }
        }
    }
}

@Composable
private fun CarouselItem(page: Int, data: HomeCarouselData) {
    Column(modifier = Modifier
        .fillMaxSize()
        .clip(10.dp)
        .clickable {
            UtilsIntent.openIntentDestination(data.dest)
        }
        .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start) {

        ImageLoader(
            modifier = Modifier
                .height(data.iconHeight ?: 25.dp)
                .padding(bottom = 5.dp),
            data = data.iconData,
            //colorFilter = ColorFilter.tint(color = Color.Red)
        )

        TextSlideAnimate(
            textList = data.multiText, animateDuration = 1000, animateExtraDelay = 500
        )
    }
}

@Preview
@Composable
private fun Preview() {
    GojekCopyTheme {
        HomeMenuTop()
    }
}