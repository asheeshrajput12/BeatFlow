package com.asheesh.beatflow.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import com.asheesh.beatflow.ui.component.GeneralScrollableTabBar
import com.asheesh.beatflow.ui.component.TabViewType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize().background(brush = beatFlowGradient),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    GeneralScrollableTabBar(
                        items = myData,
                        selectedIndex = selectedIndex,
                        onTabSelected = { selectedIndex = it },
                        getItemLabel = { it.title }, // Extracting the string property
                        viewType = TabViewType.Rectangular,
                        selectedColor = Color.Green
                    )

                })
        }
    ) {
        Box(
            modifier = Modifier
                .background(brush = beatFlowGradient)
                .padding(it)
                .fillMaxSize()

        ) {

        }
    }
}

val beatFlowGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF22C55E), // Neon Green
        Color(0xE622C55E),
        Color(0xCC22C55E),
        Color(0xB322C55E),
        Color(0x9922C55E),
        Color(0x8022C55E) // Dark Surface
    ),
    startY = 0f,
    endY = Float.POSITIVE_INFINITY,
    tileMode = TileMode.Mirror
)

data class Category(val id: Int, val title: String)

val myData = listOf(
    Category(1, "Music"),
    Category(2, "Movies"),
    Category(3, "Books"),
    // Adding 10 more
    Category(4, "Gaming"),
    Category(5, "Sports"),
    Category(6, "Health"),
    Category(7, "Travel"),
    Category(8, "Tech"),
    Category(9, "Finance"),
    Category(10, "Fashion"),
    Category(11, "Food"),
    Category(12, "Science"),
    Category(13, "Art")
)