package com.nikitak.ttvideoplayer.ui.videoListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nikitak.ttvideoplayer.models.VideoDBEntity
import com.nikitak.ttvideoplayer.ui.theme.SelectiveYellow

@Composable
fun VideoItem(video: VideoDBEntity, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(12.dp)
            .background(SelectiveYellow)
    ) {
        AsyncImage(
            model = video.image,
            contentDescription = "Video image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(160.dp)
                .height(90.dp)
                .padding(4.dp)
        )
        Column(
            Modifier.fillMaxWidth()
        ) {
            Text(text = video.title, fontSize = 24.sp)
            Text(text = video.subtitle)
        }
    }
}