package com.codetanklabs.advancedkotlin.viewmodel.data

import com.codetanklabs.advancedkotlin.model.User

/**
 * Created by andrewmay on 10/12/17.
 */

data class UsersList(val users: List<User>, val message: String, val error: Throwable? = null)
