package com.example.cleanarchitecture.data.source.remote

import kotlinx.coroutines.Deferred
import com.example.cleanarchitecture.domain.model.GithubUser
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    fun getAllAsync(): Deferred<List<GithubUser>>
}