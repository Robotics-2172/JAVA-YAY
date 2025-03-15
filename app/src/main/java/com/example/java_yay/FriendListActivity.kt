package com.example.java_yay

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.concurrent.CompletableFuture

class FriendListActivity : Activity() {
    private var mAdapter: ArrayAdapter<String>? = null
    private var mFriendDB: FriendDB? = null

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.friends_list_layout)
        mFriendDB = (application as CraigApplication).friendDB
        val panel = findViewById<ListView>(R.id.friendList)
        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1)
        panel.adapter = mAdapter

        CompletableFuture
            .supplyAsync<List<Friend>> { mFriendDB?.friendDao()?.all }
            .thenAcceptOnUiThread(this) { friends -> populateFriendList(friends) }

        findViewById<View>(R.id.addFriendButton).setOnClickListener {
            val intent = Intent(this, AddFriendActivity::class.java)
            startActivityForResult(intent, 0)
        }
        findViewById<View>(R.id.clearButton).setOnClickListener { deleteFriendList() }
        findViewById<View>(R.id.homeButtonFriendList).setOnClickListener { finish() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        recreate()
    }

    private fun populateFriendList(friends: List<Friend>) {
        for (friend in friends) {
            Log.i(CraigApplication.TAG, friends.indexOf(friend).toString())
            mAdapter!!.add(friend.name)
        }
    }

    private fun deleteFriendList() {
        CompletableFuture.runAsync {
            val dao = mFriendDB!!.friendDao()
            for (friend in dao.all) {
                dao.delete(friend)
            }
        }.thenRunOnUiThread(this) {
            recreate()
        }
    }
}
