package com.example.java_yay

import android.app.Activity
import android.util.Log
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

fun <T> CompletableFuture<T>.thenRunOnUiThread(activity: Activity, runnable: Runnable): CompletableFuture<Void> {
    return exceptionally { t -> myExceptionally(activity, t) }
        .thenRun { activity.runOnUiThread(runnable) }
}

fun <T> CompletableFuture<T>.thenAcceptOnUiThread(activity: Activity, consumer: Consumer<T>): CompletableFuture<Void> {
    return exceptionally { t -> myExceptionally(activity, t) }
        .thenAccept { t -> activity.runOnUiThread { consumer.accept(t) } }
}

private fun <T> myExceptionally(activity: Activity, throwable: Throwable): T? {
    activity.runOnUiThread { Log.e(CraigApplication.TAG, Log.getStackTraceString(throwable)) }
    return null
}