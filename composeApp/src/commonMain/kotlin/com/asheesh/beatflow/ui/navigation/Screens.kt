package com.asheesh.beatflow.ui.navigation

import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.runtime.Composable

sealed class BottomNavItem(
    val route: String,
    val title: String
) {
    object Home : BottomNavItem("home", "Home")
    object Search : BottomNavItem("search", "Search")
    object Profile : BottomNavItem("profile", "Profile")
}
