package com.example.myapplicationcleanremote.di

import com.example.data.source.GithubSource
import com.example.data.source.GithubSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SourceModule {

    @Singleton
    @Provides
    fun provideGithubSource(sourceImpl: GithubSourceImpl): GithubSource {
        return sourceImpl
    }
}