package com.example.data.repository

import com.example.data.mapper.Mapper
import com.example.data.model.DataUser
import com.example.data.source.GithubSource
import com.example.domain.model.User
import com.example.domain.repository.GithubRepository
import io.reactivex.Single
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubSource: GithubSource,
) : GithubRepository {
    override fun getRepos(owner: String): Single<List<User>> =
        githubSource.getRepos(owner).map { it.map { userRepos ->
            DataUser.toDomain(userRepos)
        } }
}