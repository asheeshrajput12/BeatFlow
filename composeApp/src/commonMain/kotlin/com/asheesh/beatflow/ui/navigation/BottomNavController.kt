package com.asheesh.beatflow.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.asheesh.beatflow.ui.Color_Bluw
import com.asheesh.beatflow.ui.screen.HomeScreen
import com.asheesh.beatflow.ui.screen.LibraryScreen
import com.asheesh.beatflow.ui.screen.SearchScreen


@Composable
fun BottomNavHost(controller: BottomNavController) {
    when (controller.currentDestination) {
        BottomNavItem.Home -> HomeScreen()
        BottomNavItem.Search -> SearchScreen()
        BottomNavItem.Profile -> LibraryScreen()
    }
}
@Composable
fun CommonBottomNavigation(
    controller: BottomNavController,
    items: List<BottomNavItem>,
    iconProvider: @Composable (BottomNavItem) -> Unit,
) {
    NavigationBar {
        val currentRoute = controller.currentDestination.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { controller.navigate(item) },
                icon = { iconProvider(item) },
                label = { Text(item.title, color = if(currentRoute == item.route) Color_Bluw else Color.Gray.copy(alpha = 0.5f)) }
            )
        }
    }
}


class BottomNavController(
    startDestination: BottomNavItem
) {
    var currentDestination by mutableStateOf(startDestination)
        private set

    fun navigate(destination: BottomNavItem) {
        if (currentDestination.route != destination.route) {
            currentDestination = destination
        }
    }
}
@Composable
fun rememberBottomNavController(
    startDestination: BottomNavItem = BottomNavItem.Home
): BottomNavController {
    return remember { BottomNavController(startDestination) }
}
