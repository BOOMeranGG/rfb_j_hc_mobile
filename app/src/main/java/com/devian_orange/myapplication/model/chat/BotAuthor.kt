package com.devian_orange.myapplication.model.chat

import com.stfalcon.chatkit.commons.models.IUser

class BotAuthor : IUser {

    private var id = "0"
    private var name = "Bot"

    override fun getAvatar(): String {
        return "None"
    }

    override fun getName(): String {
        return name
    }

    override fun getId(): String {
        return id
    }
}