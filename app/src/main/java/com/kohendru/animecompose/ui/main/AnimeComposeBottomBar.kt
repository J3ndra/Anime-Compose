package com.kohendru.animecompose.ui.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AnimeComposeBottomBar(
    navController: NavController,
    items: List<RootScreen>
) {
    BottomNavigation(
        backgroundColor = Color(0xFF2E51A2)
    ) {
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                icon = { Icon(imageVector = screen.icon, contentDescription = null)},
                label = { Text(stringResource(screen.label))},
                selected = currentDestination?.hierarchy?.any{ it.route == screen.route} == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true

                        restoreState = true
                    }
                }
            )
        }
    }
}