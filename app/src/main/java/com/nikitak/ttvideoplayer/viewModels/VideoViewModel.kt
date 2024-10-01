package com.nikitak.ttvideoplayer.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikitak.ttvideoplayer.models.VideoDBEntity
import com.nikitak.ttvideoplayer.repositories.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val repository: VideoRepository,
) : ViewModel() {
    private val _videos = MutableLiveData<List<VideoDBEntity>>()
    val videos: LiveData<List<VideoDBEntity>> get() = _videos

    init {
        viewModelScope.launch {
            _videos.value = repository.getVideos()
        }
    }

    fun getVideoPositionById(id: Int): Int {
        _videos.value?.forEachIndexed { index, videoDBEntity ->
            if (videoDBEntity.id == id) return index
        }
        return 0
    }
}