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
import java.util.concurrent.TimeUnit


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
            val messageBot = Message(bot, "Для того чтобы зарегестрировать ИП вам нужно:\n" +
                    "1. Определиться с видами деятельности\n" +
                    "2. Выбрать систему налогообложения\n" +
                    "УСН (упрощенная система налогообложения)\n" +
                    "ЕНВД (единый налог на вмененный доход)\n" +
                    "ПСН (патентная система налогообложения)\n" +
                    "ЕСХН (единый сельскохозяйственный налог)\n" +
                    "3. Подать заявление на регистрацию\n" +
                    "Вот что нужно подать в налоговую:\n" +
                    "заявление о регистрации в качестве ИП по форме Р 21001;\n" +
                    "копию паспорта.")
            adapter.addToStart(message, false)
            TimeUnit.MILLISECONDS.sleep(1250)
            adapter.addToStart(messageBot, false)
            true
        })
    }

    private fun inputController() {

    }
}
