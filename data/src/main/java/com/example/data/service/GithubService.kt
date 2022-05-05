package com.example.data.service

import com.example.data.model.DataUser
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{owner}/repos")
    fun getRepos(
        @Path("owner") owner: String
    ) : Single<List<DataUser>>
}