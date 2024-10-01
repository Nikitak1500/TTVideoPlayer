package com.nikitak.ttvideoplayer.ui.navControllers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikitak.ttvideoplayer.ui.playerScreen.PlayerScreen
import com.nikitak.ttvideoplayer.ui.videoListScreen.VideoListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "video_list_screen") {
        composable("video_list_screen") {
            VideoListScreen() { video ->
                navController.navigate("player_screen/${video.id}")
            }
        }
        composable("player_screen/{videoId}") { backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("videoId")
            videoId?.let { PlayerScreen(videoId) }
        }
    }
}

