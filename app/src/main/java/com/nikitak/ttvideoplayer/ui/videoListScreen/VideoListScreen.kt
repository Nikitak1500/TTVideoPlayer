package com.nikitak.ttvideoplayer.ui.videoListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikitak.ttvideoplayer.models.VideoDBEntity
import com.nikitak.ttvideoplayer.ui.theme.UTOrange
import com.nikitak.ttvideoplayer.viewModels.VideoViewModel

@Composable
fun VideoListScreen(
    viewModel: VideoViewModel = hiltViewModel(),
    onVideoClick: (VideoDBEntity) -> Unit,
) {
    val videoList by viewModel.videos.observeAsState(emptyList())

    LazyColumn(
        Modifier.background(UTOrange)
    ) {
        items(videoList) { video ->
            VideoItem(video, onClick = { onVideoClick(video) })
        }
    }
}