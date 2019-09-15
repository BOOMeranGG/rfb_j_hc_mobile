package com.devian_orange.myapplication.ui.activities

import android.os.Bundle
import com.devian_orange.myapplication.R
import com.devian_orange.myapplication.model.chat.Author
import com.devian_orange.myapplication.model.chat.BotAuthor
import com.devian_orange.myapplication.model.chat.ChatBotController
import com.devian_orange.myapplication.model.chat.Message
import com.stfalcon.chatkit.messages.MessagesListAdapter
import kotlinx.android.synthetic.main.activity_faq_chat.*
import com.stfalcon.chatkit.messages.MessageInput


class FaqChatActivity : BaseActivity(4) {

    private val chatBotController = ChatBotController()
    private val bot = BotAuthor()
    private val user = Author()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq_chat)

        close_image.setOnClickListener {
            finish()
        }

        val adapter = MessagesListAdapter<Message>(user.id, null)
        messagesList.setAdapter(adapter)
        input.setInputListener(MessageInput.InputListener {
            val msg = input.inputEditText.text.toString()
            val message = Message(user, msg)
            val messageBot = Message(bot, msg)
            adapter.addToStart(message, false)
            adapter.addToStart(messageBot, false)
            true
        })
    }

    private fun inputController() {

    }
}
