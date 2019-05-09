package com.example.androidtutorial;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TrophyHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private TextView txtDescription;

    public TrophyHolder(View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
    }

    public void setDetails(Trophy trophy) {
        txtTitle.setText(trophy.getTitle());
        txtDescription.setText(trophy.getDescription());
    }
}
