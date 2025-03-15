package com.example.java_yay;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.IdRes;

public class UtilityFunctions {
    /**
     * Takes the button and adds a click listener that starts the activity
     * @param activity the activity in which the button resides
     * @param resId the resource ID to the button
     * @param klass the activity class reference that the button is to navigate to
     *
     * @throws ActivityNotFoundException if you forget the klass in the manifest (that darn manifest)
     */
    public static void startActivityWithButton(Activity activity, @IdRes int resId, Class<? extends Activity> klass) {
        Button button = activity.findViewById(resId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(activity, klass);
            try {
                activity.startActivity(intent);
            }
            catch (ActivityNotFoundException e) {
                String messageString = "You forgot to declare " + klass.getName() + " in the manifest!";
                Log.e(CraigApplication.TAG, messageString);
                throw e;
            }
        });
    }
}
