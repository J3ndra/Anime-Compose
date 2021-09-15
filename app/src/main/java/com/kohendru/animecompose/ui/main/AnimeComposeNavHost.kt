package com.kohendru.animecompose.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.kohendru.animecompose.ui.animes.AnimesComposeScreen
import com.kohendru.animecompose.ui.details.anime.AnimeDetailsScreen
import com.kohendru.animecompose.ui.details.anime.character.CharacterDetailsScreen
import kotlinx.coroutines.FlowPreview

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@FlowPreview
@Composable
fun AnimeComposeNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = RootScreen.Animes.route
    ) {
        navigation(
            route = RootScreen.Animes.route,
            startDestination = LeafScreen.Animes.route
        ) {
            addAnimes(navController)
            addShowAnimeDetails(navController)
            addCharacterDetails(navController)
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@FlowPreview
private fun NavGraphBuilder.addAnimes(navController: NavController) {
    composable(LeafScreen.Animes.route) {
        AnimesComposeScreen(
            openAnimeDetails = { showId ->
                navController.navigate(LeafScreen.AnimeDetails.createRoute(showId))
            }
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
private fun NavGraphBuilder.addShowAnimeDetails(navController: NavController) {
    composable(
        route = LeafScreen.AnimeDetails.route,
        arguments = listOf(
            navArgument("mal_id") { type = NavType.IntType }
        )
    ) {
        AnimeDetailsScreen(
            upPressed = {
                navController.popBackStack()
            },
            openCharacterDetails = { character ->
                navController.navigate(LeafScreen.CharacterDetails.createRoute(character))
            }
        )
    }
}

private fun NavGraphBuilder.addCharacterDetails(navController: NavController) {
    composable(
        route = LeafScreen.CharacterDetails.route,
        arguments = listOf(
            navArgument("mal_id") { type = NavType.IntType }
        )
    ) {
        CharacterDetailsScreen(
            upPressed = {
                navController.popBackStack()
            }
        )
    }
}