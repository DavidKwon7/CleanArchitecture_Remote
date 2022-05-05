package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.GithubRepository
import io.reactivex.Single

class GetUserUseCase(
    private val githubRepository: GithubRepository
) {
    fun execute(owner: String): Single<List<User>> {
        return githubRepository.getRepos(owner)
    }
}