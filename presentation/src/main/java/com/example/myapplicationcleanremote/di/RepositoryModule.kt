package com.example.myapplicationcleanremote.di

import com.example.data.repository.GithubRepositoryImpl
import com.example.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideGithubRepository(repositoryImpl: GithubRepositoryImpl): GithubRepository {
        return repositoryImpl
    }
}