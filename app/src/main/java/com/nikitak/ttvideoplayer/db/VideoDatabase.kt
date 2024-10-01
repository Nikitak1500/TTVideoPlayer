package com.nikitak.ttvideoplayer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nikitak.ttvideoplayer.models.VideoDBEntity

@Database(entities = [VideoDBEntity::class], version = 1)
abstract class VideoDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}