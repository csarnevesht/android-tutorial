package com.example.androidtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

public class TrophyAdapter extends FirestoreRecyclerAdapter<Trophy, TrophyHolder>  {

    public TrophyAdapter(@NonNull FirestoreRecyclerOptions<Trophy> options, Context context, ArrayList<Trophy> trophies) {
        super(options);
    }

    @Override
    public TrophyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trophies_item, parent, false);
        TrophyHolder viewHolder = new TrophyHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindViewHolder(@NonNull TrophyHolder trophyHolder, int position, @NonNull Trophy trophy) {
        trophyHolder.setDetails(trophy);
    }
}
