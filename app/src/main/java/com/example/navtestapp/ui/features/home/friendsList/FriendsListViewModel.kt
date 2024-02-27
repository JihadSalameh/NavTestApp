package com.example.navtestapp.ui.features.home.friendsList

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navtestapp.data.Datasource
import com.example.navtestapp.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendsListViewModel @Inject constructor(
    datasource: Datasource
): ViewModel() {

    private var _users = datasource.loadUsers().toMutableList()
    private val _filteredUsers = mutableStateListOf<User>().also {
        it.addAll(_users)
    }
    val users: List<User>
        get() = _filteredUsers
    private var _isMessageShown = MutableSharedFlow<Boolean>()
    var isMessageShown = _isMessageShown.asSharedFlow()

    fun removeUser(user: User) {
        _users.remove(user)
        _filteredUsers.clear()
        _filteredUsers.addAll(_users)
    }

    fun setSnackbarMessage() {
        viewModelScope.launch {
            _isMessageShown.emit(true)
        }
    }

}