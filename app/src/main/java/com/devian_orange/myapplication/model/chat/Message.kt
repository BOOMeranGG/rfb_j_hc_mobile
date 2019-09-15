package com.devian_orange.myapplication.model.chat

import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser
import java.util.*

class Message(private val author: IUser, val messageText: String) : IMessage {

    private var id = "1"

    override fun getId(): String {
        return id
    }

    override fun getText(): String {
        return messageText
    }

    override fun getCreatedAt(): Date {
        return Date()
    }

    override fun getUser(): IUser {
        return author
    }
}
