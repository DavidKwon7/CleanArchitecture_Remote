package com.example.myapplicationcleanremote.di

import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetUserUseCase(repository: GithubRepository): GetUserUseCase {
        return GetUserUseCase(repository)
    }
}