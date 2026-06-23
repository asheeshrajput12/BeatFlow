package com.asheesh.beatflow

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import beatflow.composeapp.generated.resources.Res
import beatflow.composeapp.generated.resources.compose_multiplatform
import beatflow.composeapp.generated.resources.ic_folder
import beatflow.composeapp.generated.resources.ic_home
import beatflow.composeapp.generated.resources.ic_search
import com.asheesh.beatflow.ui.navigation.BottomNavHost
import com.asheesh.beatflow.ui.navigation.BottomNavItem
import com.asheesh.beatflow.ui.navigation.CommonBottomNavigation
import com.asheesh.beatflow.ui.navigation.rememberBottomNavController
import com.asheesh.beatflow.ui.screen.HomeScreen

@Composable
@Preview
fun App() {
    val navController = rememberBottomNavController()
    Scaffold(
        bottomBar = {
            CommonBottomNavigation(
                controller = navController,
                items = listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Search,
                    BottomNavItem.Profile
                )
            ) { item ->
                when (item) {
                    BottomNavItem.Home -> Icon(
                        painter = painterResource(resource = Res.drawable.ic_home),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )

                    BottomNavItem.Search -> Icon(
                        painterResource(Res.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )

                    BottomNavItem.Profile -> Icon(
                        painterResource(Res.drawable.ic_folder),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                }
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            BottomNavHost(navController)
        }
    }

}