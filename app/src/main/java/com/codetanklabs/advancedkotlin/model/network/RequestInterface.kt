package com.codetanklabs.advancedkotlin.model.network

import com.codetanklabs.advancedkotlin.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface RequestInterface {

    @GET("api/v1/users/sample_users")
    fun getUsers(): Observable<List<User>>

}