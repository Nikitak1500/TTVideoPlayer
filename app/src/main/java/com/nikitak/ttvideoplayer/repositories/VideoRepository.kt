package com.nikitak.ttvideoplayer.repositories

import android.util.Log
import com.nikitak.ttvideoplayer.apis.VideoApi
import com.nikitak.ttvideoplayer.db.VideoDao
import com.nikitak.ttvideoplayer.models.VideoDBEntity
import javax.inject.Inject

class VideoRepository @Inject constructor(
    private val videoApi: VideoApi,
    private val videoDao: VideoDao,
) {
    suspend fun getVideos(): List<VideoDBEntity> {
        val cachedVideos = videoDao.getAllVideos()
        try {
            return cachedVideos.ifEmpty {
                val videosFromApi = videoApi.getVideos().categories[0].videos.map {
                    VideoDBEntity(
                        description = it.description,
                        url = it.sources[0],
                        subtitle = it.subtitle,
                        image = it.thumb,
                        title = it.title
                    )
                }
                videoDao.insertVideos(videosFromApi)
                videosFromApi
            }
        } catch (e: Exception) {
            Log.e("VideoViewModel", "Error fetching videos", e)
        }
        return listOf()
    }
}