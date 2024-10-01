package com.nikitak.ttvideoplayer.models

data class VideoResponse(
    val categories: List<Category>,
) {
    class Category(
        val name: String,
        val videos: List<Video>,
    ) {
        class Video(
            val description: String,
            val sources: List<String>,
            val subtitle: String,
            val thumb: String,
            val title: String,
        )
    }
}
