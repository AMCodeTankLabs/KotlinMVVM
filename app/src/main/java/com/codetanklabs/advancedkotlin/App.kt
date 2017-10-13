package com.codetanklabs.advancedkotlin

import android.app.Application
import com.codetanklabs.advancedkotlin.model.network.RequestInterface
import com.codetanklabs.advancedkotlin.viewmodel.UserListViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by andrewmay on 10/12/17.
 */

class App: Application() {


    companion object {
        private lateinit var retrofit: Retrofit
        private lateinit var requestInterface: RequestInterface

        private lateinit var userListViewModel: UserListViewModel

        fun injectUserListViewModel() = userListViewModel
    }

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://10.0.2.2:3000/")
                .build()

        requestInterface = retrofit.create(RequestInterface::class.java)
        userListViewModel = UserListViewModel(requestInterface)

    }
}