package com.nikitak.ttvideoplayer.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nikitak.ttvideoplayer.ui.navControllers.AppNavigation
import com.nikitak.ttvideoplayer.ui.theme.TTVideoPlayerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TTVideoPlayerTheme {
                AppNavigation()
            }
        }
    }
}