package com.example.java_yay;

import static com.example.java_yay.UtilityFunctions.dateToString;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FriendAdapter extends ArrayAdapter<Friend> {
    public FriendAdapter(@NonNull Context context) {
        super(context, 0, new ArrayList<>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.friend_item_layout, parent, false);
        }
        Friend friend = getItem(position);
        TextView friendNameText = currentItemView.findViewById(R.id.friendNameText);
        assert friend != null;
        friendNameText.setText(friend.name);
        TextView friendBirthdayText = currentItemView.findViewById(R.id.friendBirthdayText);
        friendBirthdayText.setText(dateToString(friend.birthday));
        return currentItemView;
    }
}
