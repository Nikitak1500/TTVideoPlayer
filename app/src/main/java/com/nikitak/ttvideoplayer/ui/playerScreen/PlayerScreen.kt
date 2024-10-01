package com.nikitak.ttvideoplayer.ui.playerScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.ui.PlayerView
import com.nikitak.ttvideoplayer.ui.theme.PrussianBlue
import com.nikitak.ttvideoplayer.viewModels.VideoViewModel

@Composable
fun PlayerScreen(videoId: String, viewModel: VideoViewModel = hiltViewModel()) {
    val videos by viewModel.videos.observeAsState(emptyList())
    var playbackTimecode by rememberSaveable { mutableLongStateOf(0L) }
    var playbackPosition: Int? by rememberSaveable { mutableStateOf(null) }


    val context = LocalContext.current
    Box(
        Modifier.background(PrussianBlue)
    ) {
        if (videos.isNotEmpty()) {
            videos.let {
                if (playbackPosition == null) playbackPosition =
                    viewModel.getVideoPositionById(videoId.toInt())
                val exoPlayer = initializePlayer(context, playbackPosition!!, playbackTimecode, it)

                AndroidView(
                    factory = { PlayerView(context).apply { player = exoPlayer } },
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(16f / 9f)
                )

                DisposableEffect(Unit) {
                    onDispose {
                        playbackTimecode = exoPlayer.currentPosition
                        playbackPosition = exoPlayer.currentMediaItemIndex
                        exoPlayer.release()
                    }
                }
            }
        }
    }


}

