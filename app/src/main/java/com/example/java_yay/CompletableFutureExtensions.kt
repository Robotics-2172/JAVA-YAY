package com.example.java_yay

import android.app.Activity
import android.app.AlertDialog
import android.util.Log
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

fun <T> CompletableFuture<T>.thenRunOnUiThread(activity: Activity, runnable: Runnable): CompletableFuture<Void> {
    return myExceptionally(activity).thenRun { activity.runOnUiThread(runnable) }
}

fun <T> CompletableFuture<T>.thenAcceptOnUiThread(activity: Activity, consumer: Consumer<T>): CompletableFuture<Void> {
    return myExceptionally(activity).thenAccept { t -> activity.runOnUiThread { consumer.accept(t) } }
}

fun <T> CompletableFuture<T>.myExceptionally(activity: Activity): CompletableFuture<T> {
    return exceptionally { throwable ->
        activity.runOnUiThread {
            AlertDialog.Builder(activity)
                .setTitle("Database Error")
                .setMessage("Check logs for details")
                .setNeutralButton("OK") {_, _ -> }
                .show()
            Log.e(CraigApplication.TAG, Log.getStackTraceString(throwable))
        }
        null
    }
}