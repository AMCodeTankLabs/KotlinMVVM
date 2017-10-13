package com.codetanklabs.advancedkotlin.viewmodel

import com.codetanklabs.advancedkotlin.model.network.RequestInterface
import com.codetanklabs.advancedkotlin.viewmodel.data.UsersList
import io.reactivex.Observable

// TODO: Optionally can use a 'repository' model
class UserListViewModel(val requestInterface: RequestInterface) {

    fun getUser(): Observable<UsersList> {

        return requestInterface.getUsers()
                .map {
                    UsersList(it.take(10), "Top 10 Users")
                }
                .onErrorReturn {
                    UsersList(emptyList(), "An error occurred", it)
                }
    }

}