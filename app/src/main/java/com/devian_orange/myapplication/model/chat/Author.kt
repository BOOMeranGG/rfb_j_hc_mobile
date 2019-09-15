package com.devian_orange.myapplication.model.chat

import com.stfalcon.chatkit.commons.models.IUser

class Author : IUser {

    private var id = "1"
    private var name = "You"

    override fun getId(): String {
        return id
    }

    override fun getAvatar(): String {
        return "None"
    }

    override fun getName(): String {
        return name
    }
}