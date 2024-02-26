package com.example.navtestapp.data

import com.example.navtestapp.R
import com.example.navtestapp.model.User

class Datasource {

    fun loadUsers(): ArrayList<User> {
        return arrayListOf<User>(
            User(1, R.string.user1, R.drawable.image1),
            User(2, R.string.user2, R.drawable.image2),
            User(3, R.string.user3, R.drawable.image3),
            User(4, R.string.user4, R.drawable.image4),
            User(5, R.string.user5, R.drawable.image5),
            User(6, R.string.user6, R.drawable.image6),
            User(7, R.string.user7, R.drawable.image7),
            User(8, R.string.user8, R.drawable.image8),
            User(9, R.string.user9, R.drawable.image9),
            User(10, R.string.user10, R.drawable.image10))
    }

}