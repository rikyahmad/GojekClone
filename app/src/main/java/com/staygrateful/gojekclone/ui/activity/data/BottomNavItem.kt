package com.staygrateful.gojekclone.ui.activity.data

import com.staygrateful.gojekclone.R

sealed class BottomNavItem(
    val title: String,
    val icon: Any,
    val screen_route: String,
    val showBadge: Boolean = false
) {
    object Home : BottomNavItem("Home", R.raw.icon_home, "home")
    object Promo : BottomNavItem("Promos", R.raw.icon_promo, "promos")
    object Order : BottomNavItem("Orders", R.raw.icon_order, "orders")
    object Chat : BottomNavItem("Chat", R.raw.icon_chat, "chat", showBadge = true)

    fun routeByArgs(): String {
        val result = "$screen_route?value={value}"
        return result
    }

    fun withArgs(value: String): String {
        val result = "$screen_route?value=$value"
        println("Page : $result")
        return result
    }
}