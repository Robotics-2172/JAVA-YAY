package com.example.java_yay

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.java_yay.UtilityFunctions.startActivityForResultWithButton
import java.util.concurrent.CompletableFuture


class FriendListActivity : Activity() {
    private var mAdapter: ArrayAdapter<Friend>? = null
    private var mFriendDB: FriendDB? = null

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.friends_list_layout)
        mFriendDB = (application as CraigApplication).friendDB
        val panel = findViewById<ListView>(R.id.friendList)
        mAdapter = FriendAdapter(this)
        panel.adapter = mAdapter

        CompletableFuture
            .supplyAsync<List<Friend>> { mFriendDB?.friendDao()?.all }
            .thenAcceptOnUiThread(this) { friends -> populateFriendList(friends) }

        registerForContextMenu(panel)

        panel.setOnItemClickListener { _, _, position, _ ->
            AlertDialog.Builder(this)
                .setTitle("Description")
                .setMessage(mAdapter?.getItem(position)?.description ?: "No Description Found")
                .setNeutralButton("OK") { _, _ -> }
                .show()
        }

        startActivityForResultWithButton(this, R.id.addFriendButton, AddFriendActivity::class.java)
        findViewById<View>(R.id.clearButton).setOnClickListener { deleteFriendList() }
        findViewById<View>(R.id.homeButtonFriendList).setOnClickListener { finish() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        recreate()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if (v!!.id != R.id.friendList) return
        val lv = v as ListView
        val acmi = menuInfo as AdapterContextMenuInfo
        val friend = lv.getItemAtPosition(acmi.position) as Friend

        menu!!.add("Delete Friend").setOnMenuItemClickListener {
            CompletableFuture
                .runAsync { mFriendDB?.friendDao()?.delete(friend) }
                .thenRunOnUiThread(this) { recreate() }
            true
        }
    }

    private fun populateFriendList(friends: List<Friend>?) {
        for (friend in friends ?: emptyList()) {
            Log.i(CraigApplication.TAG, friends?.indexOf(friend).toString())
            mAdapter!!.add(friend)
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
