package com.example.navtestapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.navtestapp.data.Datasource
import com.example.navtestapp.model.User

class UserViewModel(
    datasource: Datasource
): ViewModel() {

    private var _users = datasource.loadUsers().toMutableList()
    private val _filteredUsers = mutableStateListOf<User>().also {
        it.addAll(_users)
    }

    val users: List<User>
        get() = _filteredUsers

    fun removeUser(user: User) {
        _users.remove(user)
        _filteredUsers.clear()
        _filteredUsers.addAll(_users) // Update filtered list
    }

}