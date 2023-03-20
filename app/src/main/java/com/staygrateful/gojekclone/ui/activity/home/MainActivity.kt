package com.staygrateful.gojekclone.ui.activity.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.staygrateful.common_library.component.ViewSwitcher
import com.staygrateful.gojekclone.data.local.homeBottomMenuList
import com.staygrateful.gojekclone.ui.activity.home.component.BottomNavigationBar
import com.staygrateful.gojekclone.ui.activity.home.screen.HomeScreen
import com.staygrateful.gojekclone.ui.activity.home.screen.OtherScreen
import com.staygrateful.gojekclone.ui.theme.ColorPrimary
import com.staygrateful.gojekclone.ui.theme.GojekCopyTheme
import com.staygrateful.gojekclone.ui.theme.SystemBarColor

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GojekCopyTheme {
                var selectedPage by rememberSaveable { mutableStateOf(0) }

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = homeBottomMenuList,
                            onSelectedPage = { page ->
                                selectedPage = page
                            }
                        )
                    },
                ) { padding ->
                    ViewSwitcher(
                        selectedPage = selectedPage,
                        contentPadding = padding,
                        count = homeBottomMenuList.size,
                        onPageChanged = { page ->
                            SystemBarColor(
                                statusBarColor = if (page == 0) ColorPrimary else Color.White
                            )
                        }
                    ) { page ->
                        if (page == 0) {
                            HomeScreen()
                        } else {
                            OtherScreen(page = homeBottomMenuList[page].title)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GojekCopyTheme {
        HomeScreen()
    }
}