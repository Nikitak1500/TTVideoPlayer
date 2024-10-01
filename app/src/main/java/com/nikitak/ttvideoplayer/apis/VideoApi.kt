package com.nikitak.ttvideoplayer.apis

import com.nikitak.ttvideoplayer.models.VideoResponse
import retrofit2.http.GET

interface VideoApi {
    @GET("d872a2054210adbc111468eb7da9a25f/raw/0688cff7274e17ffff9575e99c706f32599e126b/gistfile1.txt")
    suspend fun getVideos(): VideoResponse
}