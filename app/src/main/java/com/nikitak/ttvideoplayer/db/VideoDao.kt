package com.nikitak.ttvideoplayer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nikitak.ttvideoplayer.models.VideoDBEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDao {
    @Query("SELECT * FROM videos")
    suspend fun getAllVideos(): List<VideoDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideos(videos: List<VideoDBEntity>)

    @Query("SELECT * FROM videos WHERE id = :id")
    fun getVideoById(id: String): Flow<VideoDBEntity>
}