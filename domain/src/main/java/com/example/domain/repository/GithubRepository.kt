package com.example.domain.repository

import com.example.domain.model.User
import io.reactivex.Single

interface GithubRepository {
    fun getRepos(owner: String): Single<List<User>>
}