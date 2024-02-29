package com.example.navtestapp.ui.features.home.friendsList

class FriendsListUiModel(
    viewAlert: Boolean,
    username: String
) {

    companion object {
        fun initialValue() = FriendsListUiModel(
            viewAlert = false,
            username = ""
        )

        fun preview() = initialValue()
    }

}