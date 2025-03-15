package com.example.java_yay

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.concurrent.CompletableFuture

class AddFriendActivity : Activity() {
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.add_friend_layout)

        findViewById<View>(R.id.submitFriendButton).setOnClickListener { submitFriend() }
    }

    private fun submitFriend() {
        val db = (application as CraigApplication).friendDB
        val friend = Friend()
        val nameField = findViewById<EditText>(R.id.nameField)
        val birthdayField = findViewById<EditText>(R.id.birthdayField)
        friend.name = nameField.text.toString()
        friend.birthday = birthdayField.text.toString()
        CompletableFuture
            .runAsync { db.friendDao().insertAll(friend) }
            .thenRunOnUiThread(this) {
                Toast.makeText(
                    this,
                    friend.name + " added to your friends list!",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
    }
}
