package com.staygrateful.gojekclone.ui.activity.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.common_library.component.DotBadge
import com.staygrateful.common_library.component.SimpleTextField
import com.staygrateful.common_library.component.SvgLoader
import com.staygrateful.common_library.extension.circle
import com.staygrateful.common_library.extension.rounded
import com.staygrateful.common_library.helper.PaddingValue
import com.staygrateful.gojekclone.R
import com.staygrateful.gojekclone.ui.theme.ColorPrimary
import com.staygrateful.gojekclone.ui.theme.ColorText
import com.staygrateful.gojekclone.ui.theme.GojekCopyTheme


@Composable
fun HomeMenuSearch() {
    Row(
        Modifier
            .height(64.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var input by rememberSaveable { mutableStateOf("") }
        SimpleTextField(
            "Find services, food, or places",
            "Find services, food, or places",
            modifier = Modifier
                .weight(1f)
                .height(44.dp)
                .rounded(color = Color.White, corner = 20.dp, clip = true)
                .padding(end = 15.dp, start = 0.dp),
            value = input,
            maxLines = 1,
            style = TextStyle(
                fontSize = 15.sp, color = ColorText, fontWeight = FontWeight.Medium
            ),
            placeholderStyle = TextStyle(
                fontSize = 15.sp, color = ColorText, fontWeight = FontWeight.Normal
            ),
            contentPadding = PaddingValue.ZERO,
            onValueChange = { newText ->
                input = newText.trimStart { it == '0' }
            },
            leadingIcon = {
                SvgLoader(modifier = Modifier.size(18.dp), data = R.raw.icon_search)
                /*Icon(
                    Icons.Filled.Search,
                    modifier = Modifier
                        .size(25.dp),
                    contentDescription = "Search"
                )*/
            }
        )
        Box(
            Modifier
                .padding(start = 15.dp)
                .height(52.dp)
        ) {
            /*Icon(
                Icons.Filled.Person2,
                modifier = Modifier
                    .circle(color = Color.White, size = 44.dp)
                    .padding(9.dp)
                    .align(Alignment.Center),
                tint = ColorGreenDark,
                contentDescription = "Account"
            )*/

            SvgLoader(
                modifier = Modifier
                    .circle(color = Color.White, size = 44.dp)
                    .padding(8.dp)
                    .align(Alignment.Center),
                data = R.raw.icon_account,
                colorFilter = ColorFilter.tint(color = ColorPrimary)
            )

            DotBadge(Modifier.align(Alignment.TopEnd))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    GojekCopyTheme {
        HomeMenuSearch()
    }
}