package com.example.data.source

import com.example.data.model.DataUser
import com.example.data.service.GithubService
import io.reactivex.Single
import javax.inject.Inject

class GithubSourceImpl @Inject constructor(
    private val githubService: GithubService
) : GithubSource {
    override fun getRepos(owner: String): Single<List<DataUser>> =
        githubService.getRepos(owner)
}