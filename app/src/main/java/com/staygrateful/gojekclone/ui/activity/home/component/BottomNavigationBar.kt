package com.staygrateful.gojekclone.ui.activity.home.component

import android.animation.ValueAnimator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.staygrateful.common_library.component.DotBadge
import com.staygrateful.common_library.component.SvgLoader
import com.staygrateful.common_library.extension.circle
import com.staygrateful.common_library.extension.outerShadow
import com.staygrateful.gojekclone.ui.activity.data.BottomNavItem
import com.staygrateful.gojekclone.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    selectedIconColor: Color = ColorPrimary,
    unselectedIconColor: Color = ColorGrey,
    selectedTextColor: Color = ColorText,
    unselectedTextColor: Color = ColorGrey,
    onSelectedPage: (Int) -> Unit
) {

    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .height(65.dp)
            .fillMaxWidth()
            .background(color = Color.Red)
            .outerShadow(elevation = 2.dp)
    ) {

        items.forEachIndexed { index, item ->
            BottomNavItemBar(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .circle(color = Color.White)
                    .clickable {
                        coroutineScope.launch {
                            selectedIndex = index
                            onSelectedPage(index)
                        }
                    },
                item = item, isSelected = index == selectedIndex,
                selectedIconColor = selectedIconColor,
                unselectedIconColor = unselectedIconColor,
                selectedTextColor = selectedTextColor,
                unselectedTextColor = unselectedTextColor,
            )
        }
    }
}

@Composable
fun BottomNavItemBar(
    modifier: Modifier,
    item: BottomNavItem,
    isSelected: Boolean,
    selectedIconColor: Color = ColorPrimary,
    unselectedIconColor: Color = ColorIcon,
    selectedTextColor: Color = ColorText,
    unselectedTextColor: Color = ColorText,
) {

    var scale by rememberSaveable { mutableStateOf(1f) }
    val textSize = if (isSelected) 12.sp else 12.sp
    val iconColor = if (isSelected) selectedIconColor else unselectedIconColor
    val textColor = if (isSelected) selectedTextColor else unselectedTextColor
    val textWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal

    LaunchedEffect(isSelected) {
        val animation =
            if (isSelected) ValueAnimator.ofFloat(1f, 1.2f, 1f)
            else ValueAnimator.ofFloat(1f, 1f)
        animation.duration = 300
        animation.addUpdateListener {
            scale = it.animatedValue as Float
        }
        animation.start()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .padding(bottom = 0.dp)
            .size(28.dp)) {

            SvgLoader(
                modifier = Modifier
                    .scale(scale)
                    .size(23.dp)
                    .align(Alignment.Center),
                data = item.icon,
                colorFilter = ColorFilter.tint(color = iconColor)
            )

            if (item.showBadge) {
                DotBadge(Modifier.align(Alignment.TopEnd), border = 1.2.dp, size = 13.dp)
            }
        }

        Text(text = item.title, fontSize = textSize, color = textColor, fontWeight = textWeight)
    }
}