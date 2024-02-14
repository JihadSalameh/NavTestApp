package com.example.navtestapp.data

import com.example.navtestapp.R
import com.example.navtestapp.model.User

class Datasource {

    fun loadUsers(): List<User> {
        return listOf<User>(
            User(R.string.user1, R.drawable.image1),
            User(R.string.user2, R.drawable.image2),
            User(R.string.user3, R.drawable.image3),
            User(R.string.user4, R.drawable.image4),
            User(R.string.user5, R.drawable.image5),
            User(R.string.user6, R.drawable.image6),
            User(R.string.user7, R.drawable.image7),
            User(R.string.user8, R.drawable.image8),
            User(R.string.user9, R.drawable.image9),
            User(R.string.user10, R.drawable.image10))
    }

}