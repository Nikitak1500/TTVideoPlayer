package com.nikitak.ttvideoplayer.modules

import android.app.Application
import androidx.room.Room
import com.nikitak.ttvideoplayer.apis.VideoApi
import com.nikitak.ttvideoplayer.db.VideoDao
import com.nikitak.ttvideoplayer.db.VideoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VideoModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/Nikitak1500/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideVideoApi(retrofit: Retrofit): VideoApi {
        return retrofit.create(VideoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): VideoDatabase {
        return Room.databaseBuilder(app, VideoDatabase::class.java, "video_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideVideoDao(db: VideoDatabase): VideoDao {
        return db.videoDao()
    }
}