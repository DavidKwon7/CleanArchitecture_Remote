package com.example.data.source

import com.example.data.model.DataUser
import com.example.domain.model.User
import io.reactivex.Single

interface GithubSource {
    fun getRepos(owner: String): Single<List<DataUser>>
}