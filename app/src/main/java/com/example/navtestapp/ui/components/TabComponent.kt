package com.example.navtestapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TabComponent(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        text = {
            val style = MaterialTheme.typography.labelLarge.copy(textAlign = TextAlign.Center)
            ProvideTextStyle(
                value = style,
                content = {
                    Box(modifier = Modifier.padding(top = 8.dp)) {
                        text()
                    }
                },
            )
        }
    )
}

@Composable
fun TabRowComponent(
    modifier: Modifier,
    selectedTabIndex: Int,
    tabs : @Composable () -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        tabs = tabs,
        containerColor = Color.Transparent,
        contentColor = Color.Red,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                height = 2.dp,
                color = Color.Red,
            )
        }
    )
}

@Preview
@Composable
fun TabRowComponentPreview() {
    val titles = listOf("Topics", "People")
    TabRowComponent(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp), selectedTabIndex = 0) {
        titles.forEachIndexed { index: Int, title: String ->
            TabComponent(
                selected = index == 0,
                onClick = { },
                text = { Text(text = title) },
            )
        }
    }
}