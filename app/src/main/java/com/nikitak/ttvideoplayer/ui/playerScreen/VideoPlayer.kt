package com.nikitak.ttvideoplayer.ui.playerScreen

import android.content.Context
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ConcatenatingMediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import com.nikitak.ttvideoplayer.models.VideoDBEntity

@OptIn(UnstableApi::class)
fun initializePlayer(
    context: Context,
    startIndex: Int,
    videoTimecode: Long,
    videoList: List<VideoDBEntity>,
): ExoPlayer {
    val exoPlayer = ExoPlayer.Builder(context).build()
    val concatenatingMediaSource = ConcatenatingMediaSource()

    videoList.forEach { videoItem ->
        val mediaSource = ProgressiveMediaSource.Factory(DefaultHttpDataSource.Factory())
            .createMediaSource(MediaItem.fromUri(videoItem.url))
        concatenatingMediaSource.addMediaSource(mediaSource)
    }

    exoPlayer.setMediaSource(concatenatingMediaSource)
    exoPlayer.prepare()

    exoPlayer.seekTo(startIndex, videoTimecode)
    exoPlayer.playWhenReady = true

    return exoPlayer
}