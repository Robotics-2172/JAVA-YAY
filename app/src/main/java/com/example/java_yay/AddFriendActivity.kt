package com.example.java_yay

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.CompletableFuture


class AddFriendActivity : Activity() {
    private val mCalendar: Calendar = Calendar.getInstance()

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.add_friend_layout)

        val birthdayField = findViewById<EditText>(R.id.birthdayField)
        birthdayField.setOnClickListener {
            DatePickerDialog(this,
                { _, year, month, day ->
                    mCalendar.set(Calendar.YEAR, year)
                    mCalendar.set(Calendar.MONTH, month)
                    mCalendar.set(Calendar.DAY_OF_MONTH, day)
                    val dateFormat = SimpleDateFormat("MM/dd/yy", Locale.US)
                    birthdayField.setText(getString(R.string.birthday_list_text, dateFormat.format(mCalendar.time)))
                },
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        findViewById<View>(R.id.submitFriendButton).setOnClickListener { submitFriend() }
    }

    private fun submitFriend() {
        val db = (application as CraigApplication).friendDB
        val friend = Friend()
        val nameField = findViewById<EditText>(R.id.nameField)
        val descriptionField = findViewById<EditText>(R.id.descriptionField)
        friend.name = nameField.text.toString()
        friend.birthday = mCalendar.time
        friend.description = descriptionField.text.toString()
        CompletableFuture
            .runAsync { db.friendDao().insertAll(friend) }
            .thenRunOnUiThread(this) {
                Toast.makeText(
                    this,
                    friend.name + " has been added to your friends list!",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
    }
}
