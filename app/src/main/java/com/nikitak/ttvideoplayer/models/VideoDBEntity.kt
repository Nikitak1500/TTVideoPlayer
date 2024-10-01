package com.nikitak.ttvideoplayer.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class VideoDBEntity(
    val description: String,
    val url: String,
    val subtitle: String,
    val image: String,
    val title: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
