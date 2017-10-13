package com.codetanklabs.advancedkotlin.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.codetanklabs.advancedkotlin.App
import com.codetanklabs.advancedkotlin.R
import com.codetanklabs.advancedkotlin.viewmodel.data.UsersList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.users_fragment.*
import java.net.ConnectException

class UsersListFragment : MvvmFragment() {

    val userListViewModel = App.injectUserListViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.users_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        subscribe(userListViewModel.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showUsers(it)
                }, {
                    showError()
                }))
    }

    fun showUsers(data: UsersList) {
        if (data.error == null) {
            usersList.adapter = UserListAdapter(context, R.layout.users_list_item, data.users)
        } else if (data.error is ConnectException) {
            Log.d("Error", "There has been an error")
        } else {
            showError()
        }
    }

    fun showError() {
        Toast.makeText(context, "Well, this doesn't work!", Toast.LENGTH_SHORT).show()
    }
}