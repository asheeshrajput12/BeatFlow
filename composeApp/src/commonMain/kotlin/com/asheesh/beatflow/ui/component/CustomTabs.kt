package com.asheesh.beatflow.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun <T> GeneralScrollableTabBar(
    items: List<T>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    getItemLabel: (T) -> String,
    viewType: TabViewType = TabViewType.Simple,
    selectedColor: Color = Color(0xFF6200EE),
    unselectedColor: Color = Color.Gray,
    containerColor: Color = Color.Transparent
) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 16.dp,
        containerColor = containerColor,
        // Hide default indicator for Rectangular/Square types
        indicator = { tabPositions ->
            if (viewType == TabViewType.Simple) {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    color = selectedColor
                )
            }
        },
        divider = {}
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = selectedIndex == index

            // Determine shape based on ViewType
            val shape = when (viewType) {
                TabViewType.Rectangular -> RoundedCornerShape(24.dp)
                TabViewType.Square -> RectangleShape
                TabViewType.Simple -> RectangleShape
            }

            Tab(
                selected = isSelected,
                onClick = { onTabSelected(index) },
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 4.dp)
                    .clip(shape)
                    .background(
                        if (isSelected && viewType != TabViewType.Simple)
                            selectedColor.copy(alpha = 0.15f) // Light fill for selection
                        else Color.Transparent
                    )
                    .then(
                        if (isSelected && viewType != TabViewType.Simple)
                            Modifier.border(1.dp, selectedColor, shape)
                        else Modifier
                    ),
                text = {
                    Text(
                        text = getItemLabel(item),
                        style = MaterialTheme.typography.labelLarge,
                        color = if (isSelected) selectedColor else unselectedColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            )
        }
    }
}

enum class TabViewType {
    Simple,      // Standard text with an underline indicator
    Rectangular, // Rounded corners with a background fill
    Square       // Sharp corners with a background fill
}